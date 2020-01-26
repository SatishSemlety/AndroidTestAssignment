package com.example.satishassignment.model;

import java.util.ArrayList;

public class Deals
{
    private ArrayList<Data> data;

    private String total_count;

    public ArrayList<Data> getData ()
    {
        return data;
    }

    public void setData (ArrayList<Data> data)
    {
        this.data = data;
    }

    public String getTotal_count ()
    {
        return total_count;
    }

    public void setTotal_count (String total_count)
    {
        this.total_count = total_count;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [data = "+data+", total_count = "+total_count+"]";
    }
}
