package com.trkj.renliziyuangl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.renliziyuangl.pojo.Quanxianbiao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QuanxianbiaoDao extends BaseMapper<Quanxianbiao> {
        List<Quanxianbiao> injsidfindqxs(int jsid);
        int insertjiaoseqx(@Param("jsid") int jsid,@Param("qxid") int qxid);
        int deletejiaoseqx(@Param("jsid") int jsid,@Param("qxid") int qxid);
}