/**
  * Copyright 2019 bejson.com 
  */
package com.example.hw9;
import java.util.List;


public class NameValueList {

    private String Name;
    private List<String> Value;
    public void setName(String Name) {
         this.Name = Name;
     }
     public String getName() {
         return Name;
     }

    public void setValue(List<String> Value) {
         this.Value = Value;
     }
     public List<String> getValue() {
         return Value;
     }

}