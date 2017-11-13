package com.coding.paging;

import com.coding.pojo.Collect;
import org.springframework.stereotype.Component;

@Component
public class PagingCustomCollect extends Paging{
    private Collect collect;

    public Collect getCollect() {
        return collect;
    }

    public void setCollect(Collect collect) {
        this.collect = collect;
    }
}
