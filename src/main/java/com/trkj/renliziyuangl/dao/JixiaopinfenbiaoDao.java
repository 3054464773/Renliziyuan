package com.trkj.renliziyuangl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.renliziyuangl.pojo.Jixiaopinfenbiao;
import com.trkj.renliziyuangl.vo.empVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JixiaopinfenbiaoDao extends BaseMapper<Jixiaopinfenbiao>{

    List<empVo> findAllEmp();//查询员工列表
    List<empVo> findAllEmpByName(String rzname);//根据名称模糊查询
}