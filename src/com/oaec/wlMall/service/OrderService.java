package com.oaec.wlMall.service;

import java.util.List;
import java.util.Map;

public interface OrderService {
    List<Map<String,Object>> getOrders(Integer user_id);
    boolean returnOfGoods(Integer quantity ,Integer comm_id ,Double money,Integer user_id ,Integer dbid);
    boolean pay(Integer quantity ,Integer comm_id ,Double money ,Integer user_id);
    boolean deleteOrder(Integer dbid);
    boolean submit(Integer user_id,Integer add_id ,String[]comm_ids);
    boolean InsetComment(String comment,Integer dbid);
    Map<String,Object> queryComment(Integer dbid);
}
