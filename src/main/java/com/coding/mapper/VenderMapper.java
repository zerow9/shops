package com.coding.mapper;

import com.coding.pojo.Vender;

import java.util.List;

public interface VenderMapper {
    public void deleteVenderByPrimaryKey(Integer venderId) throws Exception;

    public void insertVender(Vender vender) throws Exception;

    public Vender selectVenderByPrimaryKey(Integer venderId) throws Exception;

    public void updateVenderByPrimaryKey(Vender vender) throws Exception;

    public List<Vender> selectVenderAll() throws Exception;

}