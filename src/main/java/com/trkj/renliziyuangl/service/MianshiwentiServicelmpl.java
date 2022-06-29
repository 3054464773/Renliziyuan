package com.trkj.renliziyuangl.service;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.trkj.renliziyuangl.dao.MianshiguizhanbiaoDao;
import com.trkj.renliziyuangl.dao.MianshiguizhanzibiaoDao;
import com.trkj.renliziyuangl.dao.MianshijilubiaoDao;
import com.trkj.renliziyuangl.pojo.LoginUser;
import com.trkj.renliziyuangl.pojo.Mianshiguizhanzibiao;
import com.trkj.renliziyuangl.pojo.Mianshijilubiao;
import com.trkj.renliziyuangl.pojo.Yuangongbiao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.crypto.Data;
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
    @Transactional
    @Override
    public int deleteById(int mbh) {
        int b=mianshiguizhanbiaoDao.deleteById(mbh);
        int a=mianshiguizhanzibiaoDao.deleteById(mbh);
        return 1;
    }
    @Transactional
    @Override
    public Mianshiguizhanzibiao xiugaigzz(Mianshiguizhanzibiao mianshiguizhanzibiao) {
         int a=mianshiguizhanzibiaoDao.xiugaigzz(mianshiguizhanzibiao);
        return mianshiguizhanzibiao;
    }
//预约面试，面试记录，面试问题
//    @Override
//    public List<Mianshiguizhanzibiao> mianshiwenti(int zwbh,int rid, int ybh, Date mjsj) {
//        List<Mianshiguizhanzibiao> b=mianshiguizhanzibiaoDao.mianshiwenti(zwbh,rid);
//        Mianshijilubiao a=new Mianshijilubiao();
//        Mianshiguizhanzibiao c=new Mianshiguizhanzibiao();
//        Integer p=b.get(0).getMzbh();
//        a.setRid(rid);
//        a.setMzbh(p);
//        a.setYbh(ybh);
//        a.setMjsj(mjsj);
//        a.setMjzt(3);
//        int l=mianshijilubiaoDao.insert(a);
//        return  null;
//    }
//第一次面试
@Transactional
@Override
public List<Mianshiguizhanzibiao> mianshiwenti(int zwbh,int rid, int ybh, Date mjsj) {
    List<Mianshiguizhanzibiao> b=mianshiguizhanzibiaoDao.mianshiwenti(zwbh,rid);
    Mianshijilubiao a=new Mianshijilubiao();
    a.setRid(rid);
    a.setYbh(ybh);
    a.setMjsj(mjsj);
    a.setMjzt(3);
    int l=mianshijilubiaoDao.insert(a);
    return  null;
}
//@Override
//public List<Mianshiguizhanzibiao> mianshiwenti(int zwbh,int rid, int ybh, Date mjsj) {
//    List<Mianshiguizhanzibiao> b=mianshiguizhanzibiaoDao.mianshiwenti(zwbh,rid);
//    Mianshijilubiao a=new Mianshijilubiao();
//    Mianshiguizhanzibiao c=new Mianshiguizhanzibiao();
//    Integer p=b.get(0).getMzbh();
//    a.setRid(rid);
//    a.setMzbh(p);
//    a.setYbh(ybh);
//    a.setMjsj(mjsj);
//    a.setMjzt(3);
//    int l=mianshijilubiaoDao.insert(a);
//    return  null;
//}
    //判断面试
@Transactional
    @Override
    public Mianshijilubiao mianshiwentitt(int rid, Date mjsj, int msyg,int mjbh,String mspj) {
                        Mianshijilubiao a=new Mianshijilubiao();
                        a.setRid(rid);
                        a.setYbh(msyg);
                        a.setMjsj(mjsj);
                        a.setMjzt(3);
                        int ccc=mianshijilubiaoDao.insert(a);
        UpdateWrapper<Mianshijilubiao> updateWrapper=new UpdateWrapper();
               updateWrapper.eq("mjbh",mjbh);
               updateWrapper.set("mjxcsj",mjsj);
               updateWrapper.set("mspj",mspj);
               int bbb=mianshijilubiaoDao.update(null,updateWrapper);

        return  null;
    }
//    @Override
//    public Mianshijilubiao mianshiwentitt(int mzbh, int rid, Date mjsj, int msyg,int mjbh,String mspj) {
//        Mianshijilubiao a=new Mianshijilubiao();
//        a.setMzbh(mzbh);
//        a.setRid(rid);
//        a.setYbh(msyg);
//        a.setMzbh(mzbh);
//        a.setMjsj(mjsj);
//        a.setMjzt(3);
//        int ccc=mianshijilubiaoDao.insert(a);
//        UpdateWrapper<Mianshijilubiao> updateWrapper=new UpdateWrapper();
//        updateWrapper.eq("mjbh",mjbh);
//        updateWrapper.set("mjxcsj",mjsj);
//        updateWrapper.set("mspj",mspj);
//        int bbb=mianshijilubiaoDao.update(null,updateWrapper);
//
//        return  null;
//    }
@Transactional
    @Override
    public Mianshiguizhanzibiao insertmz(Mianshiguizhanzibiao mianshiguizhanzibiao) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Yuangongbiao yhb = loginUser.getYhb();
         Mianshiguizhanzibiao a=new Mianshiguizhanzibiao();
         a.setMzbh(mianshiguizhanzibiao.getMzbh());
        a.setYbh(yhb.getYbh());
        a.setMbh(mianshiguizhanzibiao.getMbh());
        a.setMzwt(mianshiguizhanzibiao.getMzwt());
        int b=mianshiguizhanzibiaoDao.insert(a);
        return mianshiguizhanzibiao;
    }
    @Transactional
    @Override
    public int shanchuwenti(int mzbh) {
        return mianshiguizhanzibiaoDao.deleteById(mzbh);
    }


}
