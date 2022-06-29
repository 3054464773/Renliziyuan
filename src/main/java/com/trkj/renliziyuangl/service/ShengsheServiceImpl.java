package com.trkj.renliziyuangl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.renliziyuangl.dao.JiaosebiaoDao;
import com.trkj.renliziyuangl.dao.ShenghebiaoDao;
import com.trkj.renliziyuangl.pojo.Shenghebiao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShengsheServiceImpl implements ShengsheService {
    @Autowired
    private ShenghebiaoDao shdao;
    @Autowired
    private JiaosebiaoDao jsdao;

    @Override
    public Map findallshenhe(String shname, int ym) {
        Map map=new HashMap();
        IPage<Shenghebiao> findallshenhe = shdao.findallshenhe(new Page(ym, 6),"%"+ shname+"%");
        map.put("shlist",findallshenhe.getRecords());
        map.put("zts",findallshenhe.getPages());
        map.put("jslist",jsdao.selectList(null));
        return map;
    }

    @Override
    public int insertshenhe(Shenghebiao sh) {
        return shdao.insert(sh);

    }

    @Override
    public int deleteshenhe(int id) {
        Shenghebiao shenghebiao = shdao.selectById(id);
        if (shenghebiao.getShzt()==0){
            return shdao.deleteById(id);
        }else {
            return 0;
        }
    }

    @Override
    public List<Shenghebiao> shenheneir() {
        return shdao.shenheneir();
    }

}
