package com.oaec.wlMall.service.impl;

import com.oaec.wlMall.dao.CartDao;
import com.oaec.wlMall.dao.impl.CartDaoImpl;
import com.oaec.wlMall.service.CartService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartServiceImpl implements CartService {
    private CartDao cartDao=new CartDaoImpl();
    @Override
    public List<Map<String, Object>> getCartCommodity(Integer user_id) {
        return cartDao.queryByUserId(user_id);

    }

    @Override
    public boolean addCart( Integer quantity,Integer user_id ,Integer comm_id) {
        Map<String, Object> map1 = cartDao.queryByCommAndUserId(user_id, comm_id);
        Map<String, Object> map = new HashMap<>();
        map.put("user_id",user_id);
        map.put("comm_id",comm_id);
        map.put("quantity",quantity);
        int result =0;
        if (map1==null){
            result = cartDao.addCart(map);
            System.out.println(result);
        }
        else {

            result=cartDao.addQuantity(map);
            System.out.println(result);
            }
        return result==1;
    }

    @Override
    public boolean deleteCart(Integer comm_id,Integer user_id ) {
        int i = cartDao.deleteCart(comm_id, user_id);
        return i==1;
    }

    @Override
    public boolean updateQuantity(String action,Integer user_id, Integer comm_id) {
        int result = 0;
        if ("add".equals(action)) {
           result= cartDao.addQuantity1(user_id, comm_id);

        }else {
           result= cartDao.subQuantity(user_id, comm_id);
            System.out.println(result);
        }



        return result==1;
    }

    @Override
    public Map<String, Object> getTotal(Integer user_id, String[] comm_ids) {
        return cartDao.queryTotal(user_id,comm_ids);
    }

    @Override
    public List<Map<String, Object>> getCommodities4Checkout(Integer user_id, String[] comm_ids) {

        return cartDao.queryCommodity4Checkout(user_id,comm_ids);
    }
}
