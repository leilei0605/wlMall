package com.oaec.wlMall.dao;

import java.util.List;
import java.util.Map;

public interface BrandDao {
    List<Map<String,Object>> queryByTid(Integer t_id);


}
