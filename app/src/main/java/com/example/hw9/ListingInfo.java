/**
  * Copyright 2019 bejson.com 
  */
package com.example.hw9;
import java.util.List;
import java.util.Date;


public class ListingInfo {

    private List<String> bestOfferEnabled;
    private List<String> buyItNowAvailable;
    private Date startTime;
    private Date endTime;
    private List<String> listingType;
    private List<String> gift;
    public void setBestOfferEnabled(List<String> bestOfferEnabled) {
         this.bestOfferEnabled = bestOfferEnabled;
     }
     public List<String> getBestOfferEnabled() {
         return bestOfferEnabled;
     }

    public void setBuyItNowAvailable(List<String> buyItNowAvailable) {
         this.buyItNowAvailable = buyItNowAvailable;
     }
     public List<String> getBuyItNowAvailable() {
         return buyItNowAvailable;
     }

    public void setStartTime(Date startTime) {
         this.startTime = startTime;
     }
     public Date getStartTime() {
         return startTime;
     }

    public void setEndTime(Date endTime) {
         this.endTime = endTime;
     }
     public Date getEndTime() {
         return endTime;
     }

    public void setListingType(List<String> listingType) {
         this.listingType = listingType;
     }
     public List<String> getListingType() {
         return listingType;
     }

    public void setGift(List<String> gift) {
         this.gift = gift;
     }
     public List<String> getGift() {
         return gift;
     }

}