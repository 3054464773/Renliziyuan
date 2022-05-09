package com.trkj.renliziyuangl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.renliziyuangl.pojo.Rencaibiao;
import com.trkj.renliziyuangl.vo.interviewVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface RencaibiaoDao extends BaseMapper<Rencaibiao> {
    public List<interviewVo> selecd();
    public List<Rencaibiao> selecdrencai();

}