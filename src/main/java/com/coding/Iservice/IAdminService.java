package com.coding.Iservice;

import com.coding.paging.*;
import com.coding.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IAdminService extends IUserService {
    /*------------------------------------------用户表------------------------------------------------------------------*/
    /**
     *
     *
     * 根据用户 ID 删除用户信息
     * @param userUuid
     */
    public void deleteUserByPrimaryKey(String userUuid) throws Exception;

    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> selectUserAll() throws Exception;

    /**
     * 根据电话号码查找用户信息
     * @param userPhone 电话号码
     * @return  封装了符合查找条件的 User 类对象
     * @throws Exception
     */
    public User selectUserByPhone( String userPhone ) throws Exception;

    /**
     * 根据组别ID查找用户信息
     * @param user_group 组别ID
     * @return  返回满足查询条件封装类用户信息的 User 类对象集合
     * @throws Exception
     */
    public List<User> selectUserByGroupId( Integer user_group) throws Exception;

    /**
     * 根据积分范围查找用户信息
     * @param former 范围低数值
     * @param latter 范围高数值
     * @return 封装了满足查询条件的 User 类对象集合
     */
    public List<User> selectUserByScoreRange(Integer former,Integer latter)throws Exception;

    /**
     *
     * @param former 范围低数值
     * @param latter 范围高数值
     * @return 封装了满足查询条件的 User 类对象集合
     */
    public List<User> selectUserByAgeRange(Integer former,Integer latter)throws  Exception;

    /**
     * 批量删除用户信息
     * @param user_uuidArray 需删除用户ID集合
     * @return  1 ：删除成功  0 ：删除失败
     * @throws Exception
     */
    public void deleteUsersByUuidArray(String[] user_uuidArray)throws Exception;

    /**
     * 通过分页查询所有用户信息
     * @param nowPage 当前页面
     * @param number  每页需要查询的用户数量
     * @return
     * @throws Exception
     */
    public List<User> selectUserAllPaging(Integer nowPage,Integer number)throws Exception;

    /**
     * user综合查询
     *实现：姓名（模糊），昵称（模糊），性别，组别，电话，健康状态，年龄范围，积分范围，注册时间范围，排序规则，排序字段，分页。
     * @param paging 封装了分页查询需要的字段的 Paging 类对象
     * @return 封装了用户信息的 User 类对象集合
     * @throws Exception
     */
    public List<User> selectUser(PagingCustomUser paging) throws Exception;
/*------------------------------------------收获地址表表------------------------------------------------------------------*/
    /**
     * 返回所有地址信息
     * @return
     */
    public List<Address> selectAddressAll() throws Exception;

    /**
     * 返回地址表中一共有多少条数据
     * @return 封装了地址信息的 Address 类对象
     * @throws Exception
     */
    public Integer selectAddressCount()throws Exception;
/*------------------------------------------分组表------------------------------------------------------------------*/
    /**
     * 通过分组 ID 删除分组信息
     * @param groupId 分组唯一ID
     */
    public void deleteGroupsByPrimaryKey(Integer groupId) throws Exception;

    /**
     * 批量删除用户组
     * @return 是否删除成功 非0:成功 0:不成功
     * @throws Exception
     */
    public void deleteGroupsByPrimaryKeyArray(Integer [] groups_idArray) throws Exception;

    /**
     * 插入分组信息
     * @param groups 封装了分组信息的 Groups 对象
     */
    public void insertGroups(Groups groups) throws Exception;

    /**
     * 根据分组 ID 查询分组信息
     * @param groupId 分组唯一ID
     * @return  封装了分组信息的 Groups 对象
     */
    public Groups selectGroupsByPrimaryKey(Integer groupId) throws Exception;

    /**
     * 根据分组 ID 更新分组信息
     * @param groups 封装了分组信息的 Groups 对象
     */
    public void updateGroupsByPrimaryKey(Groups groups) throws Exception;

    /**
     * 查询所有分组信息
     * @return 封装了分组信息的 Groups 对象 集合
     */
    public List<Groups> selectGroupsAll() throws Exception;

    /**
     * 用户组查询功能模块（包含主键查询、权限查询、状态查询、组别名查询、分页功能）
     * 实现：主键，权限，状态，组别名，排序规则，分页
     * @return 封装了用户组信息的 Groups 类对象集合
     * @throws Exception
     */
    public List<Groups> selectGroups(PagingCustomGroups pagingCustomGroups) throws Exception;

    /**
     * 查询分组列表，实现分页功能
     * @param nowPage
     * @param number
     * @return
     * @throws Exception
     */
    public List<Groups> selectGroupsPaging(Integer nowPage, Integer number) throws Exception;

    /**
     * 查询表中共有多少条数据
     * @return 返回分组表中一共有多少条数据
     * @throws Exception
     */
    public Integer selectGroupsCount()throws Exception;

    /*------------------------------------------管理员表------------------------------------------------------------------*/
    /**
     * 根据 用户唯一id删除用户信息
     * @param adminId
     */
    public void deleteAdminByPrimaryKey(Integer adminId) throws Exception;

    /**
     * 插入管理员信息
     * @param admin
     */
    public void  insertAdmin(Admin admin) throws Exception;

    /**
     * 通过管理员唯一 ID 查询管理员信息
     * @param adminId
     * @return
     */
    public Admin selectAdminByPrimaryKey(Integer adminId) throws Exception;

    /**
     * 通过管理员唯一 ID 修改管理员信息
     * @param admin
     */
    public void updateAdminByPrimaryKey(Admin admin) throws Exception;

    /**
     * 查询所有管理员信息
     * @return
     */
    public List<Admin> selectAdminAll() throws Exception;

    /**
     * 批量删除管理员信息
     *
     * @param adminIdArray 管理员ID数组
     * @return 0:删除失败 1:删除成功
     * @throws Exception
     */
    public void deleteAdminByAdminIdArray(Integer[] adminIdArray) throws Exception;
    /**
     * 通过分页查询所有管理员信息
     *
     * @param nowPage 当前页面
     * @param number  每页需要查询的用户数量
     * @return 封装了管理员信息的 Admin 类对象
     * @throws Exception
     */
    public List<Admin> selectAdminAllPaging(Integer nowPage,Integer number) throws Exception;

    /**
     * 返回管理员表中一共有多少条数据
     * @return 封装了管理员信息的 Groups 类对象
     * @throws Exception
     */
    public Integer selectAdminCount()throws Exception;

    /**
     * 根据帐号去查找密码
     * @param adminAccount Admin 帐号
     * @return 如果数据库中有该帐号信息，那么就返回该用户密码(设计不规范，导致账户可能会重复，返回密码列表，去密码列表中匹配)
     * @throws Exception
     */
    public List<String> selectAdminPassword(String adminAccount)throws Exception;

   /*------------------------------------------用户投诉表------------------------------------------------------------------*/
    /**
     * 查询一共有多少条投诉信息
     * @return 返回一共有多少条投诉信息
     * @throws Exception
     */
    public Integer selectComplaintCount()throws Exception;
     /*------------------------------------------商品类别表------------------------------------------------------------------*/

    /**
     * 根据商品类别ID删除商品
     * @param itemTypeId
     * @throws Exception
     */
    public void deleteItemTypeByPrimaryKey(Integer itemTypeId)throws Exception;

    /**
     * 插入新商品类别
     * @param itemType
     * @throws Exception
     */
    public void  insertItemType(ItemType itemType)throws Exception;

    /**
     * 根据商品类别ID修改商品类别信息
     * @param itemType
     * @throws Exception
     */
    public void updateItemTypeByPrimaryKey(ItemType itemType)throws Exception;

 /*------------------------------------------商品表------------------------------------------------------------------*/
    /**
     * 根据商品ID删除商品信息
     *
     * @param itemId 商品唯一ID
     */
    public void deleteItemByPrimaryKey(Integer itemId) throws Exception;

    /**
     * 根据商品ID批量删除商品信息
     *
     * @param itemIdArray 商品唯一ID数组
     */
    public void deleteItemByItemIdArray(@Param("itemIdArray") Integer[] itemIdArray) throws Exception;

    /**
     * 增加商品信息
     *
     * @param item 封装了商品信息的 Item 类对象
     */
    public void insertItem(Item item) throws Exception;

    /**
     * 根据商品唯一ID更新商品信息
     *
     * @param item 商品ID
     */
    public void updateItemByPrimaryKey(Item item) throws Exception;

 /*------------------------------------------库存表------------------------------------------------------------------*/
    /**
     * 根据库存ID删除库存信息
     *
     * @param repertoryId 库存ID
     * @throws Exception
     */
    public void deleteRepertoryByPrimaryKey(Integer repertoryId) throws Exception;

    /**
     * 批量删除库存信息
     * @param repertoryIdArrary
     * @return
     */
    public void deleteRepertoryByPrimaryKeyArray(Integer[] repertoryIdArrary)throws Exception;

    /**
     * @param repertory 封装了库存信息的 Repertory 类对象
     * @throws Exception
     */
    public void insertRepertory(Repertory repertory) throws Exception;

    /**
     * @param repertoryId 库存ID
     * @return 封装了库存信息的 Repertory 类对象
     * @throws Exception
     */
    public Repertory selectRepertoryByPrimaryKey(Integer repertoryId) throws Exception;

    /**
     * @param repertory 封装了库存信息的 Repertory 类对象
     * @throws Exception
     */
    public void updateRepertoryByPrimaryKey(Repertory repertory) throws Exception;

    /**
     * @return 装了库存信息的 Repertory 类对象集合
     * @throws Exception
     */
    public List<Repertory> selectRepertoryAll() throws Exception;

    /**
     * 库存信息表的综合查询
     * 实现：库存ID，商品ID，商店ID，排序规则，分页功能
     * @return
     * @throws Exception
     */
    public List<Repertory> selectRepertory(PagingCustomRepertory pagingCustomRepertory) throws Exception;

    /**
     * 返回库存表中一共有多少条数据
     * @return 封装了库存信息的 Repertory 类对象
     * @throws Exception
     */
    public Integer selectRepertoryCount()throws Exception;

    /*------------------------------------------厂家信息表------------------------------------------------------------------*/
    /**
     * 根据厂家ID删除厂家信息
     *
     * @param venderId 厂家ID
     * @throws Exception
     */
    public void deleteVenderByPrimaryKey(Integer venderId) throws Exception;

    /**
     * 批量删除厂家信息
     * @param venderIdArrary
     * @return
     * @throws Exception
     */
    public void deleteVenderByPrimaryKeyArray(@Param("venderIdArrary") Integer[] venderIdArrary)throws Exception;
    /**
     * 增加厂家信息
     *
     * @param vender 封装了厂家信息的 Vender 类对象
     * @throws Exception
     */
    public void insertVender(Vender vender) throws Exception;

    /**
     * 根据厂家唯一ID 查询厂家信息
     *
     * @param venderId 厂家ID
     * @return 封装类厂家信息的 Vender 对象
     * @throws Exception
     */
    public Vender selectVenderByPrimaryKey(Integer venderId) throws Exception;

    /**
     * 根据厂家ID更新厂家信息
     *
     * @param vender 封装了厂家信息的 Vender 对象
     * @throws Exception
     */
    public void updateVenderByPrimaryKey(Vender vender) throws Exception;

    /**
     * 查询所有厂家信息
     *
     * @return 封装了厂家信息的 Vender 对象集合
     * @throws Exception
     */
    public List<Vender> selectVenderAll() throws Exception;

    /**
     * 厂家表综合查询
     * 所用字段均可查询，厂商名字和经营范围为模糊查询
     * @param pagingCustomVender
     * @return
     * @throws Exception
     */
    public List<Vender> selectVender(PagingCustomVender pagingCustomVender)throws Exception;

    /**
     * 返回厂家中一共有多少条数据
     * @return 封装了厂家信息的 Repertory 类对象
     * @throws Exception
     */
    public int selectVenderCount()throws Exception;

    /*------------------------------------------订单表------------------------------------------------------------------*/

    /**
     * 按需更新订单信息
     * @param order 封装了订单信息的 Orders 类对象
     * @return 是否更新成功 非0：成功  0:失败
     */
    public void updateOrderByPrimaryKeySelective(Orders order)throws Exception;

    /**
     * 查询订单表中共有多少数据
     * @return 返回商品表中共有多少数据
     * @throws Exception
     */
    public Integer selectOrderCount()throws Exception;

     /*------------------------------------------订单详情表------------------------------------------------------------------*/
    /**
     * 根据订单详情主键修改订单详情
     * @param orderDetail
     * @return
     * @throws Exception
     */
    public void updateOrderDetailByPrimaryKeySelective(OrderDetail orderDetail)throws Exception;

    /**
     * 查询订单详情中有多少条数据
     * @return
     * @throws Exception
     */
    public Integer selectOrderDetailCount()throws Exception;

     /*------------------------------------------公告表------------------------------------------------------------------*/


    /**
     * 根据主键删除公告信息
     * @param noticeId
     * @return
     * @throws Exception
     */
    public void deleteNoticeByPrimaryKey (Integer noticeId)throws Exception;

    /**
     * 根据主键批量删除公告信息
     * @param noticeIdArrary
     * @return
     * @throws Exception
     */
    public void deleteNoticeByPrimaryKeyArray (Integer[] noticeIdArrary)throws Exception;

    /**
     * 按需添加公告信息
     * @param notice
     * @return
     * @throws Exception
     */
    public void insertNoticeSelective (Notice notice)throws Exception;

    /**
     * 按需修改公告信息
     * @param notice
     * @return
     * @throws Exception
     */
    public void updateNoticeByPrimaryKeySelective (Notice notice)throws Exception;

    /*------------------------------------------日志表------------------------------------------------------------------*/
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
    public void deleteLogByPrimaryKey (Integer logId)throws Exception;

    /**
     * 根据ID主键数组批量删除日志信息
     * @param logIdArrary
     * @return
     * @throws Exception
     */
    public void deleteLogByPrimaryKeyArray (Integer[] logIdArrary)throws Exception;

    /**
     * 按需插入日志信息
     * @param log
     * @return
     * @throws Exception
     */
    public void insertLogSelective (Log log) throws Exception;

    /**
     * 按需修改日志信息
     * @param log
     * @return
     * @throws Exception
     */
    public void updateLogByPrimaryKeySelective (Log log)throws Exception;

    /**
     * 日志表综合查询
     * 实现：主键ID，用户ID，历史登录IP，商品key-value，商品类别key-value，
     * 关键词（模糊），历史登录时间范围，间隔时间范围，排序规则，分页功能
     * @param pagingCustomLog
     * @return
     * @throws Exception
     */
    public List<Log> selectLog (PagingCustomLog pagingCustomLog)throws Exception;

    /**
     * 日志信息总数查询
     * @return
     * @throws Exception
     */
    public int selectLogCount () throws Exception;

     /*------------------------------------------商店表------------------------------------------------------------------*/
    /**
     * 根据主键ID删除商店信息
     * @param shopId
     * @return
     * @throws Exception
     */
    public void deleteShopByPrimaryKey (Integer shopId)throws Exception;

    /**
     * 根据主键ID数组批量删除商店信息
     * @param shopIdArrary
     * @return
     * @throws Exception
     */
    public void deleteShopByPrimaryKeyArray (@Param("shopIdArrary") Integer[] shopIdArrary)throws Exception;

    /**
     * 按需插入商店信息
     * @param shop
     * @return
     * @throws Exception
     */
    public void insertShopSelective (Shop shop)throws Exception;

    /**
     * 按需修改商店信息
     * @param shop
     * @return
     * @throws Exception
     */
    public void updateShopByPrimaryKeySelective (Shop shop)throws Exception;
}
