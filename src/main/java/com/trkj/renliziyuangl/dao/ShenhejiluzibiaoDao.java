package com.trkj.renliziyuangl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.renliziyuangl.pojo.Shenhejiluzibiao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShenhejiluzibiaoDao extends BaseMapper<Shenhejiluzibiao> {

    IPage<Shenhejiluzibiao> findshenhegz(Page page,@Param("js") String js);
}