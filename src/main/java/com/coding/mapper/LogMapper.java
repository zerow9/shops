package com.coding.mapper;

import com.coding.paging.PagingCustomLog;
import com.coding.pojo.Log;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LogMapper {
    /**
     * 根据ID主键查询日志信息
     * @param logId
     * @return
     * @throws Exception
     */
    public Log selectLogByPrimaryKey (Integer logId)throws Exception;

    /**
     * 根据ID主键删除日志信息
     * @param logId
     * @return
     * @throws Exception
     */
    public int deleteLogByPrimaryKey (Integer logId)throws Exception;

    /**
     * 根据ID主键数组批量删除日志信息
     * @param logIdArrary
     * @return
     * @throws Exception
     */
    public int deleteLogByPrimaryKeyArray (@Param("logIdArrary") Integer[] logIdArrary)throws Exception;

    /**
     * 按需插入日志信息
     * @param log
     * @return
     * @throws Exception
     */
    public int insertLogSelective (Log log) throws Exception;

    /**
     * 按需修改日志信息
     * @param log
     * @return
     * @throws Exception
     */
    public int updateLogByPrimaryKeySelective (Log log)throws Exception;

    /**
     * 日志表综合查询
     * @param pagingCustomLog
     * @return
     * @throws Exception
     */
    public List<Log> selectLog (PagingCustomLog pagingCustomLog)throws Exception;

    /**
     * 日志信息综合查询
     * @return
     * @throws Exception
     */
    public int selectLogCount () throws Exception;
}