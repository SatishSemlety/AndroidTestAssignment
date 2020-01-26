package com.example.satishassignment.activity

import android.content.Context
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import com.example.satishassignment.R
import com.example.satishassignment.adapter.MainPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.home_content.*
import com.example.satishassignment.components.views.FeaturedFragment
import com.example.satishassignment.components.views.NotificationFragment
import com.example.satishassignment.components.views.PopularFragment
import com.example.satishassignment.helper.ConnectivityReceiver
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity(),ConnectivityReceiver.ConnectivityReceiverListener {


    var snackBar: Snackbar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setStatePageAdapter()

        registerReceiver(ConnectivityReceiver(), IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))

        menu_icon.setOnClickListener{

            drawer_layout.openDrawer(Gravity.LEFT)
        }
    }

    private fun setStatePageAdapter(){
        val adapter =
            MainPagerAdapter(supportFragmentManager )
        adapter.addFragment(NotificationFragment(),"TOP")
        adapter.addFragment(PopularFragment(),"POPULAR")
        adapter.addFragment(FeaturedFragment(),"FEATURED")
        viewpager.adapter=adapter
        tabLayout.setupWithViewPager(viewpager)

    }

    override fun onBackPressed() {

        if (drawer_layout.isDrawerOpen(Gravity.LEFT)) {

            drawer_layout.closeDrawer(Gravity.LEFT)
        } else {
            super.onBackPressed()
        }

    }

    override fun onNetworkConnectionChanged(isConnected: Boolean) {
        showNetworkMessage(isConnected)
    }

    override fun onResume() {
        super.onResume()
        ConnectivityReceiver.connectivityReceiverListener = this
    }

    private fun showNetworkMessage(isConnected: Boolean) {
        if (!isConnected) {

            snackBar = Snackbar.make(findViewById(R.id.container), "You are offline", Snackbar.LENGTH_LONG)
            snackBar?.duration = BaseTransientBottomBar.LENGTH_INDEFINITE
            snackBar?.show()
        } else {
            snackBar?.dismiss()
        }
    }
}


