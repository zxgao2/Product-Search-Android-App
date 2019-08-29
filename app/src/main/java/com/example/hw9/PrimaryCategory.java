/**
  * Copyright 2019 bejson.com 
  */
package com.example.hw9;
import java.util.List;

public class PrimaryCategory {

    private List<String> categoryId;
    private List<String> categoryName;
    public void setCategoryId(List<String> categoryId) {
         this.categoryId = categoryId;
     }
     public List<String> getCategoryId() {
         return categoryId;
     }

    public void setCategoryName(List<String> categoryName) {
         this.categoryName = categoryName;
     }
     public List<String> getCategoryName() {
         return categoryName;
     }

}