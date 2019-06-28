package com.oaec.wlMall.service.impl;

import com.oaec.wlMall.dao.*;
import com.oaec.wlMall.dao.impl.*;
import com.oaec.wlMall.service.OrderService;
import com.oaec.wlMall.util.CommonDao;

import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements OrderService {
    private ComDao comDao = new ComDaoImpl();
    private User2Dao user2Dao =new User2DaoImpl();
    private OrdersDao ordersDao =new OrderDaoImpl();
    private AddDao addDao = new AddDaoImpl();
    private CartDao cartDao = new CartDaoImpl();
    @Override
    public List<Map<String, Object>> getOrders(Integer user_id) {
        List<Map<String, Object>> orderList = ordersDao.queryByUser_id(user_id);
        //查地址
        for (Map<String, Object> map:orderList) {
            //获取地址编号
            int add_id = Integer.parseInt(map.get("ADD_ID").toString());
            //查询地址
            Map<String, Object> address = addDao.queryByAdd_id(add_id);
            map.put("address",address);
            //查总价钱
            int order_id = Integer.parseInt(map.get("ORDER_ID").toString());
            Double totalPrice = ordersDao.getTotalPrice(order_id);
            map.put("totalPrice",totalPrice);
            //查询订单对应商品
            List<Map<String, Object>> commodities = ordersDao.queryCommodityByOrder_id(order_id);
            map.put("commodities",commodities);
        }
        return orderList;
    }

    @Override
    public boolean returnOfGoods(Integer quantity, Integer comm_id, Double money, Integer user_id,Integer dbid) {
        int i = comDao.addInventory(quantity, comm_id);
        int j;
        if (i==1){
            j = user2Dao.addBalance(money, user_id);
            ordersDao.updateStatus(dbid);
        }else {
            j=0;
        }
        return j==1;
    }

    @Override
    public boolean pay(Integer quantity, Integer comm_id, Double money, Integer user_id) {
        int i = comDao.subInventoryAndAddSales(quantity, comm_id);
        int i1;
        if (i==1){
             i1 = user2Dao.subBalance(money, user_id);
        }else {
            i1=0;
        }
        return i1==1;
    }

    @Override
    public boolean deleteOrder(Integer dbid) {
        int i = ordersDao.updateIsDELETE(dbid);
        return i==1;
    }

    @Override
    public boolean submit(Integer user_id,Integer add_id, String[] comm_ids) {
        int result = 0;
        double sum = 0.0;
        //1.向订单主表插入数据
        int order_id = ordersDao.doInsetOrder(user_id, add_id);
        for (String comm_id : comm_ids) {
            int commId = Integer.parseInt(comm_id);
            //查询当前编号的商品信息
            Map<String, Object> commodity = cartDao.queryByCommAndUserId(user_id, commId);
            double price = Double.parseDouble(commodity.get("PRICE").toString());
            commodity.put("ORDER_ID",order_id);
            //2.向订单明细表插入数据
            result += ordersDao.doInserOrder_detail(commodity);
            //3.在购物车中删除此商品
            result +=cartDao.deleteCart(commId,user_id);
            //4.修改商品库存和销量
            int quantity = Integer.parseInt(commodity.get("QUANTITY").toString());
            result +=comDao.subInventoryAndAddSales(quantity,commId);
            Double totalPrice1 = ordersDao.getTotalPrice(order_id);
            sum += totalPrice1;
        }
        Map<String, Object> map = user2Dao.queryByUserId(user_id);
        double balance = Double.parseDouble(map.get("BALANCE").toString());
        if (sum <= balance){
            result += user2Dao.subBalance(sum,user_id);

        }else {
            result = 0;
        }


        return result>0;
    }

    @Override
    public boolean InsetComment(String comment, Integer dbid) {
        int i = ordersDao.doInsetComment(comment, dbid);
        Map<String, Object> map = ordersDao.queryComment(dbid);
        int comm_id = Integer.parseInt(map.get("COMM_ID").toString());
        int i1 = comDao.doInsertComment(comment,comm_id);
        return i1==1;
    }

    @Override
    public Map<String, Object> queryComment(Integer dbid) {
        Map<String, Object> map = ordersDao.queryComment(dbid);
        return map;
    }


}
