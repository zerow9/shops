package com.coding.mapper;

import com.coding.pojo.Repertory;

import java.util.List;

public interface RepertoryMapper {
    public void deleteRepertoryByPrimaryKey(Integer repertoryId);

    public void insertRepertory(Repertory repertory);

    public Repertory selectRepertoryByPrimaryKey(Integer repertoryId);

    public void updateRepertoryByPrimaryKey(Repertory repertory);

    public List<Repertory> sellectRepertoryAll();
}