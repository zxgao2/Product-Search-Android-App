/**
  * Copyright 2019 bejson.com 
  */
package com.example.hw9;
import java.util.List;
import java.util.Date;



public class FindItemsAdvancedResponse {

    private List<String> ack;
    private List<String> version;
   // private List<String> timestamp;
    private List<SearchResult> searchResult;
    private List<PaginationOutput> paginationOutput;
    private List<String> itemSearchURL;
    public void setAck(List<String> ack) {
         this.ack = ack;
     }
     public List<String> getAck() {
         return ack;
     }

    public void setVersion(List<String> version) {
         this.version = version;
     }
     public List<String> getVersion() {
         return version;
     }

   /* public void setTimestamp(Date timestamp) {
         this.timestamp = timestamp;
     }
     public Date getTimestamp() {
         return timestamp;
     }*/

    public void setSearchResult(List<SearchResult> searchResult) {
         this.searchResult = searchResult;
     }
     public List<SearchResult> getSearchResult() {
         return searchResult;
     }

    public void setPaginationOutput(List<PaginationOutput> paginationOutput) {
         this.paginationOutput = paginationOutput;
     }
     public List<PaginationOutput> getPaginationOutput() {
         return paginationOutput;
     }

    public void setItemSearchURL(List<String> itemSearchURL) {
         this.itemSearchURL = itemSearchURL;
     }
     public List<String> getItemSearchURL() {
         return itemSearchURL;
     }

}