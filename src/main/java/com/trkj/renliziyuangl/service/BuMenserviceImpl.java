package com.trkj.renliziyuangl.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.renliziyuangl.dao.BumenbiaoDao;
import com.trkj.renliziyuangl.pojo.Bumenbiao;
import com.trkj.renliziyuangl.pojo.Jiaosebiao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BuMenserviceImpl implements BuMenservice {
    @Autowired
    private BumenbiaoDao bmdao;

    @Override
    public Map findallbm(int ym) {

        Page<Bumenbiao> bumenbiaoPage = bmdao.selectPage(new Page<>(ym, 8),  new LambdaQueryWrapper<Bumenbiao>().orderByDesc(Bumenbiao::getBmbh));
        Map map=new HashMap();
        map.put("bmlist",bumenbiaoPage.getRecords());
        map.put("zts",bumenbiaoPage.getPages());
        return map;
    }

    @Override
    public Map mohufindbm(int ym, String bmname) {
        Page<Bumenbiao> page=new Page<>(ym,8);
        LambdaQueryWrapper<Bumenbiao> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Bumenbiao::getBmmc,bmname).orderByDesc(Bumenbiao::getBmbh);
        Page<Bumenbiao> bumenbiaoPage = bmdao.selectPage(page, lambdaQueryWrapper);
        Map map=new HashMap();
        map.put("bmlist",bumenbiaoPage.getRecords());
        map.put("zys",bumenbiaoPage.getPages());
        return map;
    }

    @Override
    public boolean deletebm(int id) {
        int i = bmdao.deleteById(id);
        return i>0?true:false;
    }

    @Override
    public boolean insertbm(Bumenbiao bm) {
        bm.setBmsj(new Date());
        int insert = bmdao.insert(bm);
        return insert>0?true:false;
    }

    @Override
    public boolean updatebm(Bumenbiao bm) {
        int jg = bmdao.updateById(bm);
        return jg>0?true:false;
    }
}
