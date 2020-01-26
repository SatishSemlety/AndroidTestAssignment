package com.example.satishassignment.model;

public class User
{
    private String fpd_count;

    private String image;

    private String karma;

    private String name;

    private String rank;

    private String current_dimes;

    private String id;

    public String getFpd_count ()
    {
        return fpd_count;
    }

    public void setFpd_count (String fpd_count)
    {
        this.fpd_count = fpd_count;
    }

    public String getImage ()
    {
        return image;
    }

    public void setImage (String image)
    {
        this.image = image;
    }

    public String getKarma ()
    {
        return karma;
    }

    public void setKarma (String karma)
    {
        this.karma = karma;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getRank ()
    {
        return rank;
    }

    public void setRank (String rank)
    {
        this.rank = rank;
    }

    public String getCurrent_dimes ()
    {
        return current_dimes;
    }

    public void setCurrent_dimes (String current_dimes)
    {
        this.current_dimes = current_dimes;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [fpd_count = "+fpd_count+", image = "+image+", karma = "+karma+", name = "+name+", rank = "+rank+", current_dimes = "+current_dimes+", id = "+id+"]";
    }
}