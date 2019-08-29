/**
  * Copyright 2019 bejson.com 
  */
package com.example.hw9;
import java.util.List;


public class StoreInfo {

    private List<String> storeName;
    private List<String> storeURL;
    public void setStoreName(List<String> storeName) {
         this.storeName = storeName;
     }
     public List<String> getStoreName() {
         return storeName;
     }

    public void setStoreURL(List<String> storeURL) {
         this.storeURL = storeURL;
     }
     public List<String> getStoreURL() {
         return storeURL;
     }

}