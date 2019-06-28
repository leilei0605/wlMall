package com.oaec.wlMall.dao;

import java.util.List;
import java.util.Map;

public interface CartDao {
   List<Map<String,Object>>  queryByUserId(int user_id);
   //数据层方法如果需要多个参数，一般使用包装类型作为方法的参数
   int addCart(Map<String,Object> param);
   Map<String,Object> queryByCommAndUserId(Integer user_id,Integer comm_id);
   int addQuantity(Map<String,Object> param);
   int deleteCart(Integer comm_id,Integer user_id);
   int addQuantity1(Integer user_id ,Integer comm_id);
   int subQuantity(Integer user_id,Integer comm_id);
   Map<String,Object> queryTotal(Integer user_id ,String[] comm_ids);
   List<Map<String,Object>> queryCommodity4Checkout(Integer user_id ,String[] comm_ids);
}
