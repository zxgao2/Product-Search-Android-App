/**
  * Copyright 2019 bejson.com 
  */
package com.example.hw9;
import java.util.Date;


public class GetSimilarItemsResponse {

    private String ack;
  //  private String version;
  //  private String timestamp;
    private ItemRecommendations itemRecommendations;
    public void setAck(String ack) {
         this.ack = ack;
     }
     public String getAck() {
         return ack;
     }




    public void setItemRecommendations(ItemRecommendations itemRecommendations) {
         this.itemRecommendations = itemRecommendations;
     }
     public ItemRecommendations getItemRecommendations() {
         return itemRecommendations;
     }

}