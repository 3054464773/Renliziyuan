package com.trkj.renliziyuangl.service;

import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.pojo.Jixiaobiao;
import com.trkj.renliziyuangl.pojo.Jixiaopinfenbiao;
import com.trkj.renliziyuangl.vo.gradeVo;
import com.trkj.renliziyuangl.vo.scoreVo;
import com.trkj.renliziyuangl.vo.sheetVo;

import java.util.List;
import java.util.Map;

public interface JixiaoService {

    public PageInfo<Jixiaobiao> findJixiao(int pageNum, int pageSize);//查询全部绩效名称
    public Jixiaobiao insertJixiao(Jixiaobiao vo);//添加绩效名称
    public Jixiaobiao updateJixiao(Jixiaobiao vo);//修改绩效信息
    public Jixiaobiao findJixiaoById(int jbh);//根据编号查绩效内容
    public int deleteJixiao(int jbh);//删除绩效名称
    public Map findJixiaoByName(int num, String jmc);//plus模糊查询

    public PageInfo<gradeVo> findGrade(int pageNum, int PageSize);//查询绩效评分
    public Jixiaopinfenbiao updateGrade(Jixiaopinfenbiao grade);//修改绩效评分
    public sheetVo updateScore(sheetVo grade);//改一张表信息 同时更新另外一张表
    public gradeVo findGradeById(int jbh);//根据编号查单条数据详情
    public int deleteGrade(int jxbh);//根据编号删除评分
    public PageInfo<gradeVo> findGradeByName(int pageNum,int pageSize,String rzname);//条件查询

    public List<scoreVo> findAllScore();//月报统计


}
