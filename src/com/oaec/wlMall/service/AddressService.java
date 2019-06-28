package com.oaec.wlMall.service;

import java.util.List;
import java.util.Map;

public interface AddressService {
    List<Map<String,Object>> queryByUser_id(Integer user_id);
    boolean updateIsDefault(Integer user_id,Integer add_id);
    boolean updateIsDefault2(Integer user_id,Integer action);
    boolean deleteAddress(Integer user_id,Integer add_id);
    boolean addAddress(String recipient , Integer re_number , String address ,Integer user_id ,Integer isdedault);
    boolean updateAddress(String recipient , Integer re_number , String address ,Integer add_id);

}
