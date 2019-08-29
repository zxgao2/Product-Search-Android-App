/**
  * Copyright 2019 bejson.com 
  */
package com.example.hw9;
import java.util.List;


public class Item {

    private List<String> itemId;
    private List<String> title;
    private List<String> globalId;
    private List<PrimaryCategory> primaryCategory;
    private List<String> galleryURL;
    private List<String> viewItemURL;
    private List<String> paymentMethod;
    private List<String> autoPay;
    private List<String> postalCode;
    private List<String> location;
    private List<String> country;
    private List<StoreInfo> storeInfo;
    private List<SellerInfo> sellerInfo;
    private List<ShippingInfo> shippingInfo;
    private List<SellingStatus> sellingStatus;
   // private List<ListingInfo> listingInfo;
    private List<String> returnsAccepted;
    private List<Distance> distance;
    private List<Condition> condition;
    private List<String> isMultiVariationListing;
    private List<String> topRatedListing;
    public void setItemId(List<String> itemId) {
         this.itemId = itemId;
     }
     public List<String> getItemId() {
         return itemId;
     }

    public void setTitle(List<String> title) {
         this.title = title;
     }
     public List<String> getTitle() {
         return title;
     }

    public void setGlobalId(List<String> globalId) {
         this.globalId = globalId;
     }
     public List<String> getGlobalId() {
         return globalId;
     }

    public void setPrimaryCategory(List<PrimaryCategory> primaryCategory) {
         this.primaryCategory = primaryCategory;
     }
     public List<PrimaryCategory> getPrimaryCategory() {
         return primaryCategory;
     }

    public void setGalleryURL(List<String> galleryURL) {
         this.galleryURL = galleryURL;
     }
     public List<String> getGalleryURL() {
         return galleryURL;
     }

    public void setViewItemURL(List<String> viewItemURL) {
         this.viewItemURL = viewItemURL;
     }
     public List<String> getViewItemURL() {
         return viewItemURL;
     }

    public void setPaymentMethod(List<String> paymentMethod) {
         this.paymentMethod = paymentMethod;
     }
     public List<String> getPaymentMethod() {
         return paymentMethod;
     }

    public void setAutoPay(List<String> autoPay) {
         this.autoPay = autoPay;
     }
     public List<String> getAutoPay() {
         return autoPay;
     }

    public void setPostalCode(List<String> postalCode) {
         this.postalCode = postalCode;
     }
     public List<String> getPostalCode() {
         return postalCode;
     }

    public void setLocation(List<String> location) {
         this.location = location;
     }
     public List<String> getLocation() {
         return location;
     }

    public void setCountry(List<String> country) {
         this.country = country;
     }
     public List<String> getCountry() {
         return country;
     }

    public void setStoreInfo(List<StoreInfo> storeInfo) {
         this.storeInfo = storeInfo;
     }
     public List<StoreInfo> getStoreInfo() {
         return storeInfo;
     }

    public void setSellerInfo(List<SellerInfo> sellerInfo) {
         this.sellerInfo = sellerInfo;
     }
     public List<SellerInfo> getSellerInfo() {
         return sellerInfo;
     }

    public void setShippingInfo(List<ShippingInfo> shippingInfo) {
         this.shippingInfo = shippingInfo;
     }
     public List<ShippingInfo> getShippingInfo() {
         return shippingInfo;
     }

    public void setSellingStatus(List<SellingStatus> sellingStatus) {
         this.sellingStatus = sellingStatus;
     }
     public List<SellingStatus> getSellingStatus() {
         return sellingStatus;
     }

   /* public void setListingInfo(List<ListingInfo> listingInfo) {
         this.listingInfo = listingInfo;
     }
     public List<ListingInfo> getListingInfo() {
         return listingInfo;
     }*/

    public void setReturnsAccepted(List<String> returnsAccepted) {
         this.returnsAccepted = returnsAccepted;
     }
     public List<String> getReturnsAccepted() {
         return returnsAccepted;
     }

    public void setDistance(List<Distance> distance) {
         this.distance = distance;
     }
     public List<Distance> getDistance() {
         return distance;
     }

    public void setCondition(List<Condition> condition) {
         this.condition = condition;
     }
     public List<Condition> getCondition() {
         return condition;
     }

    public void setIsMultiVariationListing(List<String> isMultiVariationListing) {
         this.isMultiVariationListing = isMultiVariationListing;
     }
     public List<String> getIsMultiVariationListing() {
         return isMultiVariationListing;
     }

    public void setTopRatedListing(List<String> topRatedListing) {
         this.topRatedListing = topRatedListing;
     }
     public List<String> getTopRatedListing() {
         return topRatedListing;
     }

}