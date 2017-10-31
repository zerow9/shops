package com.coding.mapper;

import com.coding.pojo.Vender;

import java.util.List;

public interface VenderMapper {
    public void deleteVenderByPrimaryKey(Integer venderId);

    public void insertVender(Vender vender);

    public Vender selectVenderByPrimaryKey(Integer venderId);

    public void updateVenderByPrimaryKey(Vender vender);

    public List<Vender> selectVenderAll();

}