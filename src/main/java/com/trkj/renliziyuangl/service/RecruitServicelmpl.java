package com.trkj.renliziyuangl.service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.dao.RencaizibiaoDao;
import com.trkj.renliziyuangl.pojo.Rencaizibiao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecruitServicelmpl implements RecruitService {
    @Autowired
    private RencaizibiaoDao recruitDao;
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
}
