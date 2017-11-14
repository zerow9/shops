package com.coding.mapper;

import com.coding.paging.PagingCustomDiscuss;
import com.coding.pojo.Discuss;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface DiscussMapper {
    /**
     * 根据评论唯一ID删除评论信息
     * @param discussId 评论唯一ID
     * @return 是否删除成功 非0:成功  0:失败
     * @throws Exception
     */
    public int deleteDiscussByPrimaryKey(Integer discussId)throws Exception;

    /**
     * 根据评论唯一ID组批量删除评论信息
     * @param discussIdArray 评论唯一ID组
     * @return 是否删除成功 非0:成功  0:失败
     * @throws Exception
     */
    public int deleteDiscussByPrimaryKeyArray(@Param("discussIdArray") Integer[] discussIdArray)throws Exception;

    /**
     * 插入评论信息
     * @param discuss 封装了评论信息的 Discuss 类对象
     * @return 是否插入成功 非0:成功  0:失败
     * @throws Exception
     */
    public int insertDiscussSelective(Discuss discuss)throws Exception;

    /**
     * 通过评论唯一ID查询评论信息
     * @param discussId 评论唯一ID
     * @return 返回满足查询条件的 封装了评论信息的 Discuss 类对象
     * @throws Exception
     */
    public Discuss selectDiscussByPrimaryKey(Integer discussId)throws Exception;

    /**
     * 查询评论表中一共存在多少数据
     * @return 返回评论表中数据的总数
     * @throws Exception
     */
    public Integer selectDiscussCount()throws Exception;

    /**
     * 评论表的查询功能集合
     * @param pagingCustomDiscuss 封装了基本查询条件（分页 排序规则等）的 Paging 类的扩展类 PagingCustomDiscuss 类对象
     * @return 回满足查询条件的 封装了评论信息的 Discuss 类对象集合
     * @throws Exception
     */
    public List<Discuss> selectDiscuss(PagingCustomDiscuss pagingCustomDiscuss)throws Exception;

    /**
     * 根据评论表的唯一ID按需更新评论信息
     * @param discuss 封装了待修改评论信息的 Discuss 类对象集合
     * @return 是否更新成功  非0:成功  0:失败
     * @throws Exception
     */
    public int updateDiscussByPrimaryKeySelective(Discuss discuss)throws Exception;

}