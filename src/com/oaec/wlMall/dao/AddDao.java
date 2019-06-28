package com.oaec.wlMall.dao;

import java.util.List;
import java.util.Map;

public interface AddDao {
    Map<String,Object> queryByAdd_id(Integer add_id);
    List<Map<String,Object>> queryByUser_id(Integer user_id);
    int addIsDefault(Integer user_id ,Integer add_id);
    int subIsDefault(Integer user_id ,Integer add_id);
    int subIsDefault2(Integer user_id);
    int deleteAddress(Integer user_id,Integer add_id);
    int addAddress(String recipient , Integer re_number , String address ,Integer user_id ,Integer isdedault);
    int updateAddress(String recipient , Integer re_number , String address  ,Integer add_id);

}
