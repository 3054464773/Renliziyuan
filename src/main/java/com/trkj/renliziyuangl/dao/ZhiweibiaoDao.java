package com.trkj.renliziyuangl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.renliziyuangl.pojo.Zhiweibiao;
import com.trkj.renliziyuangl.vo.zwVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ZhiweibiaoDao extends BaseMapper<Zhiweibiao> {
    public List<Zhiweibiao> zhiwei();
    public List<Zhiweibiao> zhaopzhiwei(int bmbh);
    public List<Zhiweibiao> zhaopjhzhiwei(int bmbh);
    int insertzw(zwVo vo);
    @Select("SELECT zwbh,zwmc FROM zhiweibiao")
    List<Zhiweibiao> zhiweiqc();
}