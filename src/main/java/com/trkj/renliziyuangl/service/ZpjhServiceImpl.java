package com.trkj.renliziyuangl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.dao.ShenhejilubiaoDao;
import com.trkj.renliziyuangl.dao.ShenhejiluzibiaoDao;
import com.trkj.renliziyuangl.dao.ZhaopingjihuabiaoDao;
import com.trkj.renliziyuangl.dao.ZpjhVoDao;
import com.trkj.renliziyuangl.pojo.*;
import com.trkj.renliziyuangl.vo.zpjhVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ZpjhServiceImpl implements ZpjhService{
    @Autowired
    private ZhaopingjihuabiaoDao zhaopingjihuabiaoDao;
    @Autowired
    private ZpjhVoDao zpjhVoDao;
    @Autowired
    private ShenhejilubiaoDao shenhejilubiaoDao;
    @Autowired
    private ShenhejiluzibiaoDao shenhejiluzibiaoDao;
    @Override
    public PageInfo<zpjhVo> findszpjh(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<zpjhVo> list=zhaopingjihuabiaoDao.findszpjh();
        PageInfo<zpjhVo> pageInfo=new PageInfo<>(list);
        return  pageInfo;
    }

    @Override
    public int deleteById(int zhb) {
        return zhaopingjihuabiaoDao.deleteById(zhb);
    }

    @Override
    public Zhaopingjihuabiao tianjiazpjh(Zhaopingjihuabiao zhaopingjihuabiao) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Yuangongbiao yhb = loginUser.getYhb();
        Shenhejilubiao l=new Shenhejilubiao();
        l.setShjlbh(zhaopingjihuabiao.getShjlbh());
        l.setShbid(zhaopingjihuabiao.getShbid());
        l.setShjlsj(new Date());
        l.setShjlzt(3);
        l.setYbh(yhb.getYbh());
        int a=shenhejilubiaoDao.insert(l);
        Zhaopingjihuabiao zhaopingjihuabiao1=new Zhaopingjihuabiao();
        zhaopingjihuabiao1.setShjlbh(l.getShjlbh());
        zhaopingjihuabiao1.setZwbh(zhaopingjihuabiao.getZwbh());
        zhaopingjihuabiao1.setShbid(zhaopingjihuabiao.getShbid());
        zhaopingjihuabiao1.setZmc(zhaopingjihuabiao.getZmc());
        zhaopingjihuabiao1.setZrs(zhaopingjihuabiao.getZrs());
       zhaopingjihuabiaoDao.insert(zhaopingjihuabiao1);
//        zhaopingjihuabiaoDao.tianjiazpjh(zhaopingjihuabiao);
//        Shenhejiluzibiao shenhejiluzibiao=new Shenhejiluzibiao();
//        shenhejiluzibiao.setShjlbh(l.getShjlbh());
//        shenhejiluzibiao.setYbh(yhb.getYbh());
//        shenhejiluzibiao.setShjlzsj(new Date());
//        shenhejiluzibiao.setShjlzzt(1);
//        shenhejiluzibiao.setShjlzbz(zhaopingjihuabiao.getShjlzbz());
//        int v= shenhejiluzibiaoDao.insert(shenhejiluzibiao);
        return zhaopingjihuabiao;
    }

    @Override
    public Zhaopingjihuabiao idchaxun(int zhb) {
        Zhaopingjihuabiao zhaopingjihuabiao=zhaopingjihuabiaoDao.findZpjhById(zhb);
        return zhaopingjihuabiao;
    }

    @Override
    public Zhaopingjihuabiao updataZpjh(Zhaopingjihuabiao zhaopingjihuabiao) {

             int count=   zhaopingjihuabiaoDao.updateZpjh(zhaopingjihuabiao);
        return zhaopingjihuabiao;

    }



    @Override
    public List<zpjhVo> zhaoppxxp() {
        return zpjhVoDao.zhaoppxxp();
    }

}
