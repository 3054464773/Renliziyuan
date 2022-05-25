package com.trkj.renliziyuangl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.renliziyuangl.dao.JiaosebiaoDao;
import com.trkj.renliziyuangl.dao.ShenhesxqxbiaoDao;
import com.trkj.renliziyuangl.pojo.Jiaosebiao;
import com.trkj.renliziyuangl.pojo.Shenhesxqxbiao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShenhesxqxServiceImpl implements ShenhesxqxService {
    @Autowired
    private ShenhesxqxbiaoDao sqdao;


    @Override
    public Map findsxqx(int ym, int shbid) {
        Map map=new HashMap();
        IPage<Shenhesxqxbiao> findsxqx = sqdao.findsxqx(new Page(ym, 6), shbid);
        map.put("sxlist",findsxqx.getRecords());
        map.put("zts",findsxqx.getPages());
        return map;
    }

    @Override
    public int deletesxqx(int id) {
        return sqdao.deleteById(id);
    }
}
