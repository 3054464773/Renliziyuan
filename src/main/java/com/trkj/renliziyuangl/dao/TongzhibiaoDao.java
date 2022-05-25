package com.trkj.renliziyuangl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.renliziyuangl.pojo.Bumenbiao;
import com.trkj.renliziyuangl.pojo.Tongzhibiao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TongzhibiaoDao extends BaseMapper<Tongzhibiao> {

        int inygidfindbmid(int ygid);
        IPage<Tongzhibiao> inygidfindtz(Page<Tongzhibiao>page,@Param("ygid") int ygid,@Param("pdtj") int pdtj,@Param("sstj") String sstj);
}