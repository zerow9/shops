package com.coding.paging;

import com.coding.pojo.Vender;

public class PagingCustomVender extends Paging{
    private Vender vender;

    public Vender getVender() {
        return vender;
    }

    public void setVender(Vender vender) {
        this.vender = vender;
    }

    @Override
    public String toString() {
        return "PagingCustomVender{" +
                "vender=" + vender +
                ", indexNumber=" + indexNumber +
                ", pageNumber=" + pageNumber +
                ", keyWord='" + keyWord + '\'' +
                ", sortByColumn='" + sortByColumn + '\'' +
                ", sortRule='" + sortRule + '\'' +
                '}';
    }
}
