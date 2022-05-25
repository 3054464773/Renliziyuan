package com.trkj.renliziyuangl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.renliziyuangl.pojo.Jixiaobiao;
import com.trkj.renliziyuangl.vo.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JixiaobiaoDao extends BaseMapper<Jixiaobiao>{
    //绩效名称
    public List<Jixiaobiao> findJixiao();//查询全部绩效名称
    public int insert(Jixiaobiao entity);//添加绩效名称
    public int update(Jixiaobiao entity);//修改绩效信息
    public Jixiaobiao findJixiaoById(int jbh);//根据编号查绩效内容
    public int deleteJixiao(int jbh);//删除绩效名称

    //绩效评分
    public List<gradeVo> findGrade();//查询绩效评分
    public List<grade2Vo> findGrade2();//查询未评分的员工
    public List<grade2Vo> findGrade2ByName(String rzname);//根据名称查询未评分的员工
    public grade2Vo findGradeByJxbh(int jxbh);//拿评分编号
    public int updataGradePf(grade2Vo vo);//给员工评分
    public int updataGradeDj(grade2Vo vo);//给员工评分
    public int updateGrade(gradeVo grade);//修改绩效评分
    public int updateScore2(gradeVo grade);//改评分定级信息 更新月报
    public gradeVo findGradeById(int jbh);//根据编号查单条数据详情
    public int deleteGrade(int jxbh);
    public List<gradeVo> findGradeByName(String rzname);

    //绩效定级
    public List<scoreVo> findAllScore();//查询公司所有员工的绩效月报
    public List<scoreVo> findAllScoreByBmbh(int bmbh);//根据部门编号查询某个部门的绩效月报
}
