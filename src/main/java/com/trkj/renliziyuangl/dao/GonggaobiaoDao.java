package com.trkj.renliziyuangl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.renliziyuangl.pojo.Gonggaobiao;
import com.trkj.renliziyuangl.pojo.Tongzhibiao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GonggaobiaoDao extends BaseMapper<Gonggaobiao> {
    IPage<Gonggaobiao> findallgg(Page page,@Param("cxtj") String cxtj);
}