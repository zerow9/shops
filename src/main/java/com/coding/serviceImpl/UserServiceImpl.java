package com.coding.serviceImpl;

import com.coding.Iservice.IUserService;
import com.coding.comomInterface.ErrorExc;
import com.coding.mapper.*;
import com.coding.paging.*;
import com.coding.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
public class UserServiceImpl extends ErrorExc implements IUserService {
    @Autowired
    private  UserMapper userMapper;
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private ItemTypeMapper itemTypeMapper;
    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private ComplaintMapper complaintMapper;
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private OrderDetailMapper orderDetailMapper;

    /*----------------------------------------用户表------------------------------------------------------------------*/

    @Transactional(rollbackFor =Exception.class )
    public void insertUser(User user)  throws Exception{
        try{
        userMapper.insertUser(user);
        } catch (Exception e){
            throw  new Exception("插入用戶信息时出錯");
        }
    }

    public User selectUserByPrimaryKey(String userUuid) throws  Exception{
        if (userUuid != null && !userUuid.equals("")) {
            User user= userMapper.selectUserByPrimaryKey(userUuid);
             except(user,"用户查询为空");
            return user;

        }
        return null;
    }

    @Transactional(rollbackFor =Exception.class)
    public void updateUserByPrimaryKey(User user) throws Exception{
        try {
            except(userMapper.updateUserByPrimaryKey(user));
        }catch (Exception e){
            if (!e.getMessage().contains("操作无效"))
            throw new Exception("修改用户信息时出错");
                throw e;
        }


    }

    public Integer selectUserCount() throws Exception {
        try {
            return  userMapper.selectUserCount();
        }catch (Exception e){
            throw new Exception("查询用户总数时出错");
        }
    }

    public List<String> selectUserPassword(String userPhone) throws Exception {
        if (userPhone != null && !userPhone.equals("")){
            List<String> passwords = userMapper.selectUserPassword(userPhone);
            if(passwords.isEmpty()) throw new Exception("查询到的密码列表返回为空");
            return passwords;
        }
        return null;
    }

    /*------------------------------------------收获地址表------------------------------------------------------------------*/
    @Transactional(rollbackFor =Exception.class )
    public void deleteAddressByPrimaryKey(Integer addressId) throws Exception{
        if (addressId != null && addressId != 0) {
            try {
               except(addressMapper.deleteAddressByPrimaryKey(addressId));
//                addressMapper.deleteAddressByPrimaryKey(addressId);
            }catch (Exception e){
                if (!e.getMessage().contains("操作无效"))
                  throw new Exception("删除收获地址时出错");
                throw e;
            }
        }
    }

    @Transactional(rollbackFor =Exception.class )
    public void insertAddress(Address address) throws Exception{
        try {
            addressMapper.insertAddress(address);
        }catch (Exception e){
            throw new Exception("插入收获地址时出错");
        }
    }

    public Address selectAddressByPrimaryKey(Integer addressId) throws Exception {
        if (addressId != null && addressId != 0) {
            Address address = addressMapper.selectAddressByPrimaryKey(addressId);
            except(address,"收货地址查询为空");
            return address;
        }
        return null;
    }

    @Transactional(rollbackFor =Exception.class )
    public void updateAddressByPrimaryKey(Address address) throws Exception {
        try {
            except(addressMapper.updateAddressByPrimaryKey(address));
        }catch (Exception e){
            if (!e.getMessage().contains("操作无效"))
                 throw new Exception("修改收获地址时出错");
            throw e;
        }
    }


    public List<Address> selectAddressByUserID(String userUuid) throws Exception {
        if (userUuid != null && !userUuid.equals("")) {
            List<Address> addresses = addressMapper.selectAddressByUserID(userUuid);
            if(addresses.isEmpty()) throw new Exception("用户收获地址查询为空");
            return addresses;
        }
        return null;
    }
    /*------------------------------------------用户投诉表------------------------------------------------------------------*/
    @Transactional(rollbackFor =Exception.class )
    public void deleteComplaintByPrimaryKey(Integer complaintId) throws Exception {
        if (complaintId != null && complaintId != 0) {
            try {
                except(complaintMapper.deleteComplaintByPrimaryKey(complaintId));
//                addressMapper.deleteAddressByPrimaryKey(addressId);
            }catch (Exception e){
                if (!e.getMessage().contains("操作无效"))
                    throw new Exception("删除投诉信息时出错");
                throw e;
            }
        }
    }
    @Transactional(rollbackFor =Exception.class )
    public void insertComplaintSelective(Complaint complaint) throws Exception {
        try {
            complaintMapper.insertComplaintSelective(complaint);
        }catch (Exception e){
            throw new Exception("添加投诉信息时出错");
        }
    }
    @Transactional(rollbackFor =Exception.class )
    public void updateComplaintByPrimaryKeySelective(Complaint record) throws Exception {
        try {
            except(complaintMapper.updateComplaintByPrimaryKeySelective(record));
        }catch (Exception e){
            if (!e.getMessage().contains("操作无效"))
                throw new Exception("修改投诉信息时出错");
            throw e;
        }
    }

    public Complaint selectComplaintByPrimaryKey(Integer complaintId) throws Exception {
        if (complaintId != null && complaintId != 0) {
            Complaint complaint = complaintMapper.selectComplaintByPrimaryKey(complaintId);
            except(complaint,"查询用户投诉信息为空");
            return complaint;
        }
        return null;
    }

    public List<Complaint> selectComplaint(PagingCustomComplaint pagingCustomComplaint) throws Exception {
       try {
            List<Complaint> complaints = complaintMapper.selectComplaint(pagingCustomComplaint);
            if(complaints.isEmpty()) throw new Exception("用户投诉信息查询为空");
            return complaints;
       }catch (Exception e){
            if (!e.getMessage().contains("投诉信息查询为空"))
                throw new Exception("参数查询用户投诉列表出错，请检查参数");
            throw e;
    }
    }

    /*------------------------------------------商品类别表------------------------------------------------------------------*/
    public ItemType selectItemTypeByPrimaryKey(Integer itemTypeId) throws Exception {
        if (itemTypeId != null && itemTypeId != 0) {
            ItemType itemType = itemTypeMapper.selectItemTypeByPrimaryKey(itemTypeId);
            except(itemType,"查询商品类别为空");
            return itemType;
        }
        return null;
    }

    public List<ItemType> selectItemTypeAll() throws Exception {
            List<ItemType> itemTypes = itemTypeMapper.selectItemTypeAll();
            if(itemTypes.isEmpty()) throw new Exception("查询所有商品类别为空");
            return itemTypes;
    }

    public List<ItemType> selectItemType(PagingCustomItemType pagingCustomItemType) throws Exception {
        try {
            List<ItemType>  itemTypes = itemTypeMapper.selectItemType(pagingCustomItemType);
            if(itemTypes.isEmpty()) throw new Exception("查询到的商品类别列表为空");
            return itemTypes;
        }catch (Exception e){
            if (!e.getMessage().contains("商品类别列表为空"))
                throw new Exception("参数查询商品类别列表出错，请检查参数");
            throw e;
        }
    }

    public Integer selectItemTypeCount() throws Exception {
        try {
            return  itemTypeMapper.selectItemTypeCount();
        }catch (Exception e){
            throw new Exception("查询商品总数时出错");
        }
    }

    /*------------------------------------------商品表------------------------------------------------------------------*/
    public Item selectItemByPrimaryKey(Integer itemId) throws Exception {
        if (itemId != null && itemId != 0){
            Item item = itemMapper.selectItemByPrimaryKey(itemId);
            except(item,"查询商品时为空");
            return item;
        }
        return null;
    }

    public List<Item> selectItemAll() throws Exception {
            List<Item> items = itemMapper.selectItemAll();
            if(items.isEmpty()) throw new Exception("查询商品列表为空");
            return items;
    }

    public List<Item> selectItemFuzzyByItemName(String fuzzyItemName) throws Exception {
        if (fuzzyItemName != null && !fuzzyItemName.equals("")){
            List<Item> items = itemMapper.selectItemFuzzyByItemName(fuzzyItemName);
            if(items.isEmpty()) throw new Exception("没有该关键词的商品");
            return items;
        }
        return null;
    }

    public List<Item> selectItemByItemType(Integer itemTypeId) throws Exception {
        if ( itemTypeId != null && itemTypeId != 0 ){
            List<Item> items = itemMapper.selectItemByItemType(itemTypeId);
            if(items.isEmpty()) throw new Exception("没有该商品类别的商品");
            return items;
        }
        return null;
    }

    public List<Item> selectItemFuzzyByItemNameSort(String fuzzyItemName, String sortRule, String sortColumn) throws Exception {
        if(fuzzyItemName!=null && sortRule != null && sortColumn != null){
            List<Item> items;
            try {
               items =  itemMapper.selectItemFuzzyByItemNameSort(fuzzyItemName,sortRule,sortColumn);
            }catch (Exception e){throw new Exception("商品参数错误，请检查重试");}
             if(items.isEmpty()) throw new Exception("该参数查询的商品列表为空");
             return items;
        }
        return null;
    }

    public List<Item> selectItem(PagingCustomItem paging) throws Exception {
        try {
            List<Item>  items = itemMapper.selectItem(paging);
            if(items.isEmpty()) throw new Exception("查询到的商品列表为空");
            return items;
        }catch (Exception e){
            if (!e.getMessage().contains("商品列表为空"))
                throw new Exception("参数查询商品列表出错，请检查参数");
            throw e;
        }
    }
    public Integer selectItemCount() throws Exception {
        try {
            return  itemMapper.selectItemCount();
        }catch (Exception e){
            throw new Exception("查询商品总数时出错");
        }
    }

    /*------------------------------------------订单表------------------------------------------------------------------*/
    @Transactional(rollbackFor =Exception.class )
    public void deleteOrderByPrimaryKey(Integer orderId) throws Exception {
        if(orderId != null && orderId != 0){
            try {
                except(ordersMapper.deleteOrderByPrimaryKey(orderId));
            }catch (Exception e){
                if (!e.getMessage().contains("操作无效"))
                    throw new Exception("删除订单信息时出错");
                throw e;
            }
        }
    }

    @Transactional(rollbackFor =Exception.class )
    public void deleteOrderByPrimaryKeyArray(Integer[] orderIdArray) throws Exception {
        if(orderIdArray==null||"".equals(orderIdArray))throw new Exception("没有orderIdArray数组信息，批量订单删除出错");
        try {
            except(ordersMapper.deleteOrderByPrimaryKeyArray(orderIdArray));
        }catch (Exception e){
            if (!e.getMessage().contains("操作无效"))
                throw new Exception("批量删除订单时出错");
            throw e;
        }
    }

    @Transactional(rollbackFor =Exception.class )
    public void insertOrderSelective(Orders order) throws Exception {
        try {
            ordersMapper.insertOrderSelective(order);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("添加订单时出错");
        }
    }

    public Orders selectOrderByPrimaryKey(Integer orderId) throws Exception {
        if (orderId != null && orderId != 0){
            Orders orders = ordersMapper.selectOrderByPrimaryKey(orderId);
            except(orders,"根据订单ID查询订单为空");
            return orders;
        }
        return null;
    }

    public List<Orders> selectOrder(PagingCustomOrder pagingCustomOrder) throws Exception {
        try {
            List<Orders>  orders = ordersMapper.selectOrder(pagingCustomOrder);
            if(orders.isEmpty()) throw new Exception("查询到的订单列表为空");
            return orders;
        }catch (Exception e){
            if (!e.getMessage().contains("订单列表为空"))
                throw new Exception("参数查询订单列表出错，请检查参数");
            throw e;
        }
    }

    /*------------------------------------------订单详情表------------------------------------------------------------------*/
    public OrderDetail selectOrderDetailByPrimaryKey(Integer orderDetailId) throws Exception {
        if (orderDetailId != null && orderDetailId != 0){
            OrderDetail orderDetail = orderDetailMapper.selectOrderDetailByPrimaryKey(orderDetailId);
            except(orderDetail,"根据订单ID查询订单为空");
            return orderDetail;
        }
        return null;
    }

    @Transactional(rollbackFor =Exception.class )
    public void deleteOrderDetailByPrimaryKey(Integer orderDetailId) throws Exception {
        if(orderDetailId != null && orderDetailId != 0){
            try {
                except(orderDetailMapper.deleteOrderDetailByPrimaryKey(orderDetailId));
            }catch (Exception e){
                if (!e.getMessage().contains("操作无效"))
                    throw new Exception("删除订单详情信息时出错");
                throw e;
            }
        }
    }

    @Transactional(rollbackFor =Exception.class )
    public void deleteOrderDetailByPrimaryKeyArray(Integer[] oderDetailIdArray) throws Exception {
        if(oderDetailIdArray==null||"".equals(oderDetailIdArray))throw new Exception("没有oderDetailIdArray数组信息，批量订单详情删除出错");
        try {
            except(orderDetailMapper.deleteOrderDetailByPrimaryKeyArray(oderDetailIdArray));
        }catch (Exception e){
            if (!e.getMessage().contains("操作无效"))
                throw new Exception("批量删除订单详情时出错");
            throw e;
        }
    }

    @Transactional(rollbackFor =Exception.class )
    public void insertOrderDetailSelective(OrderDetail orderDetail) throws Exception {
        try {
            orderDetailMapper.insertOrderDetailSelective(orderDetail);
        }catch (Exception e){
            throw new Exception("添加订单详情时出错");
        }
    }

    public List<OrderDetail> selectOrderDetail(PagingCustomOrderDetail pagingCustomOrderDetail) throws Exception {
        try {
            List<OrderDetail>  orderDetails = orderDetailMapper.selectOrderDetail(pagingCustomOrderDetail);
            if(orderDetails.isEmpty()) throw new Exception("查询到的商品详情列表为空");
            return orderDetails;
        }catch (Exception e){
            if (!e.getMessage().contains("商品详情列表为空"))
                throw e;
            throw e;
        }
    }

}
