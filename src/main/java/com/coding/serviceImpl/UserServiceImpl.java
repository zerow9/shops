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
    @Autowired
    private NoticeMapper noticeMapper;
    @Autowired
    private ShopMapper shopMapper;
    @Autowired
    private ScoreMapper scoreMapper;

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
                throw new Exception("参数查询商品详情列表出错，请检查参数");
            throw e;
        }
    }

    /*------------------------------------------公告表------------------------------------------------------------------*/

    public Notice selectNoticeByPrimaryKey(Integer noticeId) throws Exception {
        if (noticeId != null && noticeId != 0){
            Notice notice = noticeMapper.selectNoticeByPrimaryKey(noticeId);
            except(notice,"根据公告ID查询公告为空");
            return notice;
        }
        return null;
    }

    public List<Notice> selectNotice(PagingCustomNotice pagingCustomNotice) throws Exception {
        try {
            List<Notice>  notices = noticeMapper.selectNotice(pagingCustomNotice);
            if(notices.isEmpty()) throw new Exception("查询到的公告列表为空");
            return notices;
        }catch (Exception e){
            if (!e.getMessage().contains("公告列表为空"))
                throw new Exception("参数公告列表出错，请检查参数");
            throw e;
        }
    }

    public int selectNoticeCount() throws Exception {
        try {
            return  noticeMapper.selectNoticeCount();
        }catch (Exception e){
            throw new Exception("查询公告信息总数时出错");
        }
    }

    /*------------------------------------------商店表------------------------------------------------------------------*/
    public Shop selectShopByPrimaryKey(Integer shopId) throws Exception {
        if (shopId != null && shopId != 0){
            Shop shop = shopMapper.selectShopByPrimaryKey(shopId);
            except(shop,"根据商店ID查询商店为空");
            return shop;
        }
        return null;
}

    public List<Shop> selectShop(PagingCustomShop pagingCustomShop) throws Exception {
        try {
            List<Shop>  shops = shopMapper.selectShop(pagingCustomShop);
            if(shops.isEmpty()) throw new Exception("查询到的商店列表为空");
            return shops;
        }catch (Exception e){
            if (!e.getMessage().contains("商店列表为空"))
                throw new Exception("参数商店列表出错，请检查参数");
            throw e;
        }
    }

    public int selectShopCount() throws Exception {
        try {
            return  shopMapper.selectShopCount();
        }catch (Exception e){
            throw new Exception("查询商店信息总数时出错");
        }
    }

    /*------------------------------------------积分明细表------------------------------------------------------------------*/
    public Score selectScoreByPrimaryKey(Integer scoreId) throws Exception {
        if (scoreId != null && scoreId != 0){
            Score score = scoreMapper.selectScoreByPrimaryKey(scoreId);
            except(score,"根据积分明细ID查询积分明细为空");
            return score;
        }
        return null;
    }

    @Transactional(rollbackFor =Exception.class )
    public void deleteScoreByPrimaryKey(Integer scoreId) throws Exception {
        if(scoreId != null && scoreId != 0){
            try {
                except(scoreMapper.deleteScoreByPrimaryKey(scoreId));
            }catch (Exception e){
                if (!e.getMessage().contains("操作无效"))
                    throw new Exception("删除积分明细时出错");
                throw e;
            }
        }
    }

    @Transactional(rollbackFor =Exception.class )
    public void deleteScoreByPrimaryKeyArray(Integer[] scoreIdArrary) throws Exception {
        if(scoreIdArrary==null||"".equals(scoreIdArrary))throw new Exception("没有scoreIdArrary数组信息，批量积分明细删除出错");
        try {
            except(scoreMapper.deleteScoreByPrimaryKeyArray(scoreIdArrary));
        }catch (Exception e){
            if (!e.getMessage().contains("操作无效"))
                throw new Exception("批量删除积分明细时出错");
            throw e;
        }
    }

    @Transactional(rollbackFor =Exception.class )
    public void insertScoreSelective(Score score) throws Exception {
        try {
            List<Score> scores = scoreMapper.selectScoreRecentChange(score);
            if(!scores.isEmpty()){
            Score scoreNow = scores.get(0);
            score.setScoreCurrent(scoreNow.getScoreCurrent()+score.getCoreDetail());
            if(score.getCoreDetail()>0) score.setScoreTatol(scoreNow.getScoreTatol()+score.getCoreDetail());
            else score.setScoreTatol((scoreNow.getScoreTatol()));
                scoreMapper.insertScoreSelective(score);
            }else {
                score.setScoreCurrent(score.getCoreDetail());
                score.setScoreTatol(score.getCoreDetail());
                scoreMapper.insertScoreSelective(score);
            }
        }catch (Exception e){
            throw new Exception("添加积分明细时出错");
        }
    }

    @Transactional(rollbackFor =Exception.class )
    public void updateScoreByPrimaryKeySelective(Score score) throws Exception {
        try {
            except(scoreMapper.updateScoreByPrimaryKeySelective(score));
        }catch (Exception e){
            if (!e.getMessage().contains("操作无效"))
                throw new Exception("修改积分明细时出错");
            throw e;
        }
    }

    public List<Score> selectScore(PagingCustomScore pagingCustomScore) throws Exception {
        try {
            List<Score>  scores = scoreMapper.selectScore(pagingCustomScore);
            if(scores.isEmpty()) throw new Exception("查询到的积分明细列表为空");
            return scores;
        }catch (Exception e){
            if (!e.getMessage().contains("积分明细列表为空"))
                throw new Exception("参数查询积分明细列表出错，请检查参数");
            throw e;
        }
    }

    public int selectScoreCount() throws Exception {
        try {
            return  scoreMapper.selectScoreCount();
        }catch (Exception e){
            throw new Exception("查询积分明细总数时出错");
        }
    }

}
