package com.trkj.renliziyuangl.service;


import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.pojo.Rencaizibiao;
import com.trkj.renliziyuangl.vo.rencaiVo;


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
    public PageInfo<rencaiVo> selectMsss(int pageNum, int pageSize);


}
