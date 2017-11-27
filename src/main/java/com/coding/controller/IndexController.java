package com.coding.controller;

import com.coding.Iservice.IindexItemService;
import com.coding.Lucene.SearchField;
import com.coding.comomInterface.DateToString;
import com.coding.json.MyJsonConfig;
import com.coding.paging.PagingCustomItem;
import com.coding.pojo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public boolean updateReconstructorIndex() throws Exception {
        indexItemService.updateReconstructorIndex();
        return true;
    }

    /**
     * 删除全部索引
     * @return 成功与否
     * @throws Exception index异常
     */
    @RequestMapping("deleteIndexAll")
    public boolean deleteIndexAll() throws Exception {
        indexItemService.deleteIndexAll();
        return true;
    }

    @RequestMapping("index")
    public String index(){
        return "indexrd/indexList";
    }

    @RequestMapping("/getIndexData")
    @ResponseBody
    public String getIndexData(Integer page, Integer limit) throws Exception {
        SearchField searchField = new SearchField();
        searchField.setIndexNumber((page - 1) * limit);
        searchField.setPageNumber(limit);
        PagingCustomItem pagingCustomItem = new PagingCustomItem();
        pagingCustomItem.setIndexNumber((page - 1) * limit);
        pagingCustomItem.setPageNumber(limit);
        if ((page == 1 && counts == null) || counts == null)
            counts = indexItemService.getDocCount(null);
        List<Item> items = indexItemService.findIndexAll(searchField);
        for (Item item : items)
            item.setDateToString(DateToString.date(item.getMakeDate()));
        MyJsonConfig myJsonConfig = new MyJsonConfig();
        System.out.println(items);
        return myJsonConfig.start(items, counts);
    }

}
