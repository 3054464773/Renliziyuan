package com.trkj.renliziyuangl.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.renliziyuangl.dao.JiaosebiaoDao;
import com.trkj.renliziyuangl.pojo.Jiaosebiao;
import com.trkj.renliziyuangl.pojo.Quanxianbiao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JiaoseserviceImpl implements Jiaoseservice {
    @Autowired
    private JiaosebiaoDao jsdao;
    @Override
    public Map findalljiaose(int page) {
        Page<Jiaosebiao> jiaosebiaoPage = jsdao.selectPage(new Page<>(page, 8), new LambdaQueryWrapper<Jiaosebiao>().orderByDesc(Jiaosebiao::getJsbh));
        Map map=new HashMap();
        map.put("jiaoselist",jiaosebiaoPage.getRecords());
        map.put("zys",jiaosebiaoPage.getPages());
        return map;
    }

    @Override
    public Map mohufindjiaose(int ym, String jsname) {
        Page<Jiaosebiao> page=new Page<>(ym,8);
        LambdaQueryWrapper<Jiaosebiao> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Jiaosebiao::getJsmc,jsname).orderByDesc(Jiaosebiao::getJsbh);
        Page<Jiaosebiao> jiaosebiaoPage = jsdao.selectPage(page, lambdaQueryWrapper);
        Map map=new HashMap();
        map.put("jslist",jiaosebiaoPage.getRecords());
        map.put("zys",jiaosebiaoPage.getPages());
        return map;
    }

    @Override
    public boolean insertjiaose(Jiaosebiao js) {
        int insert = jsdao.insert(js);
        return insert>0?true:false;
    }

    @Override
    public boolean updatejiaose(Jiaosebiao js) {
        int jg = jsdao.updateById(js);
        return jg>0?true:false;
    }

    @Override
    public boolean deletejiaose(int id) {
        int i = jsdao.deleteById(id);
        return i>0?true:false;
    }
}
