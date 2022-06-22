package com.trkj.renliziyuangl.service;

import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.pojo.Jixiaobiao;
import com.trkj.renliziyuangl.pojo.Jixiaopinfenbiao;
import com.trkj.renliziyuangl.vo.*;

import java.util.List;
import java.util.Map;

public interface JixiaoService {

    public PageInfo<Jixiaobiao> findJixiao(int pageNum, int pageSize);//查询全部绩效名称
    public Jixiaobiao insertJixiao(Jixiaobiao vo);//添加绩效名称
    public Jixiaobiao updateJixiao(Jixiaobiao vo);//修改绩效信息
    public Jixiaobiao findJixiaoById(int jbh);//根据编号查绩效内容
    public int deleteJixiao(int jbh);//删除绩效名称
    public Map findJixiaoByName(int num, String jmc);//plus模糊查询

    public PageInfo<gradeVo> findGrade(int pageNum, int pgeSize);//查询绩效评分
    PageInfo<gradeVo> findGradeByJxsj(int pageNum, int pageSize, String jxsj);
    public PageInfo<grade2Vo> findGrade2(int pageNum, int pageSize);//查询未评分的员工
    public PageInfo<grade2Vo> findGrade2ByName(int pageNum,int pageSize,String rzname);//根据名称查询未评分的员工
    public grade2Vo findGradeByJxbh(int jxbh);//拿评分编号
    public grade2Vo updataGradePf(grade2Vo vo);//给员工评分
    public gradeVo updateGrade(gradeVo grade);//修改绩效评分
    public gradeVo findGradeById(int jbh);//根据编号查单条数据详情
    public int deleteGrade(int jxbh);//根据编号删除评分
    public PageInfo<gradeVo> findGradeByName(int pageNum,int pageSize,String rzname);//条件查询

    public List<scoreVo> findAllScore();//查询公司所有员工的绩效月报
    public List<scoreVo> findAllScoreByBmbh(int bmbh);//月报统计
    List<scoreVo> findAllScoreByJxsj(String jxsj);

}
