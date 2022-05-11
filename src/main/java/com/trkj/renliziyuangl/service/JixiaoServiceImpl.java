package com.trkj.renliziyuangl.service;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.dao.JixiaobiaoDao;
import com.trkj.renliziyuangl.exception.CustomError;
import com.trkj.renliziyuangl.exception.CustomErrorType;
import com.trkj.renliziyuangl.pojo.Jixiaobiao;
import com.trkj.renliziyuangl.pojo.Jixiaopinfenbiao;
import com.trkj.renliziyuangl.vo.gradeVo;
import com.trkj.renliziyuangl.vo.scoreVo;
import com.trkj.renliziyuangl.vo.sheetVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JixiaoServiceImpl implements JixiaoService {
    @Autowired
    private JixiaobiaoDao dao;

    //查询全部绩效名称
    @Override
    public PageInfo<Jixiaobiao> findJixiao(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Jixiaobiao> list=dao.findJixiao();
        PageInfo<Jixiaobiao> pageInfo=new PageInfo<>(list);
        System.out.println(pageInfo);
        return pageInfo;
    }

    //添加绩效名称
    @Override
    public Jixiaobiao insertJixiao(Jixiaobiao vo){
        int count=dao.insert(vo);
        if (count==0){
            throw new CustomError(CustomErrorType. SYSTEM_ERROR,"数据插入异常");

        }
        return vo;
    }

    //修改绩效信息
    @Override
    public Jixiaobiao updateJixiao(Jixiaobiao vo) {
        System.out.println("updateJixiao.....................");
        int count=dao.update(vo);
        if(count==0){
            throw new CustomError(CustomErrorType.SYSTEM_ERROR,"数据更新异常");
        }
        return vo;
    }

    //根据编号查绩效内容
    @Override
    public Jixiaobiao findJixiaoById(int jbh) {
        Jixiaobiao entity=dao.findJixiaoById(jbh);
        return entity;
    }

    //删除绩效名称
    @Override
    public int deleteJixiao(int jbh) {
        return dao.deleteJixiao(jbh);
    }

    //plus模糊查询
    @Override
    public Map findJixiaoByName(int num, String jmc) {
        Page<Jixiaobiao> page=new Page<>(num,5);
        LambdaQueryWrapper<Jixiaobiao> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.like(Jixiaobiao::getJmc,jmc);
        Page<Jixiaobiao> page2=dao.selectPage(page,queryWrapper);
        Map map=new HashMap<>();
        map.put("list",page2.getRecords());
        map.put("count",page2.getPages());
        System.out.println(map+"============================");
        return map;
    }

    //查询绩效评分
    @Override
    public PageInfo<gradeVo> findGrade(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<gradeVo> list=dao.findGrade();
        System.out.println(list+"========================");
        PageInfo<gradeVo> pageInfo=new PageInfo<>(list);

        return pageInfo;
    }

    //修改绩效评分
    @Override
    public gradeVo updateGrade(gradeVo grade) {
        int count=dao.updateGrade(grade);
        int count2=dao.updateScore2(grade);//改评分定级信息 更新月报
        System.out.println(grade.getJdfs()+"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        if(count==0 || count2==0){
            throw new CustomError(CustomErrorType.SYSTEM_ERROR,"数据更新异常");
        }
        return grade;
    }

    //根据编号查单条数据详情
    @Override
    public gradeVo findGradeById(int jbh) {
        gradeVo vo=dao.findGradeById(jbh);
        System.out.println(vo.getJbh()+"====================================");
        return vo;
    }

    //根据编号删除评分
    @Override
    public int deleteGrade(int jxbh) {
        return dao.deleteGrade(jxbh);
    }

    //条件查询
    @Override
    public PageInfo<gradeVo> findGradeByName(int pageNum,int pageSize,String rzname) {
        PageHelper.startPage(pageNum,pageSize);
        List<gradeVo> list=dao.findGradeByName(rzname);
        PageInfo info=new PageInfo<>(list);
        return info;
    }

    @Override
    public List<scoreVo> findAllScore() {
        return dao.findAllScore();
    }

    //月报统计
    @Override
    public List<scoreVo> findAllScoreByBmbh(int bmbh) {

        return dao.findAllScoreByBmbh(bmbh);

    }

}
