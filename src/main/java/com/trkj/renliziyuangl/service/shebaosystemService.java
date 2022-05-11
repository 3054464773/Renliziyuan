package com.trkj.renliziyuangl.service;

import com.trkj.renliziyuangl.pojo.Shebaofananbiao;
import com.trkj.renliziyuangl.pojo.Shebaojishubiao;
import com.trkj.renliziyuangl.vo.canbaoryVo;
import com.trkj.renliziyuangl.vo.ShebaofaVo;
import java.util.List;

public interface shebaosystemService {
    public List findBancb(int pageNum,int pageSize);
    //查询社保方案
    public List cxsbfa(Shebaofananbiao sbfa);
    //查询所有社保方案(具体)
    public List<ShebaofaVo> selectsbfa(int sbbh);
    //根据方案id或名称模糊查询社保方案信息
    List<Shebaofananbiao> cxsbidorname(String sbmc);
    //查询社保基数表信息
    List selectsbjsxx(Shebaojishubiao sbjsb);
    //新增社保方案
    int insertsbfa(ShebaofaVo sbvo);
    //删除社保方案
    int deletesbfa(int sbbh);
    //查询参保人员信息
    List cxcbry(canbaoryVo cbryvo);
}
