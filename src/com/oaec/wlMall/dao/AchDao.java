package com.oaec.wlMall.dao;

import java.util.List;
import java.util.Map;

public interface AchDao {
    List<Map<String,Object>> queryAll();
    Map<String,Object> queryByUser_id(Integer user_id);
}
