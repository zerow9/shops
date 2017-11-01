package com.coding.Iservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext_*.xml","classpath:springmvc/springmvc.xml"})
public class IUserServiceTest {
    @Autowired
    private IUserService  userService;
    @Test
    public void selectItemTypeAll() throws Exception {
        userService.selectUserByPrimaryKey("1");
        System.out.println("ok");
    }

    @Test
    public void selectItemByPrimaryKey() throws Exception {
    }

    @Test
    public void selectItemAll() throws Exception {
    }

}