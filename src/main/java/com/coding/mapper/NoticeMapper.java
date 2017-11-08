package com.coding.mapper;

import com.coding.paging.PagingCustomNotice;
import com.coding.pojo.Notice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NoticeMapper {
    /**
     * 根据主键查询公告信息
     * @param noticeId
     * @return
     * @throws Exception
     */
    public Notice selectNoticeByPrimaryKey (Integer noticeId)throws Exception;

    /**
     * 根据主键删除公告信息
     * @param noticeId
     * @return
     * @throws Exception
     */
    public int deleteNoticeByPrimaryKey (Integer noticeId)throws Exception;

    /**
     * 根据主键批量删除公告信息
     * @param noticeIdArrary
     * @return
     * @throws Exception
     */
    public int deleteNoticeByPrimaryKeyArray (@Param("noticeIdArrary") Integer[] noticeIdArrary)throws Exception;

    /**
     * 按需添加公告信息
     * @param notice
     * @return
     * @throws Exception
     */
    public int insertNoticeSelective (Notice notice)throws Exception;

    /**
     * 按需修改公告信息
     * @param notice
     * @return
     * @throws Exception
     */
    public int updateNoticeByPrimaryKeySelective (Notice notice)throws Exception;

    /**
     * 公告表综合查询
     * @param pagingCustomNotice
     * @return
     * @throws Exception
     */
    public List<Notice> selectNotice (PagingCustomNotice pagingCustomNotice)throws Exception;

    /**
     * 查询公告信息总数
     * @return
     * @throws Exception
     */
    public int selectNoticeCount ()throws Exception;
}
