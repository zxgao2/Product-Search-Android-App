/**
  * Copyright 2019 bejson.com 
  */
package com.example.hw9;


public class CurrentPrice1 {

    private String Value;
    private String CurrencyID;
    public void setValue(String Value) {
         this.Value = Value;
     }
     public String getValue() {
         return Value;
     }

    public void setCurrencyID(String CurrencyID) {
         this.CurrencyID = CurrencyID;
     }
     public String getCurrencyID() {
         return CurrencyID;
     }

}