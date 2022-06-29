package com.trkj.renliziyuangl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.renliziyuangl.pojo.Shenghebiao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShenghebiaoDao extends BaseMapper<Shenghebiao> {

    IPage<Shenghebiao> findallshenhe(Page page, @Param("shname") String shname);
    List<Shenghebiao> shenheneir();
}