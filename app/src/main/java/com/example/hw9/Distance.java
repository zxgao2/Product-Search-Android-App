/**
  * Copyright 2019 bejson.com 
  */
package com.example.hw9;

import com.google.gson.annotations.SerializedName;

public class Distance {
    @SerializedName("@unit")
    private String unit;
    private String __value__;
    public void setUnit(String unit) {
         this.unit = unit;
     }
     public String getUnit() {
         return unit;
     }

    public void set__value__(String __value__) {
         this.__value__ = __value__;
     }
     public String get__value__() {
         return __value__;
     }

}