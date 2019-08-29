/**
  * Copyright 2019 bejson.com 
  */
package com.example.hw9;
import java.util.List;


public class SellerInfo {

    private List<String> sellerUserName;
    private List<String> feedbackScore;
    private List<String> positiveFeedbackPercent;
    private List<String> feedbackRatingStar;
    private List<String> topRatedSeller;
    public void setSellerUserName(List<String> sellerUserName) {
         this.sellerUserName = sellerUserName;
     }
     public List<String> getSellerUserName() {
         return sellerUserName;
     }

    public void setFeedbackScore(List<String> feedbackScore) {
         this.feedbackScore = feedbackScore;
     }
     public List<String> getFeedbackScore() {
         return feedbackScore;
     }

    public void setPositiveFeedbackPercent(List<String> positiveFeedbackPercent) {
         this.positiveFeedbackPercent = positiveFeedbackPercent;
     }
     public List<String> getPositiveFeedbackPercent() {
         return positiveFeedbackPercent;
     }

    public void setFeedbackRatingStar(List<String> feedbackRatingStar) {
         this.feedbackRatingStar = feedbackRatingStar;
     }
     public List<String> getFeedbackRatingStar() {
         return feedbackRatingStar;
     }

    public void setTopRatedSeller(List<String> topRatedSeller) {
         this.topRatedSeller = topRatedSeller;
     }
     public List<String> getTopRatedSeller() {
         return topRatedSeller;
     }

}