package com.oaec.wlMall.dao.impl;

import com.oaec.wlMall.dao.AddDao;
import com.oaec.wlMall.util.CommonDao;

import java.util.List;
import java.util.Map;

public class AddDaoImpl extends CommonDao implements AddDao {
    @Override
    public Map<String, Object> queryByAdd_id(Integer add_id) {
       String sql="SELECT * FROM ADDRESS WHERE add_id = ?";
        return query4Map(sql,add_id);
    }

    @Override
    public List<Map<String, Object>> queryByUser_id(Integer user_id) {
        String sql="SELECT * FROM address WHERE user_id=? AND  isdele=0";
        return query4MapList(sql,user_id);
    }

    @Override
    public int addIsDefault(Integer user_id, Integer add_id) {
        String sql ="UPDATE ADDRESS SET isdefault = 1 WHERE user_id = ? AND add_id = ?";
        return executeUpdate(sql,user_id,add_id);
    }

    /*@Override
    public int subIsDefault(Integer user_id, Integer add_id) {
        String sql="UPDATE ADDRESS SET isdefault=0 WHERE user_id=? AND add_id=?";
        return executeUpdate(sql,user_id,add_id);
    }*/
    @Override
    public int subIsDefault(Integer user_id, Integer add_id) {
        String sql="UPDATE ADDRESS SET isdefault = 0 WHERE user_id = ? AND add_id != ?";
        return executeUpdate(sql,user_id,add_id);
    }

    @Override
    public int subIsDefault2(Integer user_id) {
        String sql="UPDATE ADDRESS SET isdefault = 0 WHERE user_id = ? ";

        return executeUpdate(sql,user_id);
    }

    @Override
    public int deleteAddress(Integer user_id, Integer add_id) {
        String sql="UPDATE ADDRESS SET ISDELE = 1 WHERE user_id =? AND  add_id=?";
        return executeUpdate(sql,user_id,add_id);
    }

    @Override
    public int addAddress(String recipient, Integer re_number, String address, Integer user_id, Integer isdedault) {
        String sql="INSERT INTO ADDRESS VALUES (SEQ_ADDRESS.nextval , ?,?,?,?,?,sysdate,0)";
        return executeUpdate(sql,recipient,re_number,address,user_id,isdedault);
    }

    @Override
    public int updateAddress(String recipient, Integer re_number, String address,  Integer add_id) {
        String sql="UPDATE ADDRESS SET recipient = ? ,re_number= ?  ,address= ? WHERE add_id = ?";
        return executeUpdate(sql,recipient,re_number,address,add_id);
    }
}
