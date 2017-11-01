package com.coding.mapper;
import com.coding.Iservice.IAdminService;
import com.coding.pojo.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext_*.xml","classpath:springmvc/springmvc.xml"})
public class UserMapperTest {
    @Autowired
    private IAdminService adminService;
    /*------------------------------------------用户表------------------------------------------------------------------*/
    @Test
    public void selectUserAll() throws Exception {
        System.out.println(adminService.selectUserAll());
    }
    @Test
    public void selectUserByPrimaryKey() throws Exception {
        System.out.println(adminService.selectUserByPrimaryKey("1"));
    }
    @Test
    public void insertUser() throws Exception {
        User user = new User();
        user.setUserUuid("3");
        user.setUserPhone("123");
        user.setUserPassword("123");
        adminService.insertUser(user);
    }
    @Test
    public void updateUserByPrimaryKey() throws Exception {
        User user = new User();
        user.setUserUuid("3");
        user.setUserPhone("123456");
        user.setUserPassword("123");
        adminService.updateUserByPrimaryKey(user);
    }
    @Test
    public void deleteUserByPrimaryKey() throws Exception {
        adminService.deleteUserByPrimaryKey("3");
    }
    /*------------------------------------------收获地址表------------------------------------------------------------------*/
    @Test
    public void selectAddressAll() throws Exception {
        System.out.println(adminService.selectAddressAll());
    }
    @Test
    public void selectAddressByPrimaryKey() throws Exception {
        System.out.println(adminService.selectAddressByPrimaryKey(1));
    }
    @Test
    public void selectAddressByUserID() throws Exception {
        System.out.println(adminService.selectAddressByUserID("4"));
    }
    @Test
    public void insertAddress() throws Exception {
        Address address = new Address();
        address.setUserUuid("5");
        adminService.insertAddress(address);
    }
    @Test
    public void updateAddressByPrimaryKey() throws Exception {
        Address address = new Address();
        address.setUserUuid("5");
        address.setAddressId(5);
        address.setAddresseePhone("5");
        adminService.updateAddressByPrimaryKey(address);
    }
    @Test
    public void deleteAddressByPrimaryKey() throws Exception {
        adminService.deleteAddressByPrimaryKey(5);
    }
     /*------------------------------------------分组表------------------------------------------------------------------*/
     @Test
     public void selectGroupsAll() throws Exception {
         System.out.println(adminService.selectGroupsAll());
     }
    @Test
    public void selectGroupsByPrimaryKey() throws Exception {
        System.out.println(adminService.selectGroupsByPrimaryKey(1));
    }
    @Test
    public void insertGroups() throws Exception {
        Groups groups = new Groups();
        groups.setGroupName("4");
        groups.setGroupJurisdiction("4");
        adminService.insertGroups(groups);
    }
    @Test
    public void updateGroupsByPrimaryKey() throws Exception {
        Groups groups = new Groups();
        groups.setGroupName("5");
        groups.setGroupId(6);
        groups.setGroupJurisdiction("4");
        adminService.updateGroupsByPrimaryKey(groups);
    }
    @Test
    public void deleteGroupsByPrimaryKey() throws Exception {
        adminService.deleteGroupsByPrimaryKey(6);
    }
     /*------------------------------------------管理员表------------------------------------------------------------------*/
     @Test
     public void selectAdminAll() throws Exception {
         System.out.println(adminService.selectAdminAll());
     }
    @Test
    public void selectAdminByPrimaryKey() throws Exception {
        System.out.println(adminService.selectAdminByPrimaryKey(1));
    }
    @Test
    public void insertAdmin() throws Exception {
        Admin admin = new Admin();
        admin.setAdminPhone("4");
        adminService.insertAdmin(admin);
    }
    @Test
    public void updateAdminByPrimaryKey() throws Exception {
        Admin admin = new Admin();
        admin.setAdminPhone("4");
        admin.setAdminId(3);
        admin.setAdminEmail("123");
        adminService.updateAdminByPrimaryKey(admin);
    }
    @Test
    public void deleteAdminByPrimaryKey() throws Exception {
        adminService.deleteAdminByPrimaryKey(3);
    }
     /*------------------------------------------商品表------------------------------------------------------------------*/
     @Test
     public void selectItemAll() throws Exception {
         System.out.println(adminService.selectItemAll());
     }
    @Test
    public void selectItemByPrimaryKey() throws Exception {
        System.out.println(adminService.selectItemByPrimaryKey(1));
    }
    @Test
    public void insertItem() throws Exception {
        Item item = new Item();
        item.setItemName("123");
        adminService.insertItem(item);
    }
    @Test
    public void updateItemByPrimaryKey() throws Exception {
        Item item = new Item();
        item.setItemName("123");
        item.setItemId(6);
        item.setItemPrice((double) 123);
        adminService.updateItemByPrimaryKey(item);
    }
    @Test
    public void deleteItemByPrimaryKey() throws Exception {
        adminService.deleteItemByPrimaryKey(6);
    }
    /*------------------------------------------商品类别表------------------------------------------------------------------*/
    @Test
    public void selectItemTypeAll() throws Exception {
        System.out.println(adminService.selectItemTypeAll());
    }
    @Test
    public void selectItemTypeByPrimaryKey() throws Exception {
        System.out.println(adminService.selectItemTypeByPrimaryKey(1));
    }
    @Test
    public void insertItemType() throws Exception {
        ItemType itemType = new ItemType();
        itemType.setTypeName("123");
        itemType.setFatherTypeId(3);
        adminService.insertItemType(itemType);
    }
    @Test
    public void updateItemTypeByPrimaryKey() throws Exception {
        ItemType itemType = new ItemType();
        itemType.setTypeName("3");
        itemType.setFatherTypeId(3);
        itemType.setTypeId(3);
        adminService.updateItemTypeByPrimaryKey(itemType);
    }
    @Test
    public void deleteItemTypeByPrimaryKey() throws Exception {
        adminService.deleteItemTypeByPrimaryKey(3);
    }
     /*------------------------------------------库存表------------------------------------------------------------------*/
     @Test
     public void selectRepertoryAll() throws Exception {
         System.out.println(adminService.selectRepertoryAll());
     }
    @Test
    public void selectRepertoryByPrimaryKey() throws Exception {
        System.out.println(adminService.selectRepertoryByPrimaryKey(2));
    }
    @Test
    public void insertRepertory() throws Exception {
         Repertory repertory = new Repertory();
         repertory.setItemId(2);
        adminService.insertRepertory(repertory);
    }
    @Test
    public void updateRepertoryByPrimaryKey() throws Exception {
        Repertory repertory = new Repertory();
        repertory.setItemId(3);
        repertory.setRepertoryId(10);
        adminService.updateRepertoryByPrimaryKey(repertory);
    }
    @Test
    public void deleteRepertoryByPrimaryKey() throws Exception {
        adminService.deleteRepertoryByPrimaryKey(10);
    }
      /*------------------------------------------厂家信息表------------------------------------------------------------------*/
      @Test
      public void selectVenderAll() throws Exception {
          System.out.println(adminService.selectVenderAll());
      }
    @Test
    public void selectVenderByPrimaryKey() throws Exception {
        System.out.println(adminService.selectVenderByPrimaryKey(10));
    }
    @Test
    public void insertVender() throws Exception {
          Vender vender =new Vender();
          vender.setVenderName("123");
        adminService.insertVender(vender);
    }
    @Test
    public void updateVenderByPrimaryKey() throws Exception {
        Vender vender =new Vender();
        vender.setVenderName("1234");
        vender.setVenderId(11);
        adminService.updateVenderByPrimaryKey(vender);
    }
    @Test
    public void deleteVenderByPrimaryKey() throws Exception {
        adminService.deleteVenderByPrimaryKey(11);
    }
}
