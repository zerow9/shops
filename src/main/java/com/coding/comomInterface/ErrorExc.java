package com.coding.comomInterface;

import java.util.List;

public class ErrorExc {

    protected void except(Object object,String message) throws  Exception{
        if(object==null)
            throw  new Exception(message);
    }
    protected void except(int line) throws  Exception{
        if(line==0)
            throw new  Exception();
    }
    protected void except(Integer former, Integer latter) throws  Exception{
        if(former>latter)
            throw new Exception("区间former需要小于等于latter");
    }

}
