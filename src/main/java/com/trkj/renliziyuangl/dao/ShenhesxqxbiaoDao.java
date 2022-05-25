package com.trkj.renliziyuangl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.renliziyuangl.pojo.Shenhesxqxbiao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShenhesxqxbiaoDao extends BaseMapper<Shenhesxqxbiao> {

    IPage<Shenhesxqxbiao> findsxqx(Page page, @Param("shbid") int shbid);
}