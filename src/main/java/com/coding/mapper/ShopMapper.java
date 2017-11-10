package com.coding.mapper;

import com.coding.paging.PagingCustomShop;
import com.coding.pojo.Shop;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopMapper {
    /**
     * 根据主键ID查询商店信息
     * @param shopId
     * @return
     * @throws Exception
     */
    public Shop selectShopByPrimaryKey (Integer shopId)throws Exception;

    /**
     * 根据主键ID删除商店信息
     * @param shopId
     * @return
     * @throws Exception
     */
    public int deleteShopByPrimaryKey (Integer shopId)throws Exception;

    /**
     * 根据主键ID数组批量删除商店信息
     * @param shopIdArrary
     * @return
     * @throws Exception
     */
    public int deleteShopByPrimaryKeyArray (@Param("shopIdArrary") Integer[] shopIdArrary)throws Exception;

    /**
     * 按需插入商店信息
     * @param shop
     * @return
     * @throws Exception
     */
    public int insertShopSelective (Shop shop)throws Exception;

    /**
     * 按需修改商店信息
     * @param shop
     * @return
     * @throws Exception
     */
    public int updateShopByPrimaryKeySelective (Shop shop)throws Exception;

    /**
     * 商店表综合查询
     * 实现：所有Sshop属性.
     * @param pagingCustomShop
     * @return
     * @throws Exception
     */
    public List<Shop> selectShop (PagingCustomShop pagingCustomShop)throws Exception;

    /**
     * 商店综合查询
     * @return
     * @throws Exception
     */
    public int selectShopCount()throws Exception;

}