package com.example.satishassignment.model;

import com.google.gson.annotations.SerializedName;

public class Vote_down_reason
{
    private String Repost;

    @SerializedName("Referral link")

    private String Referral_link;

    @SerializedName("Invalid/User Specific Coupon/Deal")
    private String Invalid_User_Specific_CouponDeal;

    public String getRepost ()
    {
        return Repost;
    }

    public void setRepost (String Repost)
    {
        this.Repost = Repost;
    }


    public String getReferral_link() {
        return Referral_link;
    }

    public void setReferral_link(String referral_link) {
        Referral_link = referral_link;
    }

    public String getInvalid_User_Specific_CouponDeal() {
        return Invalid_User_Specific_CouponDeal;
    }

    public void setInvalid_User_Specific_CouponDeal(String invalid_User_Specific_CouponDeal) {
        Invalid_User_Specific_CouponDeal = invalid_User_Specific_CouponDeal;
    }
}
	