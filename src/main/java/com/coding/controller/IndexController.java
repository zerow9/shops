package com.coding.controller;

import com.coding.Iservice.IindexItemService;
import com.coding.Lucene.SearchField;
import com.coding.comomInterface.DateToString;
import com.coding.comomInterface.JavaGet;
import com.coding.json.MyJsonConfig;
import com.coding.paging.PagingCustomItem;
import com.coding.pojo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
    @Qualifier("indexService")
    private IindexItemService indexItemService;
    private Integer counts;

    /**
     * 索引重构（会自行先删除全部索引）
     * @return 成功与否
     * @throws Exception index异常
     */
    @RequestMapping("updateReconstructorIndex")
    public String updateReconstructorIndex() throws Exception {
        indexItemService.updateReconstructorIndex();
        return "redirect:/index/getIndexData.action";
    }

    /**
     * 删除全部索引
     * @return 成功与否
     * @throws Exception index异常
     */
    @RequestMapping("deleteIndexAll")
    public String deleteIndexAll() throws Exception {
        indexItemService.deleteIndexAll();
        return "redirect:/index/getIndexData.action";
    }

    /**
     * 页面跳转
     * @return 相关页面
     */
    @RequestMapping("index")
    public String index(){
        return "indexrd/indexList";
    }

    /**
     * 得到索引数据
     * @param page 当前页
     * @param limit 每页显示的数量
     * @return 索引数据
     */
    @RequestMapping("/getIndexData")
    @ResponseBody
    public String getIndexData(Integer page, Integer limit, HttpServletRequest request) throws Exception {
        SearchField searchField = new SearchField();
        searchField.setPageNumber(limit);
        searchField.setIndexNumber((page - 1) * limit);
        if (page!=null&&(page == 1 && counts == null) || counts == null)
            counts = indexItemService.getDocCount(null);
        List<Item> items = indexItemService.findIndexAll(searchField);
        for (Item item : items)
            item.setDateToString(DateToString.date(item.getMakeDate()));
        MyJsonConfig myJsonConfig = new MyJsonConfig();
        System.out.println(items);
        return myJsonConfig.start(items, counts);
    }

    /**
     * 删除索引
     * @param itemId 商品ID
     * @return 跳转得到索引数据
     */
    @RequestMapping("deleteIndex")
    public String  deleteIndex(Integer itemId)throws Exception{
        indexItemService.deleteIndex(itemId,false);
        return "redirect:/index/getIndexData.action";
    }

    @RequestMapping("deleteIndexByIdArray")
    public String deleteIndexByIdArray(String arrayString) throws Exception{
        for (String itemId:arrayString.split(",")) {
            indexItemService.deleteIndex(Integer.parseInt(itemId),false);
        }
        return "redirect:/index/getIndexData.action";
    }
}
