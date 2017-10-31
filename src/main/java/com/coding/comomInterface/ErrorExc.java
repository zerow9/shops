package com.coding.comomInterface;

public class ErrorExc {
    protected void except(Object object,String message) throws  Exception{
        if(object==null)
            throw  new Exception(message);
    }
}
