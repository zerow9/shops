package com.coding.mapper;
import com.coding.Iservice.IAdminService;
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
}
