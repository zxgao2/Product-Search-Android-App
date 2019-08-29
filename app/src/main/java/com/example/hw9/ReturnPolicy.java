/**
  * Copyright 2019 bejson.com 
  */
package com.example.hw9;


public class ReturnPolicy {

    private String Refund;
    private String ReturnsWithin;
    private String ReturnsAccepted;
    private String ShippingCostPaidBy;
    private String InternationalReturnsAccepted;
    public void setRefund(String Refund) {
         this.Refund = Refund;
     }
     public String getRefund() {
         return Refund;
     }

    public void setReturnsWithin(String ReturnsWithin) {
         this.ReturnsWithin = ReturnsWithin;
     }
     public String getReturnsWithin() {
         return ReturnsWithin;
     }

    public void setReturnsAccepted(String ReturnsAccepted) {
         this.ReturnsAccepted = ReturnsAccepted;
     }
     public String getReturnsAccepted() {
         return ReturnsAccepted;
     }

    public void setShippingCostPaidBy(String ShippingCostPaidBy) {
         this.ShippingCostPaidBy = ShippingCostPaidBy;
     }
     public String getShippingCostPaidBy() {
         return ShippingCostPaidBy;
     }

    public void setInternationalReturnsAccepted(String InternationalReturnsAccepted) {
         this.InternationalReturnsAccepted = InternationalReturnsAccepted;
     }
     public String getInternationalReturnsAccepted() {
         return InternationalReturnsAccepted;
     }

}