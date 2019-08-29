/**
  * Copyright 2019 bejson.com 
  */
package com.example.hw9;
import java.util.Date;


public class detailPro {

    private Date Timestamp;
    private String Ack;
    private String Build;
    private String Version;
    private Item1 Item;
    public void setTimestamp(Date Timestamp) {
         this.Timestamp = Timestamp;
     }
     public Date getTimestamp() {
         return Timestamp;
     }

    public void setAck(String Ack) {
         this.Ack = Ack;
     }
     public String getAck() {
         return Ack;
     }

    public void setBuild(String Build) {
         this.Build = Build;
     }
     public String getBuild() {
         return Build;
     }

    public void setVersion(String Version) {
         this.Version = Version;
     }
     public String getVersion() {
         return Version;
     }

    public void setItem(Item1 Item) {
         this.Item = Item;
     }
     public Item1 getItem() {
         return Item;
     }

}