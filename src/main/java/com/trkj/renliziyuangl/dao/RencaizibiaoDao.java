package com.trkj.renliziyuangl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.renliziyuangl.pojo.Rencaizibiao;
import com.trkj.renliziyuangl.vo.rencaiVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RencaizibiaoDao extends BaseMapper<Rencaizibiao> {
    public List<Rencaizibiao> selectRecruit();
    public List<rencaiVo> selectMs();
    public List<rencaiVo> selectMss();
    public List<rencaiVo> selectMsss();

    public Rencaizibiao selectid(int rzbh);
    public int updataRecruit(Rencaizibiao rencaizibiao);
    public int insertRecruit(Rencaizibiao rencaizibiao);
}