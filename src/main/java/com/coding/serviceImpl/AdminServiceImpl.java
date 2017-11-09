package com.coding.serviceImpl;

import com.coding.Iservice.IAdminService;
import com.coding.mapper.*;
import com.coding.paging.*;
import com.coding.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("adminService")
public class AdminServiceImpl extends UserServiceImpl implements IAdminService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private GroupsMapper groupsMapper;
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private ItemTypeMapper itemTypeMapper;
    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private RepertoryMapper repertoryMapper;
    @Autowired
    private VenderMapper venderMapper;
    @Autowired
    private ComplaintMapper complaintMapper;
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private OrderDetailMapper orderDetailMapper;
    @Autowired
    private NoticeMapper noticeMapper;
    @Autowired
    private LogMapper logMapper;
    @Autowired
    private ShopMapper shopMapper;


    /*------------------------------------------用户表------------------------------------------------------------------*/
    @Transactional(rollbackFor =Exception.class )
    public void deleteUserByPrimaryKey(String userUuid)  throws Exception{
        if (userUuid != null && !userUuid.equals("") ) {
            try {
                except(userMapper.deleteUserByPrimaryKey(userUuid));
            }catch (Exception e){
                if (!e.getMessage().contains("操作无效"))
                 throw new Exception("删除用户信息时出错");
                throw e;
            }
        }
    }
    public List<User> selectUserAll()  throws Exception{
            List<User> users = userMapper.selectUserAll();
            if(users.isEmpty()) throw new Exception("用户列表查询为空");
            return users;
    }

    public User selectUserByPhone(String userPhone) throws Exception {
        if (userPhone != null && !userPhone.equals("")) {
            User user= userMapper.selectUserByPhone(userPhone);
            except(user,"根据电话查询用户信息为空");
            return user;
        }
        return null;
    }

    public List<User> selectUserByGroupId(Integer user_group) throws Exception {
        if (user_group != null &&user_group!=0){
        List<User> users = userMapper.selectUserByGroupId(user_group);
        if(users.isEmpty()) throw new Exception("根据分组查询用户列表为空");
        return users;
        }
        return null;
    }

    public List<User> selectUserByScoreRange(Integer former, Integer latter) throws Exception {
        except(former,latter);
        List<User> users = userMapper.selectUserByScoreRange(former,latter);
        if(users.isEmpty()) throw new Exception("根据积分范围查询用户列表为空");
        return users;
    }

    public List<User> selectUserByAgeRange(Integer former, Integer latter) throws Exception {
        except(former,latter);
        List<User> users = userMapper.selectUserByAgeRange(former,latter);
        if(users.isEmpty()) throw new Exception("根据年龄范围查询用户列表为空");
        return users;
    }

    @Transactional(rollbackFor =Exception.class )
    public void deleteUsersByUuidArray(String[] user_uuidArray) throws Exception {
        if(user_uuidArray==null||"".equals(user_uuidArray))throw new Exception("没有uuid数组信息，批量用户删除出错");
        try {
            except(userMapper.deleteUsersByUuidArray(user_uuidArray));
        }catch (Exception e){
            if (!e.getMessage().contains("操作无效"))
                throw new Exception("批量删除用户时出错");
            throw e;
        }

    }

    public List<User> selectUserAllPaging(Integer nowPage, Integer number) throws Exception {
        exceptInitialize(nowPage,number);
        if(nowPage < 0) nowPage = 0;
        List<User> users = userMapper.selectUserAllPaging(nowPage,number);
        if(users.isEmpty()) throw new Exception("分页查询到的用户列表为空，或者已经是最后一页");
        return users;
    }

    public List<User> selectUser(PagingCustomUser paging) throws Exception {
       try {
           List<User>  users = userMapper.selectUser(paging);
           if(users.isEmpty()) throw new Exception("查询到的用户列表为空");
           return users;
       }catch (Exception e){
           if (!e.getMessage().contains("用户列表为空"))
            throw new Exception("参数查询用户列表出错，请检查参数");
           throw e;
    }
    }

    /*------------------------------------------收获地址表------------------------------------------------------------------*/
    public List<Address> selectAddressAll() throws Exception {
            List<Address> addresses = addressMapper.selectAddressAll();
            if(addresses.isEmpty()) throw new Exception("查询全部收获地址表为空");
            return addresses;
    }

    public Integer selectAddressCount() throws Exception {
        try {
            return addressMapper.selectAddressCount();
        }catch (Exception e){
            throw new Exception("查询收货地址总数时出错");
        }
    }

    /*------------------------------------------分组表------------------------------------------------------------------*/
    @Transactional(rollbackFor =Exception.class )
    public void deleteGroupsByPrimaryKey(Integer groupId)  throws Exception{
        if (groupId != null && groupId != 0) {
            try {
                except(groupsMapper.deleteGroupsByPrimaryKey(groupId));
            }catch (Exception e){
                if (!e.getMessage().contains("操作无效"))
                    throw new Exception("删除分组信息时出错");
                throw e;
            }
        }
    }

    public void deleteGroupsByPrimaryKeyArray(Integer[] groups_idArray) throws Exception {
        if(groups_idArray==null||"".equals(groups_idArray))throw new Exception("没有groups数组信息，批量分组删除出错");
        try {
            except(groupsMapper.deleteGroupsByPrimaryKeyArray(groups_idArray));
        }catch (Exception e){
            if (!e.getMessage().contains("操作无效"))
                throw new Exception("批量删除分组时出错");
            throw e;
        }

    }

    @Transactional(rollbackFor =Exception.class )
    public void insertGroups(Groups groups)  throws Exception{
        try {
            groupsMapper.insertGroups(groups);
        }catch (Exception e){
            throw new Exception("插入分组信息时出错");
        }
    }

    public Groups selectGroupsByPrimaryKey(Integer groupId)  throws Exception{
        if (groupId != null && groupId != 0) {
            Groups groups = groupsMapper.selectGroupsByPrimaryKey(groupId);
            except(groups,"分组查询为空");
            return groups;
        }
        return null;
    }

    @Transactional(rollbackFor =Exception.class )
    public void updateGroupsByPrimaryKey(Groups groups) throws Exception {
        try {
            except(groupsMapper.updateGroupsByPrimaryKey(groups));
        }catch (Exception e){
            if (!e.getMessage().contains("操作无效"))
                throw new Exception("修改分组信息时出错");
            throw e;
        }
    }

    public List<Groups> selectGroupsAll() throws Exception {
            List<Groups> groups =groupsMapper.selectGroupsAll();
            if(groups.isEmpty()) throw new Exception("分组列表查询为空");
            return groups;

    }

    public List<Groups> selectGroups(PagingCustomGroups pagingCustomGroups) throws Exception{
        try {
            List<Groups> groups = groupsMapper.selectGroups(pagingCustomGroups);
            if(groups.isEmpty()) throw new Exception("查询到的用户列表为空");
            return groups;
        }catch (Exception e){
            if(!e.getMessage().contains("用户列表为空"))
                throw new Exception("查询参数不正确");
            throw e;
        }
    }

    public List<Groups> selectGroupsPaging(Integer nowPage, Integer number) throws Exception {
        exceptInitialize(nowPage,number);
        PagingCustomGroups pagingCustomGroups = new PagingCustomGroups();
        if(nowPage < 0) nowPage = 0;
        pagingCustomGroups.setIndexNumber(nowPage);
        pagingCustomGroups.setPageNumber(number);
        List<Groups> groups = groupsMapper.selectGroups(pagingCustomGroups);
        if(groups.isEmpty()) throw new Exception("分页查询到的分组列表为空，或者已经是最后一页");
        return groups;
    }

    public Integer selectGroupsCount() throws Exception {
        try {
            return groupsMapper.selectGroupsCount();
        }catch (Exception e){
            throw new Exception("查询收货地址总数时出错");
        }
    }

    /*------------------------------------------管理员表------------------------------------------------------------------*/
    @Transactional(rollbackFor =Exception.class )
    public void deleteAdminByPrimaryKey(Integer adminId) throws Exception {
        if (adminId != null && adminId != 0) {
            try {
                except(adminMapper.deleteAdminByPrimaryKey(adminId));
            }catch (Exception e){
                if (!e.getMessage().contains("操作无效"))
                    throw new Exception("删除管理员时出错");
                throw e;
            }
        }
    }

    @Transactional(rollbackFor =Exception.class )
    public void insertAdmin(Admin admin)  throws Exception{
        try {
            adminMapper.insertAdmin(admin);
        }catch (Exception e){
            throw new Exception("插入管理员时出错");
        }
    }

    public Admin selectAdminByPrimaryKey(Integer adminId)  throws Exception{
        if (adminId != null && adminId != 0) {
            Admin admin = adminMapper.selectAdminByPrimaryKey(adminId);
            except(admin,"管理员查询为空");
            return admin;
        }
        return null;
    }

    @Transactional(rollbackFor =Exception.class )
    public void updateAdminByPrimaryKey(Admin admin)  throws Exception{
        try {
            except(adminMapper.updateAdminByPrimaryKey(admin));
        }catch (Exception e){
            if (!e.getMessage().contains("操作无效"))
                throw new Exception("修改管理员信息时出错");
            throw e;
        }
    }

    public List<Admin> selectAdminAll() throws Exception {
        List<Admin> admins = adminMapper.selectAdminAll();
        if(admins.isEmpty()) throw new Exception("管理员列表查询为空");
//        except(admins,"管理员列表查询为空");
        return admins;
    }
    @Transactional(rollbackFor =Exception.class )
    public void deleteAdminByAdminIdArray(Integer[] adminIdArray) throws Exception {
        if(adminIdArray==null||"".equals(adminIdArray))throw new Exception("没有adminid数组信息，批量管理员删除出错");
        try {
            except(adminMapper.deleteAdminByAdminIdArray(adminIdArray));
        }catch (Exception e){
            if (!e.getMessage().contains("操作无效"))
                throw new Exception("批量删除管理员时出错");
            throw e;
        }
    }

    public List<Admin> selectAdminAllPaging(Integer nowPage, Integer number) throws Exception {
        exceptInitialize(nowPage,number);
        if(nowPage < 0) nowPage = 0;
        List<Admin> admins = adminMapper.selectAdminAllPaging(nowPage,number);
        if(admins.isEmpty()) throw new Exception("分页查询到的用户列表为空，或者已经是最后一页");
        return admins;
    }

    public Integer selectAdminCount() throws Exception {
        try {
            return  adminMapper.selectAdminCount();
        }catch (Exception e){
            throw new Exception("查询管理员总数时出错");
        }
    }

    public List<String> selectAdminPassword(String adminAccount) throws Exception {
        if (adminAccount != null && !adminAccount.equals("")){
            List<String> passwords = adminMapper.selectAdminPassword(adminAccount);
            if(passwords.isEmpty()) throw new Exception("查询到的密码列表返回为空");
            return passwords;
        }
            return null;
    }

    /*------------------------------------------用户投诉表------------------------------------------------------------------*/


    public Integer selectComplaintCount() throws Exception {
        try {
            return  complaintMapper.selectComplaintCount();
        }catch (Exception e){
            throw new Exception("查询投诉表总数时出错");
        }
    }

    /*------------------------------------------商品类别表------------------------------------------------------------------*/
    @Transactional(rollbackFor =Exception.class )
    public void deleteItemTypeByPrimaryKey(Integer itemTypeId) throws Exception {
        if (itemTypeId != null && itemTypeId != 0){
        try {
            except(itemTypeMapper.deleteItemTypeByPrimaryKey(itemTypeId));
        }catch (Exception e){
            if (!e.getMessage().contains("操作无效"))
                throw new Exception("删除商品类别时出错");
            throw e;
        }
        }
    }

    @Transactional(rollbackFor =Exception.class )
    public void insertItemType(ItemType itemType) throws Exception {
        try {
            itemTypeMapper.insertItemType(itemType);
        }catch (Exception e){
            throw new Exception("插入商品类别时出错");
        }
    }

    @Transactional(rollbackFor =Exception.class )
    public void updateItemTypeByPrimaryKey(ItemType itemType) throws Exception {
        try {
            except(itemTypeMapper.updateItemTypeByPrimaryKey(itemType));
        }catch (Exception e){
            if (!e.getMessage().contains("操作无效"))
                throw new Exception("修改商品类别信息时出错");
            throw e;
        }
    }

    /*------------------------------------------商品表------------------------------------------------------------------*/
    @Transactional(rollbackFor =Exception.class )
    public void deleteItemByPrimaryKey(Integer itemId) throws Exception {
        if (itemId != null && itemId !=0){
        try {
            except(itemMapper.deleteItemByPrimaryKey(itemId));
        }catch (Exception e){
            if (!e.getMessage().contains("操作无效"))
                throw new Exception("删除商品时出错");
            throw e;
        }
        }
    }

    @Transactional(rollbackFor =Exception.class )
    public void deleteItemByItemIdArray(Integer[] itemIdArray) throws Exception {
        if(itemIdArray==null||"".equals(itemIdArray))throw new Exception("没有itemIdArray数组信息，批量商品删除出错");
        try {
            except(itemMapper.deleteItemByItemIdArray(itemIdArray));
        }catch (Exception e){
            if (!e.getMessage().contains("操作无效"))
                throw new Exception("批量删除商品时出错");
            throw e;
        }
    }

    @Transactional(rollbackFor =Exception.class )
    public void insertItem(Item item) throws Exception {
        try {
            itemMapper.insertItem(item);
        }catch (Exception e){
            throw new Exception("添加商品时出错");
        }
    }

    @Transactional(rollbackFor =Exception.class )
    public void updateItemByPrimaryKey(Item item) throws Exception {
        try {
            except(itemMapper.updateItemByPrimaryKey(item));
        }catch (Exception e){
            if (!e.getMessage().contains("操作无效"))
                throw new Exception("修改商品信息时出错");
            throw e;
        }
    }



    /*------------------------------------------库存表------------------------------------------------------------------*/
    @Transactional(rollbackFor =Exception.class )
    public void deleteRepertoryByPrimaryKey(Integer repertoryId) throws Exception {
        if(repertoryId != null && repertoryId != 0){
        try {
            except(repertoryMapper.deleteRepertoryByPrimaryKey(repertoryId));
        }catch (Exception e){
            if (!e.getMessage().contains("操作无效"))
                throw new Exception("删除库存信息时出错");
            throw e;
        }
    }
    }
    @Transactional(rollbackFor =Exception.class )
    public void deleteRepertoryByPrimaryKeyArray(Integer[] repertoryIdArrary) throws Exception {
        if(repertoryIdArrary==null||"".equals(repertoryIdArrary))throw new Exception("没有repertoryIdArrary数组信息，批量库存删除出错");
        try {
            except(repertoryMapper.deleteRepertoryByPrimaryKeyArray(repertoryIdArrary));
        }catch (Exception e){
            if (!e.getMessage().contains("操作无效"))
                throw new Exception("批量删除库存时出错");
            throw e;
        }
    }

    @Transactional(rollbackFor =Exception.class )
    public void insertRepertory(Repertory repertory) throws Exception {
        try {
            repertoryMapper.insertRepertory(repertory);
        }catch (Exception e){
            throw new Exception("添加库存信息时出错");
        }
    }

    public Repertory selectRepertoryByPrimaryKey(Integer repertoryId) throws Exception {
        if(repertoryId != null && repertoryId != 0){
            Repertory repertory = repertoryMapper.selectRepertoryByPrimaryKey(repertoryId);
            except(repertory,"查询库存信息为空");
            return  repertory;
        }
        return null;
    }

    @Transactional(rollbackFor =Exception.class )
    public void updateRepertoryByPrimaryKey(Repertory repertory) throws Exception {
        try {
            except(repertoryMapper.updateRepertoryByPrimaryKey(repertory));
        }catch (Exception e){
            if (!e.getMessage().contains("操作无效"))
                throw new Exception("修改库存信息时出错");
            throw e;
        }
    }

    public List<Repertory> selectRepertoryAll() throws Exception {
        List<Repertory> repertories = repertoryMapper.selectRepertoryAll();
        if(repertories.isEmpty()) throw new Exception("查询库存列表为空");
//        except(repertories,"查询库存列表为空");
        return repertories;
    }

    public List<Repertory> selectRepertory(PagingCustomRepertory pagingCustomRepertory) throws Exception {
        try {
            List<Repertory>  repertories = repertoryMapper.selectRepertory(pagingCustomRepertory);
            if(repertories.isEmpty()) throw new Exception("查询到的库存列表为空");
            return repertories;
        }catch (Exception e){
            if (!e.getMessage().contains("库存列表为空"))
                throw new Exception("参数查库存品列表出错，请检查参数");
            throw e;
        }
    }

    public Integer selectRepertoryCount() throws Exception {
        try {
            return  repertoryMapper.selectRepertoryCount();
        }catch (Exception e){
            throw new Exception("查询库存表总数时出错");
        }
    }

    /*------------------------------------------厂家信息表------------------------------------------------------------------*/
    @Transactional(rollbackFor =Exception.class )
    public void deleteVenderByPrimaryKey(Integer venderId) throws Exception {
        if(venderId != null && venderId != 0){
        try {
            except(venderMapper.deleteVenderByPrimaryKey(venderId));
        }catch (Exception e){
            if (!e.getMessage().contains("操作无效"))
                throw new Exception("删除厂家信息时出错");
            throw e;
        }
        }
    }
    @Transactional(rollbackFor =Exception.class )
    public void deleteVenderByPrimaryKeyArray(Integer[] venderIdArrary) throws Exception {
        if(venderIdArrary==null||"".equals(venderIdArrary))throw new Exception("没有venderIdArrary组信息，批量厂家删除出错");
        try {
            except(venderMapper.deleteVenderByPrimaryKeyArray(venderIdArrary));
        }catch (Exception e){
            if (!e.getMessage().contains("操作无效"))
                throw new Exception("批量删除厂家时出错");
            throw e;
        }
    }

    @Transactional(rollbackFor =Exception.class )
    public void insertVender(Vender vender) throws Exception {
        try {
            venderMapper.insertVender(vender);
        }catch (Exception e){
            throw new Exception("添加厂家信息时出错");
        }

    }

    public Vender selectVenderByPrimaryKey(Integer venderId) throws Exception {
        if(venderId != null && venderId != 0){
            Vender vender = venderMapper.selectVenderByPrimaryKey(venderId);
            except(vender,"查询厂家信息为空");
            return vender;
        }
        return null;
    }

    @Transactional(rollbackFor =Exception.class )
    public void updateVenderByPrimaryKey(Vender vender) throws Exception {
        try {
            except(venderMapper.updateVenderByPrimaryKey(vender));
        }catch (Exception e){
            if (!e.getMessage().contains("操作无效"))
                throw new Exception("修改厂家信息时出错");
            throw e;
        }
    }

    public List<Vender> selectVenderAll() throws Exception {
        List<Vender> venders = venderMapper.selectVenderAll();
        if(venders.isEmpty()) throw new Exception("查询厂家列表为空");
//        except(venders,"查询厂家列表为空");
        return venders;
    }

    public List<Vender> selectVender(PagingCustomVender pagingCustomVender) throws Exception {
        try {
            List<Vender>  venders = venderMapper.selectVender(pagingCustomVender);
            if(venders.isEmpty()) throw new Exception("查询到的厂商列表为空");
            return venders;
        }catch (Exception e){
            if (!e.getMessage().contains("厂商列表为空"))
                throw new Exception("参数查询厂商列表出错，请检查参数");
            throw e;
        }
    }

    public int selectVenderCount() throws Exception {
        try {
            return  venderMapper.selectVenderCount();
        }catch (Exception e){
            throw new Exception("查询厂家表总数时出错");
        }
    }
    /*------------------------------------------订单表------------------------------------------------------------------*/
    @Transactional(rollbackFor =Exception.class )
    public void updateOrderByPrimaryKeySelective(Orders order) throws Exception {
        try {
            except(ordersMapper.updateOrderByPrimaryKeySelective(order));
        }catch (Exception e){
            if (!e.getMessage().contains("操作无效"))
                throw new Exception("修改订单信息时出错");
            throw e;
        }
    }

    public Integer selectOrderCount() throws Exception {
        try {
            return  ordersMapper.selectOrderCount();
        }catch (Exception e){
            throw new Exception("查询订单表总数时出错");
        }
    }

    /*------------------------------------------订单详情表------------------------------------------------------------------*/
    @Transactional(rollbackFor =Exception.class )
    public void updateOrderDetailByPrimaryKeySelective(OrderDetail orderDetail) throws Exception {
        try {
            except(orderDetailMapper.updateOrderDetailByPrimaryKeySelective(orderDetail));
        }catch (Exception e){
            if (!e.getMessage().contains("操作无效"))
                throw new Exception("修改订单详情信息时出错");
            throw e;
        }
    }

    public Integer selectOrderDetailCount() throws Exception {
        try {
            return  orderDetailMapper.selectOrderDetailCount();
        }catch (Exception e){
            throw new Exception("查询订单详情表总数时出错");
        }
    }
    /*------------------------------------------公告表------------------------------------------------------------------*/


    @Transactional(rollbackFor =Exception.class )
    public void deleteNoticeByPrimaryKey(Integer noticeId) throws Exception {
        if(noticeId != null && noticeId != 0){
            try {
                except(noticeMapper.deleteNoticeByPrimaryKey(noticeId));
            }catch (Exception e){
                if (!e.getMessage().contains("操作无效"))
                    throw new Exception("删除公告信息时出错");
                throw e;
            }
        }
    }

    @Transactional(rollbackFor =Exception.class )
    public void deleteNoticeByPrimaryKeyArray(Integer[] noticeIdArrary) throws Exception {
        if(noticeIdArrary==null||"".equals(noticeIdArrary))throw new Exception("没有noticeIdArrary数组信息，批量公告删除出错");
        try {
            except(noticeMapper.deleteNoticeByPrimaryKeyArray(noticeIdArrary));
        }catch (Exception e){
            if (!e.getMessage().contains("操作无效"))
                throw new Exception("批量删除公告时出错");
            throw e;
        }
    }

    @Transactional(rollbackFor =Exception.class )
    public void insertNoticeSelective(Notice notice) throws Exception {
        try {
            noticeMapper.insertNoticeSelective(notice);
        }catch (Exception e){
            throw new Exception("添加公告时出错");
        }
    }

    @Transactional(rollbackFor =Exception.class )
    public void updateNoticeByPrimaryKeySelective(Notice notice) throws Exception {
        try {
            except(noticeMapper.updateNoticeByPrimaryKeySelective(notice));
        }catch (Exception e){
            if (!e.getMessage().contains("操作无效"))
                throw new Exception("修改公告信息时出错");
            throw e;
        }
    }



    /*------------------------------------------日志表------------------------------------------------------------------*/
    public Log selectLogByPrimaryKey(Integer logId) throws Exception {
        if (logId != null && logId != 0){
            Log log = logMapper.selectLogByPrimaryKey(logId);
            except(log,"根据日志ID查询日志为空");
            return log;
        }
        return null;
    }

    @Transactional(rollbackFor =Exception.class )
    public void deleteLogByPrimaryKey(Integer logId) throws Exception {
        if(logId != null && logId != 0){
            try {
                except(logMapper.deleteLogByPrimaryKey(logId));
            }catch (Exception e){
                if (!e.getMessage().contains("操作无效"))
                    throw new Exception("删除日志信息时出错");
                throw e;
            }
        }
    }

    @Transactional(rollbackFor =Exception.class )
    public void deleteLogByPrimaryKeyArray(Integer[] logIdArrary) throws Exception {
        if(logIdArrary==null||"".equals(logIdArrary))throw new Exception("没有logIdArrary数组信息，批量日志删除出错");
        try {
            except(logMapper.deleteLogByPrimaryKeyArray(logIdArrary));
        }catch (Exception e){
            if (!e.getMessage().contains("操作无效"))
                throw new Exception("批量删除日志时出错");
            throw e;
        }
    }

    @Transactional(rollbackFor =Exception.class )
    public void insertLogSelective(Log log) throws Exception {
        try {
            logMapper.insertLogSelective(log);
        }catch (Exception e){
            throw new Exception("添加日志时出错");
        }
    }

    @Transactional(rollbackFor =Exception.class )
    public void updateLogByPrimaryKeySelective(Log log) throws Exception {
        try {
            except(logMapper.updateLogByPrimaryKeySelective(log));
        }catch (Exception e){
            if (!e.getMessage().contains("操作无效"))
                throw new Exception("修改日志信息时出错");
            throw e;
        }
    }

    public List<Log> selectLog(PagingCustomLog pagingCustomLog) throws Exception {
        try {
            List<Log>  logs = logMapper.selectLog(pagingCustomLog);
            if(logs.isEmpty()) throw new Exception("查询到的日志列表为空");
            return logs;
        }catch (Exception e){
            if (!e.getMessage().contains("日志列表为空"))
                throw new Exception("参数查询日志列表出错，请检查参数");
            throw e;
        }
    }

    public int selectLogCount() throws Exception {
        try {
            return  logMapper.selectLogCount();
        }catch (Exception e){
            throw new Exception("查询日志信息总数时出错");
        }
    }

    /*------------------------------------------商店表------------------------------------------------------------------*/
    @Transactional(rollbackFor =Exception.class )
    public void deleteShopByPrimaryKey(Integer shopId) throws Exception {
        if(shopId != null && shopId != 0){
            try {
                except(shopMapper.deleteShopByPrimaryKey(shopId));
            }catch (Exception e){
                if (!e.getMessage().contains("操作无效"))
                    throw new Exception("删除商店信息时出错");
                throw e;
            }
        }
    }

    @Transactional(rollbackFor =Exception.class )
    public void deleteShopByPrimaryKeyArray(Integer[] shopIdArrary) throws Exception {
        if(shopIdArrary==null||"".equals(shopIdArrary))throw new Exception("没有shopIdArrary数组信息，批量商店删除出错");
        try {
            except(shopMapper.deleteShopByPrimaryKeyArray(shopIdArrary));
        }catch (Exception e){
            if (!e.getMessage().contains("操作无效"))
                throw new Exception("批量删除商店时出错");
            throw e;
        }
    }

    @Transactional(rollbackFor =Exception.class )
    public void insertShopSelective(Shop shop) throws Exception {
        try {
            shopMapper.insertShopSelective(shop);
        }catch (Exception e){
            throw new Exception("添加商店时出错");
        }
    }

    @Transactional(rollbackFor =Exception.class )
    public void updateShopByPrimaryKeySelective(Shop shop) throws Exception {
        try {
            except(shopMapper.updateShopByPrimaryKeySelective(shop));
        }catch (Exception e){
            if (!e.getMessage().contains("操作无效"))
                throw new Exception("修改商店信息时出错");
            throw e;
        }
    }


}
