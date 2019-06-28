package com.oaec.wlMall.dao.impl;

import com.oaec.wlMall.dao.AchDao;
import com.oaec.wlMall.util.CommonDao;

import java.util.List;
import java.util.Map;

public class AchDaoImpl extends CommonDao implements AchDao {
    @Override
    public List<Map<String, Object>> queryAll() {
        String sql="SELECT * FROM achievement";
        return query4MapList(sql);
    }

    @Override
    public Map<String, Object> queryByUser_id(Integer user_id) {
        String sql="SELECT * FROM achievement  WHERE (SELECT achi FROM USER2 WHERE user_id = ?) BETWEEN loachi AND hiachi";
        return query4Map(sql,user_id);
    }
}
