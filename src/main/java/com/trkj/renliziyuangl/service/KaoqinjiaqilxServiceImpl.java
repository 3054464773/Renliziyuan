package com.trkj.renliziyuangl.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.renliziyuangl.dao.KaoqinjiaqilxbiaoDao;
import com.trkj.renliziyuangl.pojo.Kaoqinjiaqilxbiao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class KaoqinjiaqilxServiceImpl implements KaoqinjiaqilxService {
    @Autowired
    private KaoqinjiaqilxbiaoDao kqlxdao;

    @Override
    public Map findkqlx(int ym,String cxtj) {
        LambdaQueryWrapper<Kaoqinjiaqilxbiao> qw=new LambdaQueryWrapper<>();
        qw.like(Kaoqinjiaqilxbiao::getKqjqmc,cxtj).orderByDesc(Kaoqinjiaqilxbiao::getKqjqbh);
        Page<Kaoqinjiaqilxbiao> kaoqinjiaqilxbiaoPage = kqlxdao.selectPage(new Page<>(ym, 6), qw);
        Map map=new HashMap();
        map.put("jqlxlist",kaoqinjiaqilxbiaoPage.getRecords());
        map.put("zts",kaoqinjiaqilxbiaoPage.getPages());
        return map;
    }

    @Override
    public int insertkqlx(Kaoqinjiaqilxbiao kqbiao) {
        return kqlxdao.insert(kqbiao);
    }

    @Override
    public int shanchu(int jqid) {
        Kaoqinjiaqilxbiao kaoqinjiaqilxbiao = kqlxdao.selectById(jqid);
        if (kaoqinjiaqilxbiao.getIssc()==1){
            return 0;
        }else {
            return  kqlxdao.deleteById(jqid);
        }
    }
}
