package com.oaec.wlMall.service.impl;

import com.oaec.wlMall.dao.AchDao;
import com.oaec.wlMall.dao.impl.AchDaoImpl;
import com.oaec.wlMall.service.AchiService;

import java.util.Map;

public class AchiServiceImpl implements AchiService {
    private AchDao achDao =new AchDaoImpl();
    @Override
    public Map<String, Object> queryByUser_id(Integer user_id) {
        Map<String, Object> map = achDao.queryByUser_id(user_id);

        return map;
    }
}
