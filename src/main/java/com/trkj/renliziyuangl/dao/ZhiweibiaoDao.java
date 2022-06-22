package com.trkj.renliziyuangl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.renliziyuangl.pojo.Zhiweibiao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ZhiweibiaoDao extends BaseMapper<Zhiweibiao> {
    public List<Zhiweibiao> zhiwei();
    @Select("SELECT zwbh,zwmc FROM zhiweibiao")
    List<Zhiweibiao> zhiweiqc();
}