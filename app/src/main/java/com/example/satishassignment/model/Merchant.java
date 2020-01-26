package com.example.satishassignment.model;

public class Merchant
{
    private String image;

    private String name;

    private String recommendation_flag;

    private String recommendation;

    private String average_rating;

    private String id;

    private String permalink;

    public String getImage ()
    {
        return image;
    }

    public void setImage (String image)
    {
        this.image = image;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getRecommendation_flag ()
    {
        return recommendation_flag;
    }

    public void setRecommendation_flag (String recommendation_flag)
    {
        this.recommendation_flag = recommendation_flag;
    }

    public String getRecommendation ()
    {
        return recommendation;
    }

    public void setRecommendation (String recommendation)
    {
        this.recommendation = recommendation;
    }

    public String getAverage_rating ()
    {
        return average_rating;
    }

    public void setAverage_rating (String average_rating)
    {
        this.average_rating = average_rating;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getPermalink ()
    {
        return permalink;
    }

    public void setPermalink (String permalink)
    {
        this.permalink = permalink;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [image = "+image+", name = "+name+", recommendation_flag = "+recommendation_flag+", recommendation = "+recommendation+", average_rating = "+average_rating+", id = "+id+", permalink = "+permalink+"]";
    }
}