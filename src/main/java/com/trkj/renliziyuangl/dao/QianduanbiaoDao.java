package com.trkj.renliziyuangl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.renliziyuangl.pojo.Qianduanbiao;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface QianduanbiaoDao extends BaseMapper<Qianduanbiao> {
    IPage<Qianduanbiao> findallqd(Page page, String cxtj);
}