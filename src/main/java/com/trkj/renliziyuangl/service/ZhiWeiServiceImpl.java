package com.trkj.renliziyuangl.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.renliziyuangl.dao.ZhiweibiaoDao;
import com.trkj.renliziyuangl.pojo.Bumenbiao;
import com.trkj.renliziyuangl.pojo.Zhiweibiao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ZhiWeiServiceImpl implements ZhiWeiService {
    @Autowired
    private ZhiweibiaoDao zwdao;
    @Override
    public Map findallzw(int ym) {
        Page<Zhiweibiao> bumenbiaoPage = zwdao.selectPage(new Page<>(ym, 8),  new LambdaQueryWrapper<Zhiweibiao>().orderByDesc(Zhiweibiao::getZwbh));
        Map map=new HashMap();
        map.put("zwlist",bumenbiaoPage.getRecords());
        map.put("zts",bumenbiaoPage.getPages());
        return map;
    }
}
