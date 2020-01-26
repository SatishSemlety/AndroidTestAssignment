package com.example.satishassignment.model;

public class Seo_setting
{
    private String web_url;

    private String description;

    private String title;

    public String getWeb_url ()
    {
        return web_url;
    }

    public void setWeb_url (String web_url)
    {
        this.web_url = web_url;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [web_url = "+web_url+", description = "+description+", title = "+title+"]";
    }
}