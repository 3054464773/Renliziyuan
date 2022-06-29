package com.trkj.renliziyuangl.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.renliziyuangl.dao.JiaosebiaoDao;
import com.trkj.renliziyuangl.dao.JiaoseqianduanbiaoDao;
import com.trkj.renliziyuangl.dao.QianduanbiaoDao;
import com.trkj.renliziyuangl.pojo.Jiaoseqianduanbiao;
import com.trkj.renliziyuangl.pojo.Qianduanbiao;
import com.trkj.renliziyuangl.vo.Xinzengcaidan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QianduanServiceImpl implements QianduanService {
    @Autowired
    private QianduanbiaoDao qddao;
    @Autowired
    private JiaoseqianduanbiaoDao qdqddao;
    @Override
    public Map findallqd(String qdfjid,int ym,String cxtj) {
        IPage<Qianduanbiao> findallqd = qddao.findallqd(qdfjid,new Page(ym, 4), "%"+cxtj+"%");
        Map map=new HashMap();
        map.put("cdlsit",findallqd.getRecords());
        map.put("zts",findallqd.getPages());
        map.put("fjqd",qddao.findfujiqd());
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

    @Override
    public Map findallqdym( String cxtj) {
        List<JiaosebiaoDao> findalljsqds = qddao.findalljsqds("%" + cxtj + "%");
        Map map=new HashMap();
        map.put("qdlist",findalljsqds);
        return map;
    }

    @Override
    public int shanchucd(int jsid, int qdid) {
        LambdaQueryWrapper<Jiaoseqianduanbiao> qw=new LambdaQueryWrapper<>();
        qw.eq(Jiaoseqianduanbiao::getJsid,jsid).eq(Jiaoseqianduanbiao::getQdid,qdid);
        return qdqddao.delete(qw);
    }

    @Override
    public List<Qianduanbiao>  chaxunwfpcd(List<Qianduanbiao> qdlist) {
        if (qdlist.size()==0){
            int [] b=new int[1];
            b[0]=-1;
            return qddao.chaxunwfpcd(b);
        }else {
            int [] a=new int[qdlist.size()];
            for (int i = 0; i < qdlist.size(); i++) {
                a[i]=qdlist.get(i).getQdbid();
            }
            return qddao.chaxunwfpcd(a);
        }

    }

    @Override
    public int xinzengcaidan(Xinzengcaidan fpcdlist) {
        int jsidd = fpcdlist.getJsidd();
        List<Qianduanbiao> xzcdlist = fpcdlist.getXzcdlist();
        for (Qianduanbiao qianduanbiao : xzcdlist) {
            Jiaoseqianduanbiao q=new Jiaoseqianduanbiao();
           q.setJsid(jsidd);
           q.setQdid(qianduanbiao.getQdbid());
            qdqddao.insert(q);
        }
        return 1;
    }
}
