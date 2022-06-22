package com.trkj.renliziyuangl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.renliziyuangl.pojo.Xingzijilubiao;
import com.trkj.renliziyuangl.vo.SalaryVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface XingzijilubiaoDao extends BaseMapper<Xingzijilubiao> {


    List<SalaryVo> selectEmpInfo();//工资条基本信息
   // List<SalaryVo> selectEmpKPI();//工资条绩效工资
}