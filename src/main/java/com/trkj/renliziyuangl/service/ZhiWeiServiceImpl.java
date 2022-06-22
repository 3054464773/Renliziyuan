package com.trkj.renliziyuangl.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.renliziyuangl.dao.MianshiguizhanbiaoDao;
import com.trkj.renliziyuangl.dao.ZhiweibiaoDao;
import com.trkj.renliziyuangl.pojo.Bumenbiao;
import com.trkj.renliziyuangl.pojo.Mianshiguizhanbiao;
import com.trkj.renliziyuangl.pojo.Zhiweibiao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ZhiWeiServiceImpl implements ZhiWeiService {
    @Autowired
    private ZhiweibiaoDao zwdao;
    @Autowired
    private MianshiguizhanbiaoDao msgzDao;
    @Override
    public Map findallzw(int ym) {
        Page<Zhiweibiao> bumenbiaoPage = zwdao.selectPage(new Page<>(ym, 8),  new LambdaQueryWrapper<Zhiweibiao>().orderByDesc(Zhiweibiao::getZwbh));
        Map map=new HashMap();
        map.put("zwlist",bumenbiaoPage.getRecords());
        map.put("zts",bumenbiaoPage.getPages());
        return map;
    }

    @Override
    public Map mohufindzw(int ym, String zwname) {
        Page<Zhiweibiao> page=new Page<>(ym,8);
        LambdaQueryWrapper<Zhiweibiao> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Zhiweibiao::getZwmc,zwname).orderByDesc(Zhiweibiao::getZwbh);
        Page<Zhiweibiao> bumenbiaoPage = zwdao.selectPage(page, lambdaQueryWrapper);
        Map map=new HashMap();
        map.put("zwlist",bumenbiaoPage.getRecords());
        map.put("zys",bumenbiaoPage.getPages());
        return map;
    }

    @Override
    public boolean insertzw(Zhiweibiao zw) {
        zw.setZwsj(new Date());
        int insert = zwdao.insert(zw);
        return insert>0?true:false;
    }

    @Override
    public boolean updatezw(Zhiweibiao zw) {
        int jg = zwdao.updateById(zw);
        return jg>0?true:false;
    }

    @Override
    public List<Zhiweibiao> zhiwei() {

        return zwdao.zhiwei();
    }
//
//    @Override
//    public List<Zhiweibiao> zhiweiqc() {
//        QueryWrapper<Zhiweibiao> queryWrapper=new QueryWrapper<>();
//        queryWrapper.select("distinct   9,zwbh");
//
//        return zwdao.selectList(queryWrapper);
//    }

}
