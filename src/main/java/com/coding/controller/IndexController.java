package com.coding.controller;

import com.coding.Iservice.IindexItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("index")
public class IndexController {

    @Autowired
    @Qualifier("indexService")
    private IindexItemService indexItemService;

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



}
