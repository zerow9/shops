package com.coding.controller;

import com.coding.Iservice.IAdminService;
import com.coding.json.MyJsonConfig;
import com.coding.paging.PagingCustomLog;
import com.coding.paging.PagingCustomShop;
import com.coding.pojo.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("shop")
public class ShopController {

    @Autowired
    @Qualifier("adminService")
    private IAdminService adminService;

    private Integer counts=null;

    /**
     *  页面跳转
     * @return listShop 列表
     */
    @RequestMapping("forwordShop")
    public String  forwordShop(){
        return "shops/listShop";
    }

    /**
     * 获取 JSON 字符串
     * @param page 页面大小
     * @param limit 显示条数
     * @return json字符串
     * @throws Exception
     */
    @RequestMapping("getShop")
    @ResponseBody
    public String getShopInformation(Integer page, Integer limit) throws Exception {
        PagingCustomShop pagingCustomShop=new PagingCustomShop();
        pagingCustomShop.setIndexNumber((page-1)*limit);
        pagingCustomShop.setPageNumber(limit);
        if (counts==null)
            counts=adminService.selectShopCount();
        List<Shop> shops=adminService.selectShop(pagingCustomShop);
        MyJsonConfig<Shop> json=new MyJsonConfig();
        return json.start(shops,counts);
    }

    /**
     *  删除商店
     * @param shopId 商店编号
     * @return 返回结果
     * @throws Exception
     */
    @RequestMapping("deleteShopByPrimaryKey")
    public boolean deleteShopByPrimaryKey(Integer shopId) throws Exception {
        adminService.deleteShopByPrimaryKey(shopId);
        counts--;
        return true;
    }

    /**
     * 批量删除商店
     * @param arrayString
     * @return
     * @throws Exception
     */
    @RequestMapping("deleteVenderByIdArray")
    public boolean deleteVenderByIdArray(String arrayString) throws Exception {
        List<Integer> list = new ArrayList<>();
        for (String id : arrayString.split(","))
            list.add(Integer.parseInt(id));
        adminService.deleteShopByPrimaryKeyArray(list.toArray(new Integer[list.size()]));
        counts-= list.size();
        return true;
    }

    /**
     *  添加商店
     * @param shop 商店实体
     * @return
     * @throws Exception
     */
    @RequestMapping("insertShop")
    @ResponseBody
    public Boolean insertStop(Shop shop) throws Exception {
        adminService.insertShopSelective(shop);
        counts++;
        return true;
    }

    /**
     *  跳转到添加商店页面
     * @return
     */
    @RequestMapping("addShops")
    public String addShop(){
        return "shops/addShop";
    }

    /**
     * 跳转到修改商店的页面
     * @param shopId shop编号
     * @param model 返回的数据载体
     * @return 修改商店的页面
     * @throws Exception
     */
    @RequestMapping("updateShop")
    public String updateShop(String shopId, Model model) throws Exception {
        Shop shop=adminService.selectShopByPrimaryKey(Integer.valueOf(shopId));
        model.addAttribute("shop",shop);
        return "shops/editShop";
    }

    /**
     *  修改商店
     * @param shop 商店实体
     * @return  返回结果
     * @throws Exception
     */
    @RequestMapping("updateShopById")
    @ResponseBody
    public boolean updateShopById(Shop shop) throws Exception {
        adminService.updateShopByPrimaryKeySelective(shop);
        return true;
    }

}
