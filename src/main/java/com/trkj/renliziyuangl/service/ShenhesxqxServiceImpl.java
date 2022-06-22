package com.trkj.renliziyuangl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.renliziyuangl.dao.JiaosebiaoDao;
import com.trkj.renliziyuangl.dao.ShenhesxqxbiaoDao;
import com.trkj.renliziyuangl.pojo.Jiaosebiao;
import com.trkj.renliziyuangl.pojo.Shenhesxqxbiao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShenhesxqxServiceImpl implements ShenhesxqxService {
    @Autowired
    private ShenhesxqxbiaoDao sqdao;
    @Autowired
    private JiaosebiaoDao jsdao;


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

    @Override
    public List<Jiaosebiao> insertsxqx(int id) {
        List<Jiaosebiao> inshidfandjs = sqdao.inshidfandjs(id);
        List<Jiaosebiao> jiaosebiaos = jsdao.selectList(null);
        List<Jiaosebiao> newlsit=new ArrayList<>();
        boolean flg=true;
        for (int i = 0; i < jiaosebiaos.size(); i++) {
            for (int i1 = 0; i1 < inshidfandjs.size(); i1++) {
                if (jiaosebiaos.get(i).getJsmc().equals(inshidfandjs.get(i1).getJsmc())){
                    flg=false;
                    break;
                }
            }
            if (flg){
                newlsit.add(jiaosebiaos.get(i));
            }
            flg=true;
        }
        return newlsit;
    }

    @Override
    public int insertsxqxx(Shenhesxqxbiao shstl2) {
        int[] jsbhh = shstl2.getJsbhh();
        for (int i = 0; i < jsbhh.length; i++) {
            Shenhesxqxbiao sh=new Shenhesxqxbiao();
            sh.setShbid(shstl2.getShbid());
            sh.setJsbh(jsbhh[i]);
            sqdao.insert(sh);
        }

        return 1;
    }
}
