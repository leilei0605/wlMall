package com.oaec.wlMall.service;

import com.oaec.wlMall.entity.Commodity;

import java.util.List;
import java.util.Map;

public interface ComService {
    List<Map<String,Object>> query(String name,String tid,String bid,int page);
    Map<String,Object> getCommodity(Integer comm_id);
}
