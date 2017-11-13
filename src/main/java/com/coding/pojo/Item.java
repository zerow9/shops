package com.coding.pojo;


import java.util.Date;
public class Item {
    private Integer itemId;

    private Integer itemTypeId;

    private String itemName;

    private Double itemPrice;

    private Double itemMarketPrice;

    private Integer itemScoreType;

    private Integer scorePrice;

    private String itemImages;

    private String itemFormat;

    private Integer itemTypeOne;

    private Integer itemTypeTwo;

    private Integer itemTypeThree;

    private Double postPrice;

    private Integer repertoryNumber;

    private Integer itemSaleNumber;

    private Integer itemCollectNumber;

    private String keyWord;

    private Integer makeVender;

    private Date makeDate;

    private String dateToString;

    public String getDateToString() {
        return dateToString;
    }

    public void setDateToString(String dateToString) {
        this.dateToString = dateToString;
    }

    private String itemIntroduce;


    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(Integer itemTypeId) {
        this.itemTypeId = itemTypeId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Double getItemMarketPrice() {
        return itemMarketPrice;
    }

    public void setItemMarketPrice(Double itemMarketPrice) {
        this.itemMarketPrice = itemMarketPrice;
    }

    public Integer getItemScoreType() {
        return itemScoreType;
    }

    public void setItemScoreType(Integer itemScoreType) {
        this.itemScoreType = itemScoreType;
    }

    public Integer getScorePrice() {
        return scorePrice;
    }

    public void setScorePrice(Integer scorePrice) {
        this.scorePrice = scorePrice;
    }

    public String getItemImages() {
        return itemImages;
    }

    public void setItemImages(String itemImages) {
        this.itemImages = itemImages == null ? null : itemImages.trim();
    }

    public String getItemFormat() {
        return itemFormat;
    }

    public void setItemFormat(String itemFormat) {
        this.itemFormat = itemFormat == null ? null : itemFormat.trim();
    }

    public Integer getItemTypeOne() {
        return itemTypeOne;
    }

    public void setItemTypeOne(Integer itemTypeOne) {
        this.itemTypeOne = itemTypeOne;
    }

    public Integer getItemTypeTwo() {
        return itemTypeTwo;
    }

    public void setItemTypeTwo(Integer itemTypeTwo) {
        this.itemTypeTwo = itemTypeTwo;
    }

    public Integer getItemTypeThree() {
        return itemTypeThree;
    }

    public void setItemTypeThree(Integer itemTypeThree) {
        this.itemTypeThree = itemTypeThree;
    }

    public Double getPostPrice() {
        return postPrice;
    }

    public void setPostPrice(Double postPrice) {
        this.postPrice = postPrice;
    }

    public Integer getRepertoryNumber() {
        return repertoryNumber;
    }

    public void setRepertoryNumber(Integer repertoryNumber) {
        this.repertoryNumber = repertoryNumber;
    }

    public Integer getItemSaleNumber() {
        return itemSaleNumber;
    }

    public void setItemSaleNumber(Integer itemSaleNumber) {
        this.itemSaleNumber = itemSaleNumber;
    }

    public Integer getItemCollectNumber() {
        return itemCollectNumber;
    }

    public void setItemCollectNumber(Integer itemCollectNumber) {
        this.itemCollectNumber = itemCollectNumber;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord == null ? null : keyWord.trim();
    }

    public Integer getMakeVender() {
        return makeVender;
    }

    public void setMakeVender(Integer makeVender) {
        this.makeVender = makeVender;
    }

    public Date getMakeDate() {
        return makeDate;
    }

    public void setMakeDate(Date makeDate) {
        this.makeDate = makeDate;
    }

    public String getItemIntroduce() {
        return itemIntroduce;
    }

    public void setItemIntroduce(String itemIntroduce) {
        this.itemIntroduce = itemIntroduce == null ? null : itemIntroduce.trim();
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemTypeId=" + itemTypeId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", itemMarketPrice=" + itemMarketPrice +
                ", itemScoreType=" + itemScoreType +
                ", scorePrice=" + scorePrice +
                ", itemImages='" + itemImages + '\'' +
                ", itemFormat='" + itemFormat + '\'' +
                ", itemTypeOne=" + itemTypeOne +
                ", itemTypeTwo=" + itemTypeTwo +
                ", itemTypeThree=" + itemTypeThree +
                ", postPrice=" + postPrice +
                ", repertoryNumber=" + repertoryNumber +
                ", itemSaleNumber=" + itemSaleNumber +
                ", itemCollectNumber=" + itemCollectNumber +
                ", keyWord='" + keyWord + '\'' +
                ", makeVender=" + makeVender +
                ", makeDate=" + makeDate +
                ", dateToString='" + dateToString + '\'' +
                ", itemIntroduce='" + itemIntroduce + '\'' +
                '}';
    }
}