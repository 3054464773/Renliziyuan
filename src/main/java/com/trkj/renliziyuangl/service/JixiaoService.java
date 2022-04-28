package com.trkj.renliziyuangl.service;

import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.pojo.Jixiaobiao;

public interface JixiaoService {

    public PageInfo<Jixiaobiao> findJixiao(int pageNum, int pageSize);
    public Jixiaobiao insertJixiao(Jixiaobiao vo);
    public Jixiaobiao updateJixiao(Jixiaobiao vo);
    public Jixiaobiao findJixiaoById(int jbh);
    public int deleteJixiao(int jbh);
}
