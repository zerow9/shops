package com.coding.comomInterface;

import java.util.List;

public class ErrorExc {

    protected void except(Object object,String message) throws  Exception{
        if(object==null)
            throw  new Exception(message);
    }

}
