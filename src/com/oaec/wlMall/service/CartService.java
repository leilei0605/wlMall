package com.oaec.wlMall.service;

import java.util.List;
import java.util.Map;

public interface CartService {
    List<Map<String,Object>> getCartCommodity(Integer user_id);
    boolean addCart(Integer quantity,Integer user_id,Integer comm_id);
    boolean deleteCart(Integer comm_id,Integer user_id);
    boolean updateQuantity(String action ,Integer user_id,Integer comm_id);
    Map<String,Object> getTotal(Integer user_id,String[] comm_ids);
    List<Map<String,Object>> getCommodities4Checkout(Integer user_id,String[] comm_ids);

}
