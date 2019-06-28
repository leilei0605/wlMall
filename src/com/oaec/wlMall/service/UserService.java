package com.oaec.wlMall.service;

import java.util.Map;

public interface UserService {
    public Map<String,Object> login(String phone,String username, String password);
    public Map<String,Object> login2(String phone, String password);
    public Map<String,Object> register(String name, String password,String payword, String phone_number);
    public Double addBalance(Double money,Integer user_id);
    public Double subBalance(Double money,Integer user_id);
    public boolean updateUser_name(String user_name,Integer user_id);
    public boolean updatePassWord(String password,Integer user_id);
    public boolean updatePayWord(String payword,Integer user_id);
    public boolean pay(Double total_price,Integer user_id);
    public Map<String,Object> queryAchieve(Integer user_id);



}
