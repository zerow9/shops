package com.coding.paging;

import com.coding.pojo.Score;

public class PagingCustomScore extends Paging{
    private Score score;

    private String formerScoreCreateTime;//一些功能需要积分详情创建时间范围内查询，这是左侧较小值

    private String latterScoreCreateTime;//一些功能需要积分详情创建时间范围内查询，这是右侧较大值

    public void setFormerScoreCreateTime(String formerScoreCreateTime) {
        this.formerScoreCreateTime = formerScoreCreateTime;
    }

    public void setLatterScoreCreateTime(String latterScoreCreateTime) {
        this.latterScoreCreateTime = latterScoreCreateTime;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public Score getScore() {

        return score;
    }

    public String getFormerScoreCreateTime() {
        return formerScoreCreateTime;
    }

    public String getLatterScoreCreateTime() {
        return latterScoreCreateTime;
    }

    @Override
    public String toString() {
        return "PagingCustomScore{" +
                "score=" + score +
                ", formerScoreCreateTime='" + formerScoreCreateTime + '\'' +
                ", latterScoreCreateTime='" + latterScoreCreateTime + '\'' +
                ", indexNumber=" + indexNumber +
                ", pageNumber=" + pageNumber +
                ", keyWord='" + keyWord + '\'' +
                ", sortByColumn='" + sortByColumn + '\'' +
                ", sortRule='" + sortRule + '\'' +
                '}';
    }
}
