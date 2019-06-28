package com.oaec.wlMall.service.impl;

import com.alibaba.fastjson.JSON;
import com.oaec.wlMall.dao.BrandDao;
import com.oaec.wlMall.dao.ComDao;
import com.oaec.wlMall.dao.TypeDao;
import com.oaec.wlMall.dao.impl.BrandDaoImpl;
import com.oaec.wlMall.dao.impl.ComDaoImpl;
import com.oaec.wlMall.dao.impl.TypeDaoImpl;
import com.oaec.wlMall.entity.Commodity;
import com.oaec.wlMall.entity.Type;
import com.oaec.wlMall.service.NavService;

import java.util.List;
import java.util.Map;

public class NavServiceImpl implements NavService {
    private TypeDao typeDao= new TypeDaoImpl();
    private BrandDao brandDao=new BrandDaoImpl();
    @Override
    public List<Map<String,Object>> getNav() {
        List<Map<String, Object>> maps = typeDao.queryNav();
        for (Map<String, Object> map:maps){
            System.out.println(map);
            int t_id = Integer.parseInt(map.get("T_ID").toString());
            List<Map<String, Object>> brands= brandDao.queryByTid(t_id);
            map.put("brands",brands);

        }
        System.out.println(JSON.toJSONString(maps));
        return  maps;
    }
}
