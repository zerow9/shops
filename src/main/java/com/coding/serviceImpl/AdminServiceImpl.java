package com.coding.serviceImpl;

import com.coding.Iservice.IAdminService;
import com.coding.mapper.*;
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


    /*------------------------------------------用户表------------------------------------------------------------------*/
    @Transactional(rollbackFor =Exception.class )
    public void deleteUserByPrimaryKey(String userUuid)  throws Exception{
        if (userUuid != null && !userUuid.equals("") ) {
            try {
                except(userMapper.deleteUserByPrimaryKey(userUuid));
            }catch (Exception e){
                throw new Exception("删除用户信息时出错");
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
            throw new Exception("批量删除用户时出错");
        }

    }

    public List<User> selectUserAllPaging(Integer nowPage, Integer number) throws Exception {
        exceptInitialize(nowPage,number);
        if(nowPage < 0) nowPage = 0;
        List<User> users = userMapper.selectUserAllPaging(nowPage,number);
        if(users.isEmpty()) throw new Exception("分页查询到的用户列表为空，或者已经是最后一页");
        return users;
    }

    public List<User> selectUserPagingByKeyWord(PagingCustomUser paging) throws Exception {
       try {
           List<User>  users = userMapper.selectUserPagingByKeyWord(paging);
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
        Integer count ;
        try {
            count  = addressMapper.selectAddressCount();
        }catch (Exception e){
            throw new Exception("查询收货地址总数是出错");
        }
        return count;
    }

    /*------------------------------------------分组表------------------------------------------------------------------*/
    @Transactional(rollbackFor =Exception.class )
    public void deleteGroupsByPrimaryKey(Integer groupId)  throws Exception{
        if (groupId != null && groupId != 0) {
            try {
                except(groupsMapper.deleteGroupsByPrimaryKey(groupId));
            }catch (Exception e){
                throw new Exception("删除分组信息时出错");
            }
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
            throw new Exception("修改分组信息时出错");
        }
    }

    public List<Groups> selectGroupsAll() throws Exception {
            List<Groups> groups =groupsMapper.selectGroupsAll();
            if(groups.isEmpty()) throw new Exception("分组列表查询为空");
            return groups;

    }

    public List<Groups> selectGroupsPaging(Integer nowPage,Integer number) throws Exception{
        exceptInitialize(nowPage,number);
        PagingCustomGroups pagingCustomGroups = new PagingCustomGroups();
        pagingCustomGroups.setIndexNumber(nowPage);
        pagingCustomGroups.setPageNumber(number);
        if(nowPage < 0) nowPage = 0;
        List<Groups> groups = groupsMapper.selectGroups(pagingCustomGroups);
        if(groups.isEmpty()) throw new Exception("分页查询到的用户列表为空，或者已经是最后一页");
        return groups;
    }

    /*------------------------------------------管理员表------------------------------------------------------------------*/
    @Transactional(rollbackFor =Exception.class )
    public void deleteAdminByPrimaryKey(Integer adminId) throws Exception {
        if (adminId != null && adminId != 0) {
            try {
                except(adminMapper.deleteAdminByPrimaryKey(adminId));
            }catch (Exception e){
                throw new Exception("删除管理员时出错");
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
            throw new Exception("修改管理员信息时出错");
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
            throw new Exception("批量删除管理员时出错");
        }
    }

    public List<Admin> selectAdminAllPaging(Integer nowPage, Integer number) throws Exception {
        exceptInitialize(nowPage,number);
        if(nowPage < 0) nowPage = 0;
        List<Admin> admins = adminMapper.selectAdminAllPaging(nowPage,number);
        if(admins.isEmpty()) throw new Exception("分页查询到的用户列表为空，或者已经是最后一页");
        return admins;
    }

    public List<String> selectAdminPassword(String adminAccount) throws Exception {
        if (adminAccount != null && !adminAccount.equals("")){
            List<String> passwords = adminMapper.selectAdminPassword(adminAccount);
            if(passwords.isEmpty()) throw new Exception("查询到的密码列表返回为空");
            return passwords;
        }
            return null;
    }

    /*------------------------------------------商品类别表------------------------------------------------------------------*/
    @Transactional(rollbackFor =Exception.class )
    public void deleteItemTypeByPrimaryKey(Integer itemTypeId) throws Exception {
        if (itemTypeId != null && itemTypeId != 0){
        try {
            except(itemTypeMapper.deleteItemTypeByPrimaryKey(itemTypeId));
        }catch (Exception e){
            throw new Exception("删除商品类别时出错");
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
            throw new Exception("修改商品类别信息时出错");
        }
    }

    /*------------------------------------------商品表------------------------------------------------------------------*/
    @Transactional(rollbackFor =Exception.class )
    public void deleteItemByPrimaryKey(Integer itemId) throws Exception {
        if (itemId != null && itemId !=0){
        try {
            except(itemMapper.deleteItemByPrimaryKey(itemId));
        }catch (Exception e){
            throw new Exception("删除商品时出错");
        }
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
            throw new Exception("修改商品信息时出错");
        }
    }
    /*------------------------------------------库存表------------------------------------------------------------------*/
    @Transactional(rollbackFor =Exception.class )
    public void deleteRepertoryByPrimaryKey(Integer repertoryId) throws Exception {
        if(repertoryId != null && repertoryId != 0){
        try {
            except(repertoryMapper.deleteRepertoryByPrimaryKey(repertoryId));
        }catch (Exception e){
            throw new Exception("删除库存信息时出错");
        }
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
            throw new Exception("修改库存信息时出错");
        }
    }

    public List<Repertory> selectRepertoryAll() throws Exception {
        List<Repertory> repertories = repertoryMapper.selectRepertoryAll();
        if(repertories.isEmpty()) throw new Exception("查询库存列表为空");
//        except(repertories,"查询库存列表为空");
        return repertories;
    }
    /*------------------------------------------厂家信息表------------------------------------------------------------------*/
    @Transactional(rollbackFor =Exception.class )
    public void deleteVenderByPrimaryKey(Integer venderId) throws Exception {
        if(venderId != null && venderId != 0){
        try {
            except(venderMapper.deleteVenderByPrimaryKey(venderId));
        }catch (Exception e){
            throw new Exception("删除厂家信息时出错");
        }
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
            throw new Exception("修改厂家信息时出错");
        }
    }

    public List<Vender> selectVenderAll() throws Exception {
        List<Vender> venders = venderMapper.selectVenderAll();
        if(venders.isEmpty()) throw new Exception("查询厂家列表为空");
//        except(venders,"查询厂家列表为空");
        return venders;
    }


}
