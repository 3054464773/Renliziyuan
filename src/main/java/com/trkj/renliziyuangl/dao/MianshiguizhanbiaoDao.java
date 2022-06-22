package com.trkj.renliziyuangl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.renliziyuangl.pojo.Mianshiguizhanbiao;
import com.trkj.renliziyuangl.vo.GuizhanVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MianshiguizhanbiaoDao extends BaseMapper<Mianshiguizhanbiao> {
    public List<Mianshiguizhanbiao> mianshiguizhang();
    public List<Mianshiguizhanbiao> guizhangzhiwei();




}