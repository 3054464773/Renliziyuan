package com.trkj.renliziyuangl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.renliziyuangl.pojo.Shebaofananbiao;
import com.trkj.renliziyuangl.pojo.Shebaojishubiao;
import com.trkj.renliziyuangl.vo.canbaoryVo;
import com.trkj.renliziyuangl.vo.ShebaofaVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShebaofananbiaoDao extends BaseMapper<Shebaofananbiao> {
    //查询社保方案
    List cxshebaofangan(Shebaofananbiao sbfa);
    //查询所有社保方案(具体)
    List<ShebaofaVo> selectsbfa(int sbbh);
    //根据方案id或名称模糊查询社保方案信息
    List<Shebaofananbiao> cxfaByIdAndName(String sbmc);
    //查询社保基数表信息
    List selectsbjsxx(Shebaojishubiao sbjsb);
    //删除社保方案
    int deletesbfaxx(int sbbh);
    //查询参保人员信息
    List cxcanbaorenyuan(canbaoryVo sbryvo);
}