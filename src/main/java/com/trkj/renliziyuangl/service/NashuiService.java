package com.trkj.renliziyuangl.service;

import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.pojo.Nashuibiao;
import java.util.List;

public interface NashuiService {
    //查询纳税信息
    PageInfo<Nashuibiao> cxnashuixx(int pageNum,int pageSize);

    //新增纳税信息
    Nashuibiao insertnashui(Nashuibiao nsb);

    //根据纳税编号查询纳税信息
    Nashuibiao cxnsxxbyid(int nsbbh);

    //模糊查询纳税信息
    List<Nashuibiao> mohucxns(String nsjnbl);

    //修改纳税信息
    int xgnashuixx(Nashuibiao nsb);

    //删除纳税信息
    int scnashuixx(int nsbbh);
}
