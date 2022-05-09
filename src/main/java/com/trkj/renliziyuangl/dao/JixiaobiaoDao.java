package com.trkj.renliziyuangl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.renliziyuangl.pojo.Jixiaobiao;
import com.trkj.renliziyuangl.pojo.Jixiaopinfenbiao;
import com.trkj.renliziyuangl.vo.gradeVo;
import com.trkj.renliziyuangl.vo.scoreVo;
import com.trkj.renliziyuangl.vo.sheetVo;
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
    public int updateGrade(Jixiaopinfenbiao grade);//修改绩效评分
    public int updateScore(sheetVo grade);//改一张表信息 同时更新另外一张表
    public gradeVo findGradeById(int jbh);//根据编号查单条数据详情
    public int deleteGrade(int jxbh);
    public List<gradeVo> findGradeByName(String rzname);

    //绩效定级
    public List<scoreVo> findAllScore();

}
