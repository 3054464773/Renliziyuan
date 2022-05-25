package com.trkj.renliziyuangl.service;

import com.trkj.renliziyuangl.dao.MianshiguizhanbiaoDao;
import com.trkj.renliziyuangl.dao.MianshiguizhanzibiaoDao;
import com.trkj.renliziyuangl.dao.MianshijilubiaoDao;
import com.trkj.renliziyuangl.pojo.Mianshiguizhanzibiao;
import com.trkj.renliziyuangl.pojo.Mianshijilubiao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MianshiwentiServicelmpl implements MianshiwentiService{
    @Autowired
    private MianshiguizhanzibiaoDao mianshiguizhanzibiaoDao;
    @Autowired
    private MianshiguizhanbiaoDao mianshiguizhanbiaoDao;
    @Autowired
    private MianshijilubiaoDao mianshijilubiaoDao;
    @Override
    public List<Mianshiguizhanzibiao> mianshizi(int mbh) {
        return mianshiguizhanzibiaoDao.mianshizi(mbh);
    }
    //删除
    @Override
    public int deleteById(int mbh) {
        int b=mianshiguizhanbiaoDao.deleteById(mbh);
        int a=mianshiguizhanzibiaoDao.deleteById(mbh);
        return 1;
    }

    @Override
    public Mianshiguizhanzibiao xiugaigzz(Mianshiguizhanzibiao mianshiguizhanzibiao) {
         int a=mianshiguizhanzibiaoDao.xiugaigzz(mianshiguizhanzibiao);
        return mianshiguizhanzibiao;
    }
//预约面试，面试记录，面试问题
    @Override
    public List<Mianshiguizhanzibiao> mianshiwenti(int zwbh,int rid) {
        List<Mianshiguizhanzibiao> b=mianshiguizhanzibiaoDao.mianshiwenti(zwbh,rid);
        Mianshijilubiao a=new Mianshijilubiao();
        Mianshiguizhanzibiao c=new Mianshiguizhanzibiao();
        Integer p=b.get(0).getMzbh();
        a.setRid(rid);
        a.setMzbh(p);
        a.setMjsj(new Date());
        a.setMjzt(3);
        int l=mianshijilubiaoDao.insert(a);
        return  null;
    }
    //判断面试
    @Override
    public List<Mianshiguizhanzibiao> mianshiwentitt(int zwbh,int rid) {
        List<Mianshiguizhanzibiao> b=mianshiguizhanzibiaoDao.mianshiwenti(zwbh,rid);
       List<Mianshijilubiao> x=mianshijilubiaoDao.mianshisy();
            for (int i=0;i<b.size();i++){
                for (int j=0;j<x.size();j++){
                    if (b.get(i).getMzbh()==x.get(j).getMzbh()){
                        Mianshijilubiao a=new Mianshijilubiao();
                        Integer ll=b.get(i+1).getMzbh();
                        a.setRid(rid);
                        a.setMzbh(ll);
                        a.setMjsj(new Date());
                        a.setMjzt(3);
                        int ccc=mianshijilubiaoDao.insert(a);
                    }
                }

            }
        return  null;
    }

    @Override
    public Mianshiguizhanzibiao insertmz(Mianshiguizhanzibiao mianshiguizhanzibiao) {
         Mianshiguizhanzibiao a=new Mianshiguizhanzibiao();
         a.setMzbh(mianshiguizhanzibiao.getMzbh());
        a.setYbh(mianshiguizhanzibiao.getYbh());
        a.setMbh(mianshiguizhanzibiao.getMbh());
        a.setMzwt(mianshiguizhanzibiao.getMzwt());
        int b=mianshiguizhanzibiaoDao.insert(a);
        return mianshiguizhanzibiao;
    }


}
