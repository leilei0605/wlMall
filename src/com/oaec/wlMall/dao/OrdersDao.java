package com.oaec.wlMall.dao;

import java.util.List;
import java.util.Map;

public interface OrdersDao {
    List<Map<String,Object>> queryByUser_id(Integer user_id);
    List<Map<String,Object>> queryCommodityByOrder_id(Integer order_id);
    Double getTotalPrice(Integer order_id);
    int updateStatus(Integer dbid);
    int updateIsDELETE(Integer dbid);
    int doInsetOrder(Integer user_id,Integer add_id);
    int doInserOrder_detail(Map<String,Object> param);
    int doInsetComment(String comment,Integer dbid);
    Map<String,Object> queryComment(Integer dbid);
}
