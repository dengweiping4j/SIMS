package com.wq.service.impl;

import com.wq.service.CommonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("commonService")
public class CommonServiceImpl implements CommonService {
    @Override
    public List find(Map map) {
        return null;
    }

    @Override
    public int addSave(Map map) {
        return 0;
    }

    @Override
    public int update(Map map) {
        return 0;
    }

    @Override
    public int delete(String[] pkids) {
        return 0;
    }
}
