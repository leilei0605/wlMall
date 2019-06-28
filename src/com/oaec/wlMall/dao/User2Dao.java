package com.oaec.wlMall.dao;

import com.oaec.wlMall.entity.User2;

import java.util.Map;

public interface User2Dao {
    public Map<String,Object> login(String name, String password);
    public Map<String,Object> login2(Integer phone, String password);
    public Map<String,Object> calibrate(String name);
    public Map<String,Object> calibrateByPhone(String phone_number);
    public boolean register(String name,String password,String payword,String phone_number);
    public int addBalance(Double money,Integer user_id);
    public int subBalance(Double money,Integer user_id);
    public int updateUser_name(String user_name,Integer user_id);
    Map<String, Object> queryByUserId(Integer userId);
    int updatePassWord(String password,Integer user_id);
    int updatePayWord(String payword, Integer user_id );
    int pay(Double total_price,Integer user_id);
    Map<String,Object> queryAchieve(Integer user_id);


}
