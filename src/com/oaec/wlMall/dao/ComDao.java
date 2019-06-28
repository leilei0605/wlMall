package com.oaec.wlMall.dao;

import com.oaec.wlMall.entity.Commodity;
import com.oaec.wlMall.entity.Type;

import java.util.List;
import java.util.Map;

public interface ComDao {
    //全部商品
    List<Map<String,Object>> queryAll( int page);
    //名字查
    List<Map<String,Object>> queryLike(String name);
    //种类查
    List<Map<String,Object>> queryTid(int tid );
    //按照商品名查
    List<Map<String,Object>> queryByBid(Integer b_id);
    //按照商品编号查
    Map<String,Object> queryByCid(Integer comm_id);
    //增加货品库存
    int addInventory(Integer quantity ,Integer comm_id);
    //减少货品库存和增加销量
    int subInventoryAndAddSales(Integer quantity ,Integer comm_id);
    //插入评论
    int doInsertComment(String comment,Integer comm_id);



}
