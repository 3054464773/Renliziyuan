package com.trkj.renliziyuangl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.renliziyuangl.dao.QianduanbiaoDao;
import com.trkj.renliziyuangl.pojo.Qianduanbiao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class QianduanServiceImpl implements QianduanService {
    @Autowired
    private QianduanbiaoDao qddao;

    @Override
    public Map findallqd(int ym,String cxtj) {
        IPage<Qianduanbiao> findallqd = qddao.findallqd(new Page(ym, 4), "%"+cxtj+"%");
        Map map=new HashMap();
        map.put("cdlsit",findallqd.getRecords());
        map.put("zts",findallqd.getPages());
        return map;
    }

    @Override
    public int updatecd(Qianduanbiao qd) {

        return qddao.updateById(qd);
    }

    @Override
    public int insertcd(Qianduanbiao cdstl) {
        return qddao.insert(cdstl);
    }
}
