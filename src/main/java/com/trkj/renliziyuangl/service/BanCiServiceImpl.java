package com.trkj.renliziyuangl.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.renliziyuangl.dao.BancibiaoDao;
import com.trkj.renliziyuangl.pojo.Bancibiao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BanCiServiceImpl implements BanCiService {
    @Autowired
    private BancibiaoDao bddao;

    @Override
    public int insertbanci(Bancibiao bcbiao) {
        return bddao.insert(bcbiao);
    }

    @Override
    public Map findbanci(int ym) {
        Map map=new HashMap();
        Page<Bancibiao> bancibiaoPage = bddao.selectPage(new Page<>(ym, 6), null);
        map.put("bclist",bancibiaoPage.getRecords());
        map.put("zts",bancibiaoPage.getPages());
        return map;
    }

    @Override
    public int shanchubanci(int bcid) {
        Bancibiao bancibiao = bddao.selectById(bcid);
        if (bancibiao.getBcissc()==1){
            return 0;
        }else {
          return   bddao.deleteById(bcid);
        }
    }

    @Override
    public int xiugaibanci(Bancibiao bcbiao2) {
        return  bddao.updateById(bcbiao2);
    }
}
