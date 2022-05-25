package com.trkj.renliziyuangl.service;


import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.pojo.Rencaizibiao;
import com.trkj.renliziyuangl.vo.*;


import java.util.Map;

public interface RecruitService {
    public PageInfo<Rencaizibiao> selectRecruit(int pageNum, int pageSize);
    public Rencaizibiao selectid(int rzbh);
    public Rencaizibiao updataRecruit(Rencaizibiao rzbh);
    public  int deleteById(int rzbh);
    public Rencaizibiao insertRecruit(Rencaizibiao rencaizibiao);
    public Map mohuRencaizibiao(int page,String rzname);
    public PageInfo<rencaiVo> selectMs(int pageNum, int pageSize);
    public PageInfo<rencaiVo> selectMss(int pageNum, int pageSize);
    public PageInfo<ZpVo> selectMsss(int pageNum, int pageSize);
    //双表添加
    public int insersyygg(rencaiVo rencaiVo);
    //面试记录
    public PageInfo<MianshijiluVo> miianshi(int pageNum, int pageSize);
    //绩效记录
    public PageInfo<JixiaojiluVo> jixiao(int pageNum, int pageSize);
    //考勤记录
    public PageInfo<KaoqinjiluVo> kaoqin(int pageNum, int pageSize);
    //出差记录
    public PageInfo<Chuchaivo> chuchaijjll(int pageNum,int pageSize);

}
