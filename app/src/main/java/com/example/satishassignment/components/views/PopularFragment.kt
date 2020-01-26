package com.example.satishassignment.components.views

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.satishassignment.R
import com.example.satishassignment.adapter.TopListAdapter
import com.example.satishassignment.components.core.GetDataContract
import com.example.satishassignment.components.core.Presenter
import com.example.satishassignment.model.Data


class PopularFragment : Fragment(), GetDataContract.View {

    private var mPresenter: Presenter? = null
    private var topListAdapter : TopListAdapter?=null
    private var progressBar: RelativeLayout? = null
    private var pageIndex = 1
    private var recyclerView : RecyclerView?=null
    private var linearLayoutManager: LinearLayoutManager? = null
    private var serverErrorLyt : LinearLayout?=null
    private var dataList : java.util.ArrayList<Data> = ArrayList()
    @RequiresApi(Build.VERSION_CODES.M)
    val apiUrl : String="https://stagingapi.desidime.com/v3/deals/popular.json?per_page=10&page="
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view=inflater.inflate(R.layout.fragment_popular, container, false)


        mPresenter = Presenter(this)
        recyclerView=view.findViewById(R.id.popular_list)
        mPresenter!!.getDataFromURL(activity, apiUrl+pageIndex)
        serverErrorLyt=view.findViewById(R.id.server_error_lyt)

        progressBar = view.findViewById(R.id.popular_progress_lyt) as RelativeLayout

        topListAdapter = TopListAdapter(activity,dataList)
        linearLayoutManager = LinearLayoutManager(activity)
        recyclerView?.layoutManager= linearLayoutManager
        recyclerView?.adapter=topListAdapter

        var swipe_refresh=view.findViewById<SwipeRefreshLayout>(R.id.popular_list_refresh)
        swipe_refresh.setColorSchemeResources(R.color.colorAccent)

        swipe_refresh.setOnRefreshListener {

            dataList.clear()
            topListAdapter?.notifyDataSetChanged()
            mPresenter!!.getDataFromURL(activity, apiUrl+0)
            swipe_refresh.isRefreshing=false
        }

        recyclerView?.setOnScrollChangeListener { view, i, i1, i2, i3 ->

            getData()
        }



//
        return view
    }

    override fun onGetDataSuccess(list: java.util.ArrayList<Data>?) {
        progressBar?.visibility=View.GONE

        for (i in 0 until list?.size!!){

            dataList.add(list[i])
        }


        topListAdapter?.notifyDataSetChanged()

    }

    override fun onGetDataFailure(status: Int) {
        progressBar?.visibility=View.GONE
        if (status==400){

            serverErrorLyt?.visibility=View.VISIBLE
        }else{
            pageIndex--

            serverErrorLyt?.visibility=View.GONE

        }
    }

    private fun isLastItemDisplaying(recyclerView: RecyclerView): Boolean {
        if (recyclerView.adapter?.itemCount !== 0) {
            val lastVisibleItemPosition =
                (recyclerView.layoutManager as LinearLayoutManager).findLastCompletelyVisibleItemPosition()
            if (lastVisibleItemPosition != RecyclerView.NO_POSITION && lastVisibleItemPosition == recyclerView.adapter?.itemCount!! - 1)
                return true
        }
        return false
    }


    fun getData(){

        if (recyclerView?.let { isLastItemDisplaying(it) }!!){

            mPresenter!!.getDataFromURL(activity, apiUrl+pageIndex)

            progressBar?.visibility=View.VISIBLE
            pageIndex++

        }
    }




}
