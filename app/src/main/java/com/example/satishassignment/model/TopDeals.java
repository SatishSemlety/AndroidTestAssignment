package com.example.satishassignment.model;

public class TopDeals
{
    private Deals deals;

    private Seo_setting seo_setting;

    public Deals getDeals ()
    {
        return deals;
    }

    public void setDeals (Deals deals)
    {
        this.deals = deals;
    }

    public Seo_setting getSeo_setting ()
    {
        return seo_setting;
    }

    public void setSeo_setting (Seo_setting seo_setting)
    {
        this.seo_setting = seo_setting;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [deals = "+deals+", seo_setting = "+seo_setting+"]";
    }
}
	