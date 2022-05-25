package com.trkj.renliziyuangl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.renliziyuangl.pojo.Mianshiguizhanzibiao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MianshiguizhanzibiaoDao extends BaseMapper<Mianshiguizhanzibiao> {
    //面试规章子表
    public List<Mianshiguizhanzibiao> mianshizi(int mbh);
    //预约面试，面试记录
    public List<Mianshiguizhanzibiao> mianshiwenti(@Param("zwbh") int zwbh,@Param("rid") int rid);
    //判断面试次数
    public List<Mianshiguizhanzibiao> mianshiwentit(@Param("zwbh") int zwbh,@Param("rid") int rid);
    public int xiugaigzz(Mianshiguizhanzibiao mianshiguizhanzibiao);



}