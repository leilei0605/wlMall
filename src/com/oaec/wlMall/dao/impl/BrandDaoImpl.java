package com.oaec.wlMall.dao.impl;

import com.oaec.wlMall.dao.BrandDao;
import com.oaec.wlMall.util.CommonDao;

import java.util.List;
import java.util.Map;

public class BrandDaoImpl  extends CommonDao implements BrandDao {
    @Override
    public List<Map<String, Object>> queryByTid(Integer t_id) {
        String sql="SELECT DISTINCT  c.t_id,BRAND.b_name ,BRAND.b_id FROM TYPE t, COMMODITY c,BRAND WHERE c.b_id=BRAND.b_id AND t.t_id=c.t_id AND t.t_id=?";
     return query4MapList(sql,t_id);
    }


}
