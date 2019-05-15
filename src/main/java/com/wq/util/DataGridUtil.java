package com.wq.util;

import com.wq.entity.PageBean;
import com.wq.mapper.BaseMapper;
import com.wq.service.CommonService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 列表查询工具类
 *
 * @ClassName DataGridUtil
 * @Author dengweiping
 **/
public class DataGridUtil {

    @Resource
    private BaseMapper baseMapper;
    @Resource
    private CommonService service;

    public void selectDataGrid(HttpServletResponse response, Map<String, Object> dataMap) throws Exception {
        String page = (dataMap.get("page") == null ? 1 : dataMap.get("page")) + "";//起始页
        String rows = (dataMap.get("rows") == null ? 10 : dataMap.get("rows")) + "";//每页条数
        String table = dataMap.get("table") + "";//表名
        String where = dataMap.get("where") + "";
        PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
        Map<String, Object> map = new HashMap<>();
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        map.put("table", table);
        map.put("where", where);
        List<Map<String, Object>> list = baseMapper.findGridData(map);
        Long total = baseMapper.getGridTotal(map);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(list);
        result.put("rows", jsonArray);
        result.put("total", total);
        ResponseUtil.write(response, result);
    }

    /**
    　　* @Description 公共新增方法
    　　* @param [dataMap]
    　　* @return int
    　　* @throws
    　　* @author dengweiping
    　　* @date 2019/5/15 15:25
    　　*/
    public int addSave(Map<String, Object> dataMap) {
        return service.addSave(dataMap);
    }
}
