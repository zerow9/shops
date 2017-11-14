package com.coding.paging;

import com.coding.pojo.Discuss;
import org.springframework.stereotype.Component;

@Component
public class PagingCustomDiscuss extends Paging{

    private String formerDiscussTime;//一些功能需要时间范围内查询，这是左侧较小值

    private String latterDiscussTime;//一些功能需要时间范围内查询，这是右侧较大值

    private Discuss discuss;

    public Discuss getDiscuss() {
        return discuss;
    }

    public void setDiscuss(Discuss discuss) {
        this.discuss = discuss;
    }

    public String getFormerDiscussTime() {
        return formerDiscussTime;
    }

    public void setFormerDiscussTime(String formerDiscussTime) {
        this.formerDiscussTime = formerDiscussTime;
    }

    public String getLatterDiscussTime() {
        return latterDiscussTime;
    }

    public void setLatterDiscussTime(String latterDiscussTime) {
        this.latterDiscussTime = latterDiscussTime;
    }
}
