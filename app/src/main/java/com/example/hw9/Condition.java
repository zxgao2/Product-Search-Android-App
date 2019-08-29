/**
  * Copyright 2019 bejson.com 
  */
package com.example.hw9;
import java.util.List;


public class Condition {

    private List<String> conditionId;
    private List<String> conditionDisplayName;
    public void setConditionId(List<String> conditionId) {
         this.conditionId = conditionId;
     }
     public List<String> getConditionId() {
         return conditionId;
     }

    public void setConditionDisplayName(List<String> conditionDisplayName) {
         this.conditionDisplayName = conditionDisplayName;
     }
     public List<String> getConditionDisplayName() {
         return conditionDisplayName;
     }

}