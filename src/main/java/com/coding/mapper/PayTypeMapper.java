package com.coding.mapper;

import com.coding.paging.PagingCustomPayType;
import com.coding.pojo.PayType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PayTypeMapper {
    /**
     * 根据支付类型ID删除信息
     * @param payTypeId 支付类型唯一ID
     * @return 是否删除成功 非0:成功  0:失败
     * @throws Exception
     */
    public int deletePayTypeByPrimaryKey(Integer payTypeId)throws Exception;

    /**
     * 根据支付类型ID组批量删除信息
     * @param  payTypeIdArray 支付类型唯一ID
     * @return 是否删除成功 非0:成功  0:失败
     * @throws Exception
     */
    public int deletePayTypeByPrimaryKeyArray(@Param("payTypeIdArray") Integer[] payTypeIdArray)throws Exception;

    /**
     * 插入支付类型信息
     * @param payType 封装了支付类型的基本信息 PayType 类对象
     * @return 是否插入成功 非0:成功  0:失败
     * @throws Exception
     */
    public int insertPayTypeSelective(PayType payType)throws Exception;

    /**
     * 根据支付类型唯一ID查询支付类型信息
     * @param payTypeId 支付类型唯一ID
     * @return 满足查询条件的 封装了支付类型的基本信息 PayType 类对象
     * @throws Exception
     */
    public PayType selectPayTypeByPrimaryKey(Integer payTypeId)throws Exception;

    /**
     * 查询支付类型表中一共有多少数据
     * @return 返回支付类型表中一共有多少数据
     * @throws Exception
     */
    public Integer selectPayTypeCount()throws Exception;

    /**
     * 支付类型查询功能模块
     * @param pagingCustomPayType 封装了基本查询条件的 Paging 类对象的扩展类 PagingCustomPayType 类对象
     * @return 满足查询条件的封装了支付类型信息的 PayType 类对象集合
     * @throws Exception
     */
    public List<PayType> selectPayType(PagingCustomPayType pagingCustomPayType)throws Exception;

    /**
     * 根据支付类型唯一ID按需更新支付类型信息
     * @param payType 封装了支付类型的基本信息 PayType 类对象
     * @return 是否更新成功  非0:成功 0:失败
     * @throws Exception
     */
    public int updatePayTypeByPrimaryKeySelective(PayType payType)throws Exception;

}