/**
  * Copyright 2019 bejson.com 
  */
package com.example.hw9;


public class Item2 {

    private String itemId;
    private String title;
    private String viewItemURL;
    private String globalId;
    private String timeLeft;
    private String primaryCategoryId;
    private String primaryCategoryName;
    private String country;
    private String imageURL;
    private String shippingType;
    private BuyItNowPrice buyItNowPrice;
    private ShippingCost shippingCost;
    public void setItemId(String itemId) {
         this.itemId = itemId;
     }
     public String getItemId() {
         return itemId;
     }

    public void setTitle(String title) {
         this.title = title;
     }
     public String getTitle() {
         return title;
     }

    public void setViewItemURL(String viewItemURL) {
         this.viewItemURL = viewItemURL;
     }
     public String getViewItemURL() {
         return viewItemURL;
     }

    public void setGlobalId(String globalId) {
         this.globalId = globalId;
     }
     public String getGlobalId() {
         return globalId;
     }

    public void setTimeLeft(String timeLeft) {
         this.timeLeft = timeLeft;
     }
     public String getTimeLeft() {
         return timeLeft;
     }

    public void setPrimaryCategoryId(String primaryCategoryId) {
         this.primaryCategoryId = primaryCategoryId;
     }
     public String getPrimaryCategoryId() {
         return primaryCategoryId;
     }

    public void setPrimaryCategoryName(String primaryCategoryName) {
         this.primaryCategoryName = primaryCategoryName;
     }
     public String getPrimaryCategoryName() {
         return primaryCategoryName;
     }

    public void setCountry(String country) {
         this.country = country;
     }
     public String getCountry() {
         return country;
     }

    public void setImageURL(String imageURL) {
         this.imageURL = imageURL;
     }
     public String getImageURL() {
         return imageURL;
     }

    public void setShippingType(String shippingType) {
         this.shippingType = shippingType;
     }
     public String getShippingType() {
         return shippingType;
     }

    public void setBuyItNowPrice(BuyItNowPrice buyItNowPrice) {
         this.buyItNowPrice = buyItNowPrice;
     }
     public BuyItNowPrice getBuyItNowPrice() {
         return buyItNowPrice;
     }

    public void setShippingCost(ShippingCost shippingCost) {
         this.shippingCost = shippingCost;
     }
     public ShippingCost getShippingCost() {
         return shippingCost;
     }

}