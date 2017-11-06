package com.coding.comomInterface;

import java.util.Date;
import java.util.List;
import java.util.Random;

public class ErrorExc {

    protected void except(Object object,String message) throws  Exception{
        if(object==null)
            throw  new Exception(message);
    }
    protected void except(int line) throws  Exception{
        if(line==0)
            throw new  Exception("影响行为0,操作无效");
    }
    protected void except(Integer former, Integer latter) throws  Exception{
        if (former==null||former==0||latter==null||latter==0)
            throw new Exception("区间范围未初始化");
        if(former>latter)
            throw new Exception("区间former需要小于等于latter");
    }
    protected  void exceptInitialize(Integer nowPage, Integer number)throws Exception{
        if (nowPage==null||number==null||number==0){
            throw new Exception("页面参数未初始化");
        }
    }

}
