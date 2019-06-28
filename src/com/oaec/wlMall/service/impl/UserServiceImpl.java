package com.oaec.wlMall.service.impl;

import com.oaec.wlMall.dao.User2Dao;
import com.oaec.wlMall.dao.impl.User2DaoImpl;
import com.oaec.wlMall.service.UserService;

import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private User2Dao userdao=new User2DaoImpl();

    @Override
    public Map<String, Object> login(String phone ,String username, String password) {
        Map<String,Object>map = new HashMap<>();
        Map<String, Object> map1 = userdao.calibrate(username);

        if(map1==null){
            map.put("error", "用户名不存在");
        }else{
            if(map1.get("PASSWORD").equals(password)){
                map.put("user", map1);
            }else{
                map.put("error", "密码错误");
            }
        }
        return map;
    }

    @Override
    public Map<String, Object> login2(String phone, String password) {
        Map<String,Object>map = new HashMap<>();
        Map<String, Object> map1 = userdao.calibrateByPhone(phone);
        System.out.println(map1);
        if(map1==null){
            map.put("error", "手机号不存在");
        }else{
            if(map1.get("PASSWORD").equals(password)){
                map.put("user", map1);
            }else{
                map.put("error", "密码错误");
            }
        }
        return map;

    }


    @Override
    public Map<String, Object> register(String name, String password,String payword, String phone_number) {
        Map<String, Object> map =new HashMap<>();
        Map<String, Object> map1 = userdao.calibrate(name);
        Map<String, Object> map2 = userdao.calibrateByPhone(phone_number);
        if (map1!=null){
            map= new HashMap<>();
            map.put("error","用户名已被占用注册失败");

        }
        else if (map2!=null){
            map= new HashMap<>();
            map.put("error","手机号码已注册请更换手机号码");
        }else {
            map= new HashMap<>();
            boolean register = userdao.register(name, password,password, phone_number);
            map.put("success","注册成功");

        }
        return map;

    }

    @Override
    public Double addBalance(Double money, Integer user_id) {
        int i = userdao.addBalance(money, user_id);
        Map<String, Object> map = userdao.queryByUserId(user_id);
        return Double.parseDouble(map.get("BALANCE").toString());
    }

    @Override
    public Double subBalance(Double money, Integer user_id) {
        int i = userdao.subBalance(money, user_id);
        Map<String, Object> map = userdao.queryByUserId(user_id);
        return Double.parseDouble(map.get("BALANCE").toString());
    }

    @Override
    public boolean updateUser_name(String user_name, Integer user_id) {
        Map<String, Object> name= userdao.calibrate(user_name);
        int i =0;
        if (name==null){
             i = userdao.updateUser_name(user_name, user_id);
        }else {
            i=2;
        }

        return i==1;
    }

    @Override
    public boolean updatePassWord(String password, Integer user_id) {
        int i= userdao.updatePassWord(password,user_id);
        return i==1;
    }

    @Override
    public boolean updatePayWord(String payword, Integer user_id) {
        int i = userdao.updatePayWord(payword, user_id);
        return i==1;
    }

    @Override
    public boolean pay(Double total_price, Integer user_id) {
        int pay = userdao.pay(total_price, user_id);
        return pay==1;
    }

    @Override
    public Map<String, Object> queryAchieve(Integer user_id) {
        Map<String, Object> map = userdao.queryAchieve(user_id);
        return map;
    }
}
