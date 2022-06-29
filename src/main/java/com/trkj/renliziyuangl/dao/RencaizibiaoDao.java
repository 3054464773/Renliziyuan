package com.trkj.renliziyuangl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.renliziyuangl.pojo.Rencaizibiao;
import com.trkj.renliziyuangl.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RencaizibiaoDao extends BaseMapper<Rencaizibiao> {
    public List<Rencaizibiao> selectRecruit();
    //预约面试
    public List<rencaiVo> selectMs();
    //面试官
    public List<rencaiVo> mianshiguan(int rid);
    public List<rencaiVo> mianshiguaneee();
   //没有的第一次面试
    public List<rencaiVo> selectMss();
    //第一次面试
    public List<ZpVo> selectMsss();
//根据id查询
    public rencaiVo selectid(int rzbh);
    //修改
    public int updataRecruit(Rencaizibiao rencaizibiao);
    //新增
    public int insertRecruit(Rencaizibiao rencaizibiao);
    //查询面试记录
    public List<MianshijiluVo> mianshijilu(int ybh);
    //查询绩效记录
    public List<JixiaojiluVo> jixiaojilu(int ybh);
    //查询考勤记录
    public List<KaoqinjiluVo> kaoqin(int ybh);
    //查询出差记录
    public List<Chuchaivo> chuchaijjll(int ybh);

    @Select("select count(*) mscs from mianshijilubiao WHERE rid=#{rid}")
    ZpVo selZp(@Param("rid") int rid);
}