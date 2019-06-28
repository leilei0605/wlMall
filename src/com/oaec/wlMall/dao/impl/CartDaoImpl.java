package com.oaec.wlMall.dao.impl;

import com.oaec.wlMall.dao.CartDao;
import com.oaec.wlMall.util.CommonDao;

import java.util.List;
import java.util.Map;

public class CartDaoImpl extends CommonDao implements CartDao {

    @Override
    public List<Map<String, Object>> queryByUserId(int user_id) {
        String sql="SELECT c.comm_id,c.p_address,c.comm_name,c.price,a.QUANTITY FROM COMMODITY c,CART a WHERE c.comm_id= a.COMM_ID  AND  USER_ID=? AND ISDELE =0";
        return query4MapList(sql,user_id);
    }

    @Override
    public int addCart(Map<String,Object> param) {
        String sql="INSERT INTO CART VALUES (seq_cart.nextval ,?,?,?,0)";
        return executeUpdate(sql,param.get("user_id"),param.get("comm_id"),param.get("quantity"));
    //seq_cart.nextval
    }

    @Override
    public Map<String, Object> queryByCommAndUserId(Integer user_id, Integer comm_id) {
       String sql="SELECT * FROM CART ,COMMODITY WHERE CART.comm_id=COMMODITY.comm_id AND USER_ID =?  AND CART.comm_id=? AND ISDELE =0";
        return query4Map(sql,user_id,comm_id);

    }

    @Override
    public int addQuantity(Map<String, Object> param) {
        String sql="UPDATE CART SET quantity=quantity+? WHERE USER_ID=? AND COMM_ID=? AND ISDELE=0";
        return executeUpdate(sql,param.get("quantity"),param.get("user_id"),param.get("comm_id"));
    }

    @Override
    public int deleteCart(Integer comm_id,Integer user_id) {
        String sql="UPDATE CART SET ISDELE =1 WHERE COMM_ID =? AND USER_ID=? AND ISDELE =0";
        return  executeUpdate(sql,comm_id,user_id);
    }

    @Override
    public int addQuantity1(Integer user_id, Integer comm_id) {
        String sql="UPDATE CART SET quantity=quantity+1 WHERE user_id=? AND comm_id=? AND ISDELE=0";
        return executeUpdate(sql,user_id,comm_id);
    }

    @Override
    public int subQuantity(Integer user_id, Integer comm_id) {
        String sql="update CART set quantity=quantity-1 where user_id=? and  comm_id=? AND quantity>0 AND ISDELE=0";
        return executeUpdate(sql,user_id,comm_id);
    }

    @Override
    public Map<String, Object> queryTotal(Integer user_id, String[] comm_ids) {
        StringBuilder sql= new StringBuilder("select sum(quantity) total_quantity ,sum(quantity*price) total_price from CART,COMMODITY where CART.comm_id=COMMODITY.comm_id AND  user_id=? and CART.isdele=0 and CART.comm_id IN ( ");
        Object[] param = new Object[comm_ids.length+1];
        param[0]=user_id;
        for (int i =0;i<comm_ids.length;i++) {
            sql.append("?,");
            param[i+1]=comm_ids[i];
        }
        sql.deleteCharAt(sql.length()-1);
        sql.append(")");
        return query4Map(sql.toString(),param);
    }

    @Override
    public List<Map<String, Object>> queryCommodity4Checkout(Integer user_id, String[] comm_ids) {
        StringBuilder sql= new StringBuilder("SELECT COMMODITY.comm_id,COMMODITY.p_address ,COMMODITY.comm_name,CART.quantity ,COMMODITY.price FROM CART,COMMODITY where CART.comm_id=COMMODITY.comm_id AND user_id=? AND isdele=0 AND CART.comm_id IN (");
        Object[] param = new Object[comm_ids.length+1];
        param[0]=user_id;
        for (int i =0;i<comm_ids.length;i++) {
            sql.append("?,");
            param[i+1]=comm_ids[i];
        }
        sql.deleteCharAt(sql.length()-1);
        sql.append(")");
        return query4MapList(sql.toString(),param);
    }
}
