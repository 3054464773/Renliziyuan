package com.trkj.renliziyuangl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.renliziyuangl.pojo.Rencaibiao;
import com.trkj.renliziyuangl.vo.interviewVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface RencaibiaoDao extends BaseMapper<Rencaibiao> {
    //多表查询
    public List<interviewVo> selecd();
    //查询表所有
    public List<Rencaibiao> selecdrencai();
    //修改状态为应聘中
    public int xiugaizt(int rid);
    //修改状态为已应聘
    public int xiugaiztt(int rid);



}