/**
  * Copyright 2019 bejson.com 
  */
package com.example.hw9;
import java.util.Date;
import java.util.List;


public class Item1 {

    private boolean BestOfferEnabled;
    private String Description;
    private String ItemID;
    private String Brand;
    private Date EndTime;
    private Date StartTime;
    private String ViewItemURLForNaturalSearch;
    private String ListingType;
    private String Location;
    private List<String> PaymentMethods;
    private String GalleryURL;
    private List<String> PictureURL;
    private String PostalCode;
   // private String SubTitle;
    private String PrimaryCategoryID;
    private String PrimaryCategoryName;
    private int Quantity;
    private Seller Seller;
    private int BidCount;
   // private ConvertedCurrentPrice ConvertedCurrentPrice;
    private CurrentPrice1 CurrentPrice;
    private String ListingStatus;
    private int QuantitySold;
    private List<String> ShipToLocations;
    private String Site;
    private String TimeLeft;
    private String Title;
    private ItemSpecifics ItemSpecifics;
    private long HitCount;
    private String Subtitle;
    private String PrimaryCategoryIDPath;
    private Storefront Storefront;
    private String Country;
    private ReturnPolicy ReturnPolicy;
    private boolean AutoPay;
    private List<String> PaymentAllowedSite;
    private boolean IntegratedMerchantCreditCardEnabled;
    private String HandlingTime;
    private int ConditionID;
    private String ConditionDisplayName;
    private String QuantityAvailableHint;
    private boolean TopRatedListing;
    private String GlobalShipping;
    private int QuantitySoldByPickupInStore;
    private boolean NewBestOffer;
    public void setBestOfferEnabled(boolean BestOfferEnabled) {
         this.BestOfferEnabled = BestOfferEnabled;
     }
     public boolean getBestOfferEnabled() {
         return BestOfferEnabled;
     }

    public void setDescription(String Description) {
         this.Description = Description;
     }
     public String getDescription() {
         return Description;
     }



    public void setItemID(String ItemID) {
        this.ItemID = ItemID;
    }
    public String getItemID() {
        return ItemID;
    }

    public void setBrand(String Brand) {
        this.Brand = Brand;
    }
    public String getBrand() {
        return Brand;
    }

    public void setEndTime(Date EndTime) {
         this.EndTime = EndTime;
     }
     public Date getEndTime() {
         return EndTime;
     }

    public void setStartTime(Date StartTime) {
         this.StartTime = StartTime;
     }
     public Date getStartTime() {
         return StartTime;
     }

    public void setViewItemURLForNaturalSearch(String ViewItemURLForNaturalSearch) {
         this.ViewItemURLForNaturalSearch = ViewItemURLForNaturalSearch;
     }
     public String getViewItemURLForNaturalSearch() {
         return ViewItemURLForNaturalSearch;
     }

    public void setListingType(String ListingType) {
         this.ListingType = ListingType;
     }
     public String getListingType() {
         return ListingType;
     }

    public void setLocation(String Location) {
         this.Location = Location;
     }
     public String getLocation() {
         return Location;
     }

    public void setPaymentMethods(List<String> PaymentMethods) {
         this.PaymentMethods = PaymentMethods;
     }
     public List<String> getPaymentMethods() {
         return PaymentMethods;
     }

    public void setGalleryURL(String GalleryURL) {
         this.GalleryURL = GalleryURL;
     }
     public String getGalleryURL() {
         return GalleryURL;
     }

    public void setPictureURL(List<String> PictureURL) {
         this.PictureURL = PictureURL;
     }
     public List<String> getPictureURL() {
         return PictureURL;
     }

    public void setPostalCode(String PostalCode) {
         this.PostalCode = PostalCode;
     }
     public String getPostalCode() {
         return PostalCode;
     }

    public void setPrimaryCategoryID(String PrimaryCategoryID) {
         this.PrimaryCategoryID = PrimaryCategoryID;
     }
     public String getPrimaryCategoryID() {
         return PrimaryCategoryID;
     }

    public void setPrimaryCategoryName(String PrimaryCategoryName) {
         this.PrimaryCategoryName = PrimaryCategoryName;
     }
     public String getPrimaryCategoryName() {
         return PrimaryCategoryName;
     }

    public void setQuantity(int Quantity) {
         this.Quantity = Quantity;
     }
     public int getQuantity() {
         return Quantity;
     }

    public void setSeller(Seller Seller) {
         this.Seller = Seller;
     }
     public Seller getSeller() {
         return Seller;
     }

    public void setBidCount(int BidCount) {
         this.BidCount = BidCount;
     }
     public int getBidCount() {
         return BidCount;
     }

    /*public void setConvertedCurrentPrice(ConvertedCurrentPrice ConvertedCurrentPrice) {
         this.ConvertedCurrentPrice = ConvertedCurrentPrice;
     }
     public ConvertedCurrentPrice getConvertedCurrentPrice() {
         return ConvertedCurrentPrice;
     }
*/
    public void setCurrentPrice(CurrentPrice1 CurrentPrice) {
         this.CurrentPrice = CurrentPrice;
     }
     public CurrentPrice1 getCurrentPrice() {
         return CurrentPrice;
     }

    public void setListingStatus(String ListingStatus) {
         this.ListingStatus = ListingStatus;
     }
     public String getListingStatus() {
         return ListingStatus;
     }

    public void setQuantitySold(int QuantitySold) {
         this.QuantitySold = QuantitySold;
     }
     public int getQuantitySold() {
         return QuantitySold;
     }

    public void setShipToLocations(List<String> ShipToLocations) {
         this.ShipToLocations = ShipToLocations;
     }
     public List<String> getShipToLocations() {
         return ShipToLocations;
     }

    public void setSite(String Site) {
         this.Site = Site;
     }
     public String getSite() {
         return Site;
     }

    public void setTimeLeft(String TimeLeft) {
         this.TimeLeft = TimeLeft;
     }
     public String getTimeLeft() {
         return TimeLeft;
     }

    public void setTitle(String Title) {
         this.Title = Title;
     }
     public String getTitle() {
         return Title;
     }

    public void setItemSpecifics(ItemSpecifics ItemSpecifics) {
         this.ItemSpecifics = ItemSpecifics;
     }
     public ItemSpecifics getItemSpecifics() {
         return ItemSpecifics;
     }

    public void setHitCount(long HitCount) {
         this.HitCount = HitCount;
     }
     public long getHitCount() {
         return HitCount;
     }

    public void setSubtitle(String Subtitle) {
         this.Subtitle = Subtitle;
     }
     public String getSubtitle() {
         return Subtitle;
     }

    public void setPrimaryCategoryIDPath(String PrimaryCategoryIDPath) {
         this.PrimaryCategoryIDPath = PrimaryCategoryIDPath;
     }
     public String getPrimaryCategoryIDPath() {
         return PrimaryCategoryIDPath;
     }

    public void setStorefront(Storefront Storefront) {
         this.Storefront = Storefront;
     }
     public Storefront getStorefront() {
         return Storefront;
     }

    public void setCountry(String Country) {
         this.Country = Country;
     }
     public String getCountry() {
         return Country;
     }

    public void setReturnPolicy(ReturnPolicy ReturnPolicy) {
         this.ReturnPolicy = ReturnPolicy;
     }
     public ReturnPolicy getReturnPolicy() {
         return ReturnPolicy;
     }

    public void setAutoPay(boolean AutoPay) {
         this.AutoPay = AutoPay;
     }
     public boolean getAutoPay() {
         return AutoPay;
     }

    public void setPaymentAllowedSite(List<String> PaymentAllowedSite) {
         this.PaymentAllowedSite = PaymentAllowedSite;
     }
     public List<String> getPaymentAllowedSite() {
         return PaymentAllowedSite;
     }

    public void setIntegratedMerchantCreditCardEnabled(boolean IntegratedMerchantCreditCardEnabled) {
         this.IntegratedMerchantCreditCardEnabled = IntegratedMerchantCreditCardEnabled;
     }
     public boolean getIntegratedMerchantCreditCardEnabled() {
         return IntegratedMerchantCreditCardEnabled;
     }

    public void setHandlingTime(String HandlingTime) {
         this.HandlingTime = HandlingTime;
     }
     public String getHandlingTime() {
         return HandlingTime;
     }

    public void setConditionID(int ConditionID) {
         this.ConditionID = ConditionID;
     }
     public int getConditionID() {
         return ConditionID;
     }

    public void setConditionDisplayName(String ConditionDisplayName) {
         this.ConditionDisplayName = ConditionDisplayName;
     }
     public String getConditionDisplayName() {
         return ConditionDisplayName;
     }

    public void setQuantityAvailableHint(String QuantityAvailableHint) {
         this.QuantityAvailableHint = QuantityAvailableHint;
     }
     public String getQuantityAvailableHint() {
         return QuantityAvailableHint;
     }

    public void setTopRatedListing(boolean TopRatedListing) {
         this.TopRatedListing = TopRatedListing;
     }
     public boolean getTopRatedListing() {
         return TopRatedListing;
     }

    public void setGlobalShipping(String GlobalShipping) {
         this.GlobalShipping = GlobalShipping;
     }
     public String getGlobalShipping() {
         return GlobalShipping;
     }

    public void setQuantitySoldByPickupInStore(int QuantitySoldByPickupInStore) {
         this.QuantitySoldByPickupInStore = QuantitySoldByPickupInStore;
     }
     public int getQuantitySoldByPickupInStore() {
         return QuantitySoldByPickupInStore;
     }

    public void setNewBestOffer(boolean NewBestOffer) {
         this.NewBestOffer = NewBestOffer;
     }
     public boolean getNewBestOffer() {
         return NewBestOffer;
     }

}