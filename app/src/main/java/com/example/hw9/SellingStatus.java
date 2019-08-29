/**
  * Copyright 2019 bejson.com 
  */
package com.example.hw9;
import java.util.List;


public class SellingStatus {

    private List<CurrentPrice> currentPrice;
    private List<ConvertedCurrentPrice> convertedCurrentPrice;
    private List<String> sellingState;
    private List<String> timeLeft;
    public void setCurrentPrice(List<CurrentPrice> currentPrice) {
         this.currentPrice = currentPrice;
     }
     public List<CurrentPrice> getCurrentPrice() {
         return currentPrice;
     }

    public void setConvertedCurrentPrice(List<ConvertedCurrentPrice> convertedCurrentPrice) {
         this.convertedCurrentPrice = convertedCurrentPrice;
     }
     public List<ConvertedCurrentPrice> getConvertedCurrentPrice() {
         return convertedCurrentPrice;
     }

    public void setSellingState(List<String> sellingState) {
         this.sellingState = sellingState;
     }
     public List<String> getSellingState() {
         return sellingState;
     }

    public void setTimeLeft(List<String> timeLeft) {
         this.timeLeft = timeLeft;
     }
     public List<String> getTimeLeft() {
         return timeLeft;
     }

}