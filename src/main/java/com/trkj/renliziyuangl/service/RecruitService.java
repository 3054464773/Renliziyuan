package com.trkj.renliziyuangl.service;


import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.pojo.Rencaizibiao;
import com.trkj.renliziyuangl.vo.*;


import java.util.List;
import java.util.Map;

public interface RecruitService {
    public PageInfo<Rencaizibiao> selectRecruit(int pageNum, int pageSize);
    public rencaiVo selectid(int rzbh);
    public Rencaizibiao updataRecruit(Rencaizibiao rzbh);
    public  int deleteById(int rzbh);
    public Rencaizibiao insertRecruit(Rencaizibiao rencaizibiao);
    public Map mohuRencaizibiao(int page,String rzname);
    public PageInfo<rencaiVo> selectMs(int pageNum, int pageSize);
    public PageInfo<rencaiVo> selectMss(int pageNum, int pageSize);
    public PageInfo<ZpVo> selectMsss(int pageNum, int pageSize);
    //双表添加
    public int insersyygg(rencaiVo rencaiVo);
    //导入
    public List<rencaiVo> daoru(rencaiVo rencaiVo);
     //面试记录
    public List<MianshijiluVo> miianshi(int ybh);
    //绩效记录
    public List<JixiaojiluVo> jixiao(int ybh);
    //考勤记录
    public List<KaoqinjiluVo> kaoqin(int ybh);
    //出差记录
    public List<Chuchaivo> chuchaijjll(int ybh);
    //面试官
    public List<rencaiVo> mianshiguan(int rid);
    public List<rencaiVo> mianshiguaneee();


}
