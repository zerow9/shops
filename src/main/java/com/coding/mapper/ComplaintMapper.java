package com.coding.mapper;

import com.coding.pojo.Complaint;
import com.coding.paging.PagingCustomComplaint;

import java.util.List;

public interface ComplaintMapper {

    /**
     * 根据投诉ID删除投诉信息
     * @param complaintId 投诉表唯一ID
     * @return 是否删除成功 非0:成功 0:不成功
     * @throws Exception
     */
    public int deleteComplaintByPrimaryKey(Integer complaintId)throws Exception;

    /**
     * 按需插入投诉信息
     * @param complaint 封装了投诉信息的 Complaint 类对象
     * @return 是否插入成功 非0:成功 0:失败
     * @throws Exception
     */
    public int insertComplaintSelective(Complaint complaint)throws Exception;

    /**
     * 根据投诉表ID按需更新投诉表信息
     * @param complaint 封装了投诉信息的 Complaint 类对象
     * @return 是否更新成功 非0:成功 0:失败
     * @throws Exception
     */
    public int updateComplaintByPrimaryKeySelective(Complaint complaint)throws Exception;

    /**
     * 投诉表查询功能大集合
     * PagingCustomComplaint中的时间字段是 String 类型 ，格式要和数据库 dateTime 一样  yyyy-MM-dd HH:mm:ss
     *
     * @param pagingCustomComplaint 封装了投诉信息的 Complaint 类对象
     * @return 满足查询条件的封装了投诉信息的 Complaint 类对象集合
     * @throws Exception
     */
    public List<Complaint> selectComplaint(PagingCustomComplaint pagingCustomComplaint)throws Exception;

    /**
     * 根据投诉ID查询用户投诉信息
     * @param complaintId
     * @return
     * @throws Exception
     */
    public Complaint selectComplaintByPrimaryKey(Integer complaintId) throws Exception;

    /**
     * 查询一共有多少条投诉信息
     * @return 返回一共有多少条投诉信息
     * @throws Exception
     */
    public Integer selectComplaintCount()throws Exception;

}