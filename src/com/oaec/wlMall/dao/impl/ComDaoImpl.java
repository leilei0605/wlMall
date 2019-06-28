package com.oaec.wlMall.dao.impl;

import com.oaec.wlMall.dao.ComDao;
import com.oaec.wlMall.entity.Commodity;
import com.oaec.wlMall.entity.Commodity;
import com.oaec.wlMall.util.CommonDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class ComDaoImpl extends CommonDao implements ComDao{
 final int PageSize=6;


    @Override
    public List<Map<String,Object>> queryAll( int page) {
        String sql = "SELECT * FROM (SELECT ROWNUM rn,t1.*  FROM (SELECT * FROM COMMODITY ORDER BY price DESC ) t1) t2 WHERE t2.rn> ? AND t2.rn<= ?";
        return query4MapList(sql,(page-1)*PageSize, page*PageSize);
    }

    @Override
    public List<Map<String,Object>> queryLike(String name) {
        System.out.println("name = [" + name + "]");
//        String sql ="SELECT * FROM COMMODITY WHERE UPPER(\"comm_name\") LIKE UPPER(?)";
        String sql = "SELECT * FROM COMMODITY WHERE comm_name LIKE ? AND idele=0";
        return  query4MapList(sql,"%"+name+"%");
    }

    @Override
    public List<Map<String, Object>> queryTid(int tid) {
        String sql="SELECT*FROM COMMODITY WHERE t_id=?";
        return query4MapList(sql,tid);
    }

    @Override
    public List<Map<String, Object>> queryByBid(Integer b_id) {

        String sql="SELECT * FROM COMMODITY WHERE b_id = ?";
        return query4MapList(sql,b_id);
    }

    @Override
    public Map<String, Object> queryByCid(Integer comm_id) {
        String sql="SELECT * FROM COMMODITY WHERE comm_id = ?";
        return query4Map(sql,comm_id);
    }

    @Override
    public int addInventory(Integer quantity, Integer comm_id) {
        String sql= "UPDATE COMMODITY SET inventory=inventory+? where comm_id=?";
        return executeUpdate(sql,quantity,comm_id);
    }

    @Override
    public int subInventoryAndAddSales(Integer quantity, Integer comm_id) {
        String sql="UPDATE COMMODITY SET inventory=inventory-?,sales=sales+? where comm_id=?";
        return executeUpdate(sql,quantity,quantity,comm_id);
    }

    @Override
    public int doInsertComment(String comment ,Integer comm_id) {
        String sql = "update COMMODITY set  \"COMMENT\"=concat(\"COMMENT\",?) where comm_id=?";
        return executeUpdate(sql,comment,comm_id);
    }
}
