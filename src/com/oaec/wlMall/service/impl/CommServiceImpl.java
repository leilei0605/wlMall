package com.oaec.wlMall.service.impl;

import com.oaec.wlMall.dao.ComDao;
import com.oaec.wlMall.dao.impl.ComDaoImpl;
import com.oaec.wlMall.entity.Commodity;
import com.oaec.wlMall.service.ComService;

import java.util.List;
import java.util.Map;

public class CommServiceImpl implements ComService {
    ComDao comDao=new ComDaoImpl();

    @Override
    public List<Map<String,Object>> query(String name ,String tid ,String bid,int page) {
     if (tid!=null){
         return  comDao.queryTid(Integer.parseInt(tid));
     }if (bid!=null){
         return comDao.queryByBid(Integer.parseInt(bid));
        }
        else if (name==null){
         return comDao.queryAll( page);
     }else {
         return comDao.queryLike(name);
     }

    }

    @Override
    public Map<String, Object> getCommodity(Integer comm_id) {
//        if (comm_id!=null){
            return comDao.queryByCid(comm_id);
//        }else {
//            return
//        }

    }
}
