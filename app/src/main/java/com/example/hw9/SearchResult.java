/**
  * Copyright 2019 bejson.com 
  */
package com.example.hw9;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class SearchResult {
    @SerializedName("@count")
    private String count;
    private List<Item> item;
    public void setCount(String count) {
        this. count =count ;
    }
     public String getCount() {
         return count;
     }

    public void setItem(List<Item> item) {
         this.item = item;
     }
     public List<Item> getItem() {
         return item;
     }

}