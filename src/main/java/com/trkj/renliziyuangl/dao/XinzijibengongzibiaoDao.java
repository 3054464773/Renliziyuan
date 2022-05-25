package com.trkj.renliziyuangl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.renliziyuangl.pojo.Xinzijibengongzibiao;
import com.trkj.renliziyuangl.vo.basePay;
import com.trkj.renliziyuangl.vo.job;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface XinzijibengongzibiaoDao extends BaseMapper<Xinzijibengongzibiao> {
    List<basePay> findAllBasePay();//查询所有员工 所属部门 基本工资
    List<basePay> findAllBasePayByName(String rzname);
    List<job> findAllPositionSalary();
    List<job> findAllPositionSalaryByZwmc(String zwmc);
    job selectPositionSalaryByXzjbbh(int xzjbbh);
    int updatePositionSalaryByXzjbbh(job vo);
}