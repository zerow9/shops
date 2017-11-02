package com.coding.pojo;

public class PagingCustom {
    private int nowPage;
    private int number;
    private String keyWord;

    public int getNowPage() {
        return nowPage;
    }

    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    @Override
    public String toString() {
        return "PagingCustom{" +
                "nowPage=" + nowPage +
                ", number=" + number +
                ", keyWord='" + keyWord + '\'' +
                '}';
    }
}
