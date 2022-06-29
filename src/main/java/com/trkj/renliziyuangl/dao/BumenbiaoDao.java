package com.trkj.renliziyuangl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.renliziyuangl.pojo.Bumenbiao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BumenbiaoDao extends BaseMapper<Bumenbiao> {
    public List<Bumenbiao> bumen();
    public List<Bumenbiao> bububumen();
    public List<Bumenbiao> bumenmmm();


}