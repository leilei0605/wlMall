package com.oaec.wlMall.dao.impl;

import com.oaec.wlMall.dao.User2Dao;
import com.oaec.wlMall.entity.User2;
import com.oaec.wlMall.util.CommonDao;

import java.util.Map;

public class User2DaoImpl extends CommonDao implements User2Dao {

    @Override
    public Map login(String name, String password) {
    String sql="SELECT * FROM USER2 WHERE user_name=? AND password=?";
    return query4Map(sql,name,password);
    }

    @Override
    public Map<String, Object> login2(Integer phone, String password) {
        String sql="SELECT * FROM USER2 WHERE PHONE_NUMBER = ? AND password = ?";
        return query4Map(sql,phone,password);
    }

    @Override
    public Map<String,Object> calibrate(String name) {
        String sql = "SELECT * FROM USER2 WHERE user_name = ? ";
        return query4Map(sql,name);
    }



    @Override
    public Map<String, Object> calibrateByPhone(String phone_number) {
        String sql="SELECT* FROM USER2 WHERE phone_number=?";
        return query4Map(sql,phone_number);
    }

    @Override
    public boolean register(String name, String password,String payword, String phone_number) {
        String sql="INSERT INTO USER2 VALUES(seq_users.nextval,?,?,?,?,500,0,0,5)";
        int i = executeUpdate(sql, name, password, payword,phone_number);
        return i==1;
    }

    @Override
    public int addBalance(Double money,Integer user_id) {
        String sql="UPDATE USER2 SET balance=balance+? where user_id=? ";
        return executeUpdate(sql,money,user_id);
    }

    @Override
    public int subBalance(Double money, Integer user_id) {
        String sql="UPDATE USER2 SET balance=balance-?, ACHI = ACHI+5 where user_id=?";
        return executeUpdate(sql,money,user_id);
    }

    @Override
    public int updateUser_name( String user_name,Integer user_id) {
        String sql="UPDATE USER2 SET user_name=? where user_id=?";
        return executeUpdate(sql,user_name,user_id);
    }

    @Override
    public Map<String, Object> queryByUserId(Integer userId) {
        String sql = "SELECT* FROM USER2 WHERE user_id = ?";
        Map<String, Object> map = query4Map(sql, userId);
        return map;
    }

    @Override
    public int updatePassWord(String password,Integer user_id) {
        String sql="UPDATE USER2 SET password=? where user_id=?";
        return executeUpdate(sql,password,user_id);
    }



    @Override
    public int updatePayWord(String payword, Integer user_id) {
        String sql="update USER2 set payword = ? where user_id = ?";
        return executeUpdate(sql,payword,user_id);
    }

    @Override
    public int pay( Double total_price,Integer user_id) {
        String sql="UPDATE USER2 SET balance=balance-? where user_id=?";
        return executeUpdate(sql,total_price,user_id);
    }

    @Override
    public Map<String,Object> queryAchieve(Integer user_id) {
        String sql="SELECT achi,payword ,balance from USER2 where user_id=?";
        return query4Map(sql,user_id);
    }


}
