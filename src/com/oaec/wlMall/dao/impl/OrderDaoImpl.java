package com.oaec.wlMall.dao.impl;

import com.oaec.wlMall.dao.OrdersDao;
import com.oaec.wlMall.util.CommonDao;

import java.util.List;
import java.util.Map;

public class OrderDaoImpl extends CommonDao implements OrdersDao {
    @Override
    public List<Map<String, Object>> queryByUser_id(Integer user_id) {
        String sql="SELECT * FROM ORDERS WHERE USER_ID=?";
        return query4MapList(sql,user_id);
    }

    @Override
    public List<Map<String, Object>> queryCommodityByOrder_id(Integer order_id) {
        String sql="SELECT order_details.dbid, order_details.comm_id,order_details.\"COMMENT\",order_details.img_url,order_details.name,order_details.quantity,order_details.price ,order_details.status1 FROM ORDERS,order_details  WHERE  ORDERS.ORDER_ID=order_details.order_id AND ORDERS.ORDER_ID=? AND order_details.ISDELE=0";
        return query4MapList(sql,order_id);
    }

    @Override
    public Double getTotalPrice(Integer order_id) {
        String sql="SELECT SUM(order_details.quantity*order_details.price) totalPrice FROM ORDERS,order_details WHERE  ORDERS.ORDER_ID=order_details.order_id AND ORDERS.ORDER_ID=?";
        Map<String, Object> map = query4Map(sql, order_id);
        System.out.println(map);
        return Double.parseDouble(map.get("TOTALPRICE").toString());
    }

    @Override
    public int updateStatus(Integer dbid) {
        String sql = "UPDATE order_details SET STATUS1 =1 where dbid=?";
        return  executeUpdate(sql,dbid);
    }

    @Override
    public int updateIsDELETE(Integer dbid) {
        String sql="UPDATE order_details SET ISDELE =1 where dbid=?";
        return executeUpdate(sql,dbid);
    }

    @Override
    public int doInsetOrder(Integer user_id, Integer add_id) {
        String sql="INSERT  INTO  ORDERS values (?,?,?,0,sysdate)";
        int orderId = getOrderId();
        int i = executeUpdate(sql,orderId , user_id, add_id);
        if (i == 1){
            return  orderId;
      }
        return 0;

    }

    @Override
    public int doInserOrder_detail(Map<String, Object> param) {
        String sql ="INSERT INTO order_details VALUES (seq_order_detail.nextval,?,?,?,?,?,?,0,0,null)";
        return executeUpdate(sql,param.get("ORDER_ID"),param.get("COMM_ID"),param.get("COMM_NAME"),param.get("P_ADDRESS"),param.get("PRICE"),param.get("QUANTITY"));
    }

    @Override
    public int doInsetComment(String comment, Integer dbid) {
        String sql="UPDATE order_details SET \"COMMENT\"= ? where dbid = ?";
        return executeUpdate(sql,comment,dbid);
    }

    @Override
    public Map<String,Object> queryComment( Integer dbid) {
        String sql = "SELECT \"COMMENT\",comm_id FROM order_details WHERE dbid = ?";
        return query4Map(sql,dbid);
    }

    private  int getOrderId(){
        String sql="SELECT seq_orders.nextval order_id FROM dual";
        Map<String, Object> map = query4Map(sql);
        return Integer.parseInt(map.get("ORDER_ID").toString());
    }
}
