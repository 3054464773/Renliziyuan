package com.trkj.renliziyuangl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.renliziyuangl.dao.BumenbiaoDao;
import com.trkj.renliziyuangl.dao.KaoqinjilubiaoDao;
import com.trkj.renliziyuangl.pojo.Kaoqinjilubiao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class KaoqingjiluServiceImpl implements KaoqingjiluService {
    @Autowired
    private KaoqinjilubiaoDao kqdao;
    @Autowired
    private BumenbiaoDao bmdao;

    @Override
    public Map findkaoqin(String rzname, String bmmc, String dkzt, String xzsj,int ym) {
        Map map=new HashMap();
        IPage<Kaoqinjilubiao> findkaoqin = kqdao.findkaoqin(new Page(ym,6), "%"+rzname+"%", "%"+bmmc+"%", dkzt, xzsj);
        map.put("kqlist",findkaoqin.getRecords());
        map.put("zts",findkaoqin.getPages());
        map.put("bmlist",bmdao.selectList(null));
        return map;
    }
}
