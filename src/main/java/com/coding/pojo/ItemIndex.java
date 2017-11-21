package com.coding.pojo;

public class ItemIndex {
    private Integer indexId;

    private Integer itemId;

    private String indexType;

    public Integer getIndexId() {
        return indexId;
    }

    public void setIndexId(Integer indexId) {
        this.indexId = indexId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getIndexType() {
        return indexType;
    }

    public void setIndexType(String indexType) {
        this.indexType = indexType == null ? null : indexType.trim();
    }

    @Override
    public String toString() {
        return "ItemIndex{" +
                "indexId=" + indexId +
                ", itemId=" + itemId +
                ", indexType='" + indexType + '\'' +
                '}';
    }
}