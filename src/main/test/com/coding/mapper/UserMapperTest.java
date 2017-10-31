package com.coding.mapper;
import com.coding.Iservice.IAdminService;
import com.coding.pojo.User;
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
}
