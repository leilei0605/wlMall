package com.oaec.wlMall.service.impl;

import com.oaec.wlMall.dao.AddDao;
import com.oaec.wlMall.dao.User2Dao;
import com.oaec.wlMall.dao.impl.AddDaoImpl;
import com.oaec.wlMall.dao.impl.User2DaoImpl;
import com.oaec.wlMall.service.AddressService;

import java.util.List;
import java.util.Map;

public class AddressServiceImpl implements AddressService {
    private AddDao addDao = new AddDaoImpl();
//    private User2Dao userdao=new User2DaoImpl();
    @Override
    public List<Map<String, Object>> queryByUser_id(Integer user_id) {
        List<Map<String, Object>> maps = addDao.queryByUser_id(user_id);

        return maps;
    }

    @Override
    public boolean updateIsDefault(Integer user_id, Integer add_id) {
        int i = addDao.addIsDefault(user_id, add_id);
        int i1 = addDao.subIsDefault(user_id, add_id);

        return i1==5;
    }

    @Override
    public boolean updateIsDefault2(Integer user_id ,Integer action) {
       boolean b;
        if (action==1){
            int i = addDao.subIsDefault2(user_id);
            b=true;
        }else {
            b=false;
        }

        return b;
    }

    @Override
    public boolean deleteAddress(Integer user_id, Integer add_id) {
        int i = addDao.deleteAddress(user_id, add_id);
        return i==1;
    }

    @Override
    public boolean addAddress(String recipient, Integer re_number, String address, Integer user_id, Integer isdedault) {
        int i=0;
        if (isdedault==1){
           int  i1 = addDao.subIsDefault2(user_id);
             i = addDao.addAddress(recipient, re_number, address, user_id, isdedault);
        }else {
            i = addDao.addAddress(recipient, re_number, address, user_id, isdedault);
        }
        return i==1;
    }

    @Override
    public boolean updateAddress(String recipient, Integer re_number, String address, Integer add_id) {
        int i = addDao.updateAddress(recipient, re_number, address, add_id);
        return i==1;
    }

//    @Override
//    public boolean addIsDefault(Integer user_id, Integer add_id) {
//        int i = addDao.addIsDefault(user_id, add_id);
//        Map<String, Object> map = userdao.queryByUserId(user_id);
//        return i==1;
//    }
//
//    @Override
//    public boolean subIsDefault(Integer user_id, Integer add_id) {
//        int i = addDao.subIsDefault(user_id,add_id);
//        return i==1;
//    }
}
