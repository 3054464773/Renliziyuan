package com.trkj.renliziyuangl.service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.dao.RencaibiaoDao;
import com.trkj.renliziyuangl.dao.RencaizibiaoDao;
import com.trkj.renliziyuangl.pojo.Rencaibiao;
import com.trkj.renliziyuangl.pojo.Rencaizibiao;

import com.trkj.renliziyuangl.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecruitServicelmpl implements RecruitService {
    @Autowired
    private RencaizibiaoDao recruitDao;
    @Autowired
    private RencaibiaoDao rencaibiaoDao;
    @Override
    public PageInfo<Rencaizibiao> selectRecruit(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Rencaizibiao> list=recruitDao.selectRecruit();
        PageInfo<Rencaizibiao> recruitPageInfo = new PageInfo<>(list);
        System.out.println(recruitPageInfo);
        return recruitPageInfo;
    }
//根据id查询
    @Override
    public Rencaizibiao selectid(int rzbh) {
        Rencaizibiao selectid = recruitDao.selectid(rzbh);

        return selectid;

    }
//修改
    @Override
    public Rencaizibiao updataRecruit(Rencaizibiao rzbh) {
        int rencaizibiao = recruitDao.updataRecruit(rzbh);
        return rzbh;
    }


    //删除
    @Override
    public int deleteById(int rzbh) {
        return  recruitDao.deleteById(rzbh);

    }

    @Override
    public Rencaizibiao insertRecruit(Rencaizibiao rencaizibiao) {
       recruitDao.insertRecruit(rencaizibiao);
        return rencaizibiao;
    }

    @Override
    public Map mohuRencaizibiao(int ym,String rzname) {
        Page<Rencaizibiao> page=new Page<>(ym,4);
        LambdaQueryWrapper<Rencaizibiao> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Rencaizibiao::getRzname,rzname);
        Page<Rencaizibiao> page1=recruitDao.selectPage(page,lambdaQueryWrapper);
        Map map=new HashMap();
        map.put("list",page1.getRecords());
        map.put("xxx",page1.getPages());
        return map;
    }

    @Override
    public PageInfo<rencaiVo> selectMs(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<rencaiVo> list=recruitDao.selectMs();
        PageInfo<rencaiVo> recruitPageInfo = new PageInfo<>(list);
        System.out.println(recruitPageInfo);
        return recruitPageInfo;
    }

    @Override
    public PageInfo<rencaiVo> selectMss(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<rencaiVo> list=recruitDao.selectMss();
        PageInfo<rencaiVo> recruitPageInfo = new PageInfo<>(list);
        System.out.println(recruitPageInfo);
        return recruitPageInfo;
    }
//面试
    @Override
    public PageInfo<ZpVo> selectMsss(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<ZpVo> list=recruitDao.selectMsss();

        PageInfo<ZpVo> recruitPageInfo = new PageInfo<>(list);

        return recruitPageInfo;
    }
//双表添加
    @Override
    public int insersyygg(rencaiVo rencaiVo) {
        Rencaizibiao a=new Rencaizibiao();
        a.setRzbh(rencaiVo.getRzbh());
        a.setRzname(rencaiVo.getRzname());
        a.setRzsex(rencaiVo.getRzsex());
        a.setRzage(rencaiVo.getRzage());
        a.setRzsfz(rencaiVo.getRzsfz());
        a.setRzphone(rencaiVo.getRzphone());
        a.setRzdz(rencaiVo.getRzdz());
        a.setRzmz(rencaiVo.getRzmz());
        a.setRzxl(rencaiVo.getRzxl());
        a.setRzcsrq(rencaiVo.getRzcsrq());
        a.setRzgzjl(rencaiVo.getRzgzjl());
        a.setRzhyzk(rencaiVo.getRzhyzk());
        a.setRzzzmm(rencaiVo.getRzzzmm());
        a.setImg(rencaiVo.getImg());
        int inset1=recruitDao.insert(a);
        Rencaibiao rencaibiao=new Rencaibiao();
        rencaibiao.setRid(rencaiVo.getRid());
        rencaibiao.setRzt(1);
        rencaibiao.setRsj(new Date());
        rencaibiao.setZwbh(rencaiVo.getZwbh());
        rencaibiao.setRsf(rencaiVo.getRsf());
        rencaibiao.setYbh(rencaiVo.getYbh());
        rencaibiao.setRzbh(a.getRzbh());
        int inset2=rencaibiaoDao.insert(rencaibiao);
        return 1;
    }

    @Override
    public PageInfo<MianshijiluVo> miianshi(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<MianshijiluVo> list=recruitDao.mianshijilu();
        PageInfo<MianshijiluVo> recruitPageInfo = new PageInfo<>(list);
        System.out.println(recruitPageInfo);
        return recruitPageInfo;
    }

    @Override
    public PageInfo<JixiaojiluVo> jixiao(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<JixiaojiluVo> list=recruitDao.jixiaojilu();
        PageInfo<JixiaojiluVo> recruitPageInfo = new PageInfo<>(list);
        System.out.println(recruitPageInfo);
        return recruitPageInfo;

    }

    @Override
    public PageInfo<KaoqinjiluVo> kaoqin(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<KaoqinjiluVo> list=recruitDao.kaoqin();
        PageInfo<KaoqinjiluVo> recruitPageInfo = new PageInfo<>(list);
        System.out.println(recruitPageInfo);
        return recruitPageInfo;
    }
//出差记录
    @Override
    public PageInfo<Chuchaivo> chuchaijjll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Chuchaivo> list=recruitDao.chuchaijjll();
        PageInfo<Chuchaivo> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }
}
