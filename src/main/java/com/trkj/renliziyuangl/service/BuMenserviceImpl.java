package com.trkj.renliziyuangl.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.renliziyuangl.dao.BumenbiaoDao;
import com.trkj.renliziyuangl.dao.ZhiweibiaoDao;
import com.trkj.renliziyuangl.pojo.Bumenbiao;
import com.trkj.renliziyuangl.pojo.Jiaosebiao;
import com.trkj.renliziyuangl.pojo.Zhiweibiao;
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
    @Autowired
    private ZhiweibiaoDao zwdao;

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
    public String deletebm(int id) {
        LambdaQueryWrapper<Zhiweibiao> qw=new LambdaQueryWrapper<>();
        qw.eq(Zhiweibiao::getBmbh,id);
        List<Zhiweibiao> zhiweibiaos = zwdao.selectList(qw);
        if(zhiweibiaos.size()>0){
            return "no";
        }
        int i = bmdao.deleteById(id);
        return "yes";
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

    @Override
    public Map inidfindzw(int id,int page) {
        Page<Zhiweibiao> bumenbiaoPage = zwdao.selectPage(new Page<>(page, 8),  new LambdaQueryWrapper<Zhiweibiao>().eq(Zhiweibiao::getBmbh,id).orderByDesc(Zhiweibiao::getZwbh));
        Map map=new HashMap();
        map.put("zwlist",bumenbiaoPage.getRecords());
        map.put("zts",bumenbiaoPage.getPages());
        return map;
    }

    @Override
    public List<Bumenbiao> bumen() {
        return bmdao.bumen();
    }
}
