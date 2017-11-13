package com.coding.paging;

import com.coding.pojo.Repertory;

public class PagingCustomRepertory extends Paging {

    private Repertory repertory;

    public Repertory getRepertory() {
        return repertory;
    }

    public void setRepertory(Repertory repertory) {
        this.repertory = repertory;
    }

    public String toString() {
        return "PagingCustomRepertory{" +
                "repertory=" + repertory +
                ", indexNumber=" + indexNumber +
                ", pageNumber=" + pageNumber +
                ", keyWord='" + keyWord + '\'' +
                ", sortByColumn='" + sortByColumn + '\'' +
                ", sortRule='" + sortRule + '\'' +
                '}';
    }
}
