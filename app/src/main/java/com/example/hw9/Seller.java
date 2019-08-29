/**
  * Copyright 2019 bejson.com 
  */
package com.example.hw9;

public class Seller {

    private String UserID;
    private String FeedbackRatingStar;
    private String FeedbackScore;
    private String PositiveFeedbackPercent;
    private boolean TopRatedSeller;
    public void setUserID(String UserID) {
         this.UserID = UserID;
     }
     public String getUserID() {
         return UserID;
     }

    public void setFeedbackRatingStar(String FeedbackRatingStar) {
         this.FeedbackRatingStar = FeedbackRatingStar;
     }
     public String getFeedbackRatingStar() {
         return FeedbackRatingStar;
     }

    public void setFeedbackScore(String FeedbackScore) {
         this.FeedbackScore = FeedbackScore;
     }
     public String getFeedbackScore() {
         return FeedbackScore;
     }

    public void setPositiveFeedbackPercent(String PositiveFeedbackPercent) {
         this.PositiveFeedbackPercent = PositiveFeedbackPercent;
     }
     public String getPositiveFeedbackPercent() {
         return PositiveFeedbackPercent;
     }

    public void setTopRatedSeller(boolean TopRatedSeller) {
         this.TopRatedSeller = TopRatedSeller;
     }
     public boolean getTopRatedSeller() {
         return TopRatedSeller;
     }

}