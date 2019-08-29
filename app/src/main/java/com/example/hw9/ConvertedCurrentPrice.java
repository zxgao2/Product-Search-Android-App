/**
  * Copyright 2019 bejson.com 
  */
package com.example.hw9;
import com.google.gson.annotations.SerializedName;

public class ConvertedCurrentPrice {
    @SerializedName("@currencyId")
    private String currencyId;
    private String __value__;
    public void setCurrencyId(String currencyId) {
         this.currencyId = currencyId;
     }
     public String getCurrencyId() {
         return currencyId;
     }

    public void set__value__(String __value__) {
         this.__value__ = __value__;
     }
     public String get__value__() {
         return __value__;
     }

}