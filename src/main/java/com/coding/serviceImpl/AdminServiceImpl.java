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
        if (!userUuid.equals("") ) {
            try {
                userMapper.deleteUserByPrimaryKey(userUuid);
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

    /*------------------------------------------收获地址表------------------------------------------------------------------*/
    public List<Address> selectAddressAll() throws Exception {
            List<Address> addresses = addressMapper.selectAddressAll();
            if(addresses.isEmpty()) throw new Exception("查询全部收获地址表为空");
            return addresses;
    }
    /*------------------------------------------分组表------------------------------------------------------------------*/
    @Transactional(rollbackFor =Exception.class )
    public void deleteGroupsByPrimaryKey(Integer groupId)  throws Exception{
        if (groupId != 0) {
            try {
                groupsMapper.deleteGroupsByPrimaryKey(groupId);
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
        if (groupId != 0) {
            Groups groups = groupsMapper.selectGroupsByPrimaryKey(groupId);
            except(groups,"分组查询为空");
            return groups;
        }
        return null;
    }

    @Transactional(rollbackFor =Exception.class )
    public void updateGroupsByPrimaryKey(Groups groups) throws Exception {
        try {
            groupsMapper.updateGroupsByPrimaryKey(groups);
        }catch (Exception e){
            throw new Exception("修改分组信息时出错");
        }
    }

    public List<Groups> selectGroupsAll() throws Exception {
            List<Groups> groups =groupsMapper.selectGroupsAll();
            if(groups.isEmpty()) throw new Exception("分组列表查询为空");
            return groups;

    }

    /*------------------------------------------管理员表------------------------------------------------------------------*/
    @Transactional(rollbackFor =Exception.class )
    public void deleteAdminByPrimaryKey(Integer adminId) throws Exception {
        if (adminId != 0) {
            try {
                adminMapper.deleteAdminByPrimaryKey(adminId);
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
        if (adminId != 0) {
            Admin admin = adminMapper.selectAdminByPrimaryKey(adminId);
            except(admin,"管理员查询为空");
            return admin;
        }
        return null;
    }

    @Transactional(rollbackFor =Exception.class )
    public void updateAdminByPrimaryKey(Admin admin)  throws Exception{
        try {
            adminMapper.updateAdminByPrimaryKey(admin);
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

    /*------------------------------------------商品类别表------------------------------------------------------------------*/
    @Transactional(rollbackFor =Exception.class )
    public void deleteItemTypeByPrimaryKey(Integer itemTypeId) throws Exception {
        try {
            itemTypeMapper.deleteItemTypeByPrimaryKey(itemTypeId);
        }catch (Exception e){
            throw new Exception("删除商品类别时出错");
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
            itemTypeMapper.updateItemTypeByPrimaryKey(itemType);
        }catch (Exception e){
            throw new Exception("修改商品类别信息时出错");
        }
    }

    /*------------------------------------------商品表------------------------------------------------------------------*/
    @Transactional(rollbackFor =Exception.class )
    public void deleteItemByPrimaryKey(Integer itemId) throws Exception {
        try {
            itemMapper.deleteItemByPrimaryKey(itemId);
        }catch (Exception e){
            throw new Exception("删除商品时出错");
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
            itemMapper.updateItemByPrimaryKey(item);
        }catch (Exception e){
            throw new Exception("修改商品信息时出错");
        }
    }
    /*------------------------------------------库存表------------------------------------------------------------------*/
    @Transactional(rollbackFor =Exception.class )
    public void deleteRepertoryByPrimaryKey(Integer repertoryId) throws Exception {
        try {
            repertoryMapper.deleteRepertoryByPrimaryKey(repertoryId);
        }catch (Exception e){
            throw new Exception("删除库存信息时出错");
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
        if (repertoryId != 0){
            Repertory repertory = repertoryMapper.selectRepertoryByPrimaryKey(repertoryId);
            except(repertory,"查询库存信息为空");
            return  repertory;
        }
        return null;
    }

    @Transactional(rollbackFor =Exception.class )
    public void updateRepertoryByPrimaryKey(Repertory repertory) throws Exception {
        try {
            repertoryMapper.updateRepertoryByPrimaryKey(repertory);
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
        try {
            venderMapper.deleteVenderByPrimaryKey(venderId);
        }catch (Exception e){
            throw new Exception("删除厂家信息时出错");
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
        if(venderId != 0){
            Vender vender = venderMapper.selectVenderByPrimaryKey(venderId);
            except(vender,"查询厂家信息为空");
            return vender;
        }
        return null;
    }

    @Transactional(rollbackFor =Exception.class )
    public void updateVenderByPrimaryKey(Vender vender) throws Exception {
        try {
            venderMapper.updateVenderByPrimaryKey(vender);
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
