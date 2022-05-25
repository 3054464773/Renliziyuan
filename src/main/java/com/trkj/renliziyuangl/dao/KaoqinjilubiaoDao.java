package com.trkj.renliziyuangl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.renliziyuangl.pojo.Kaoqinjilubiao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface KaoqinjilubiaoDao extends BaseMapper<Kaoqinjilubiao> {
        IPage<Kaoqinjilubiao> findkaoqin(Page page, @Param("rzname") String rzname, @Param("bmmc") String bmmc, @Param("dkzt") String dkzt, @Param("xzsj") String xzsj);
}