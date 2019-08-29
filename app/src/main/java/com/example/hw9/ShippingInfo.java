/**
  * Copyright 2019 bejson.com 
  */
package com.example.hw9;
import java.util.List;

public class ShippingInfo {

    private List<ShippingServiceCost> shippingServiceCost;
    private List<String> shippingType;
    private List<String> shipToLocations;
    private List<String> expeditedShipping;
    private List<String> oneDayShippingAvailable;
    private List<String> handlingTime;
    public void setShippingServiceCost(List<ShippingServiceCost> shippingServiceCost) {
         this.shippingServiceCost = shippingServiceCost;
     }
     public List<ShippingServiceCost> getShippingServiceCost() {
         return shippingServiceCost;
     }

    public void setShippingType(List<String> shippingType) {
         this.shippingType = shippingType;
     }
     public List<String> getShippingType() {
         return shippingType;
     }

    public void setShipToLocations(List<String> shipToLocations) {
         this.shipToLocations = shipToLocations;
     }
     public List<String> getShipToLocations() {
         return shipToLocations;
     }

    public void setExpeditedShipping(List<String> expeditedShipping) {
         this.expeditedShipping = expeditedShipping;
     }
     public List<String> getExpeditedShipping() {
         return expeditedShipping;
     }

    public void setOneDayShippingAvailable(List<String> oneDayShippingAvailable) {
         this.oneDayShippingAvailable = oneDayShippingAvailable;
     }
     public List<String> getOneDayShippingAvailable() {
         return oneDayShippingAvailable;
     }

    public void setHandlingTime(List<String> handlingTime) {
         this.handlingTime = handlingTime;
     }
     public List<String> getHandlingTime() {
         return handlingTime;
     }

}