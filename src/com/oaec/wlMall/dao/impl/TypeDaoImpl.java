package com.oaec.wlMall.dao.impl;

import com.oaec.wlMall.dao.TypeDao;
import com.oaec.wlMall.entity.Type;
import com.oaec.wlMall.util.CommonDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class TypeDaoImpl extends CommonDao implements TypeDao {




    @Override
    public List<Map<String,Object>> queryNav() {
        String sql="SELECT * FROM type WHERE t_id IN (SELECT t_id FROM commodity GROUP BY t_id)";
        return query4MapList(sql);
    }
}
