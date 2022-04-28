package com.trkj.renliziyuangl.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.renliziyuangl.dao.QuanxianbiaoDao;
import com.trkj.renliziyuangl.pojo.Quanxianbiao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuanxianserviceImpl implements Quanxianservice {
    @Autowired
    private QuanxianbiaoDao qxdao;
    @Override
    public Map findallquanxian(int ym) {
//        List<Quanxianbiao> quanxianbiaos = qxdao.selectList(null);
        Page<Quanxianbiao> page=new Page<>(ym,4);
        Page<Quanxianbiao> page1 = qxdao.selectPage(page, null);
        List<Quanxianbiao> records = page1.getRecords();
        Map map=new HashMap();
        map.put("qxlist",records);
        map.put("zys",page1.getPages());
        return map;
    }

    @Override
    public Map mohufindquanxian(int ym,String qxname) {
        Page<Quanxianbiao> page=new Page<>(ym,4);
        LambdaQueryWrapper<Quanxianbiao> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Quanxianbiao::getQxmc,qxname);
        Page<Quanxianbiao> page1 = qxdao.selectPage(page, lambdaQueryWrapper);
        Map map=new HashMap();
        map.put("qxlist",page1.getRecords());
        map.put("zys",page1.getPages());
        return map;
    }

    @Override
    public boolean insertquanxian(Quanxianbiao qx) {
        int insert = qxdao.insert(qx);
        return insert>0?true:false;
    }
}
