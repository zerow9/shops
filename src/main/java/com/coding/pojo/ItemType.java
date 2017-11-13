package com.coding.pojo;


public class ItemType {
    private Integer typeId;

    private String typeName;

    private Integer fatherTypeId;

    private Integer typeLevel;

    private String typeKeyWord;

    private String typeIntroduce;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public Integer getFatherTypeId() {
        return fatherTypeId;
    }

    public void setFatherTypeId(Integer fatherTypeId) {
        this.fatherTypeId = fatherTypeId;
    }

    public Integer getTypeLevel() {
        return typeLevel;
    }

    public void setTypeLevel(Integer typeLevel) {
        this.typeLevel = typeLevel;
    }

    public String getTypeKeyWord() {
        return typeKeyWord;
    }

    public void setTypeKeyWord(String typeKeyWord) {
        this.typeKeyWord = typeKeyWord == null ? null : typeKeyWord.trim();
    }

    public String getTypeIntroduce() {
        return typeIntroduce;
    }

    public void setTypeIntroduce(String typeIntroduce) {
        this.typeIntroduce = typeIntroduce == null ? null : typeIntroduce.trim();
    }



    @Override
    public String toString() {
        return "ItemType{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", fatherTypeId=" + fatherTypeId +
                ", typeLevel=" + typeLevel +
                ", typeKeyWord='" + typeKeyWord + '\'' +
                ", typeIntroduce='" + typeIntroduce + '\'' +
                '}';
    }
}