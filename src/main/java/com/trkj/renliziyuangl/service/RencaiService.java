package com.trkj.renliziyuangl.service;

import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.pojo.Rencaibiao;
import com.trkj.renliziyuangl.vo.interviewVo;


public interface RencaiService {
    public PageInfo<interviewVo> selecd(int pageNum, int pageSize);
    public PageInfo<Rencaibiao> selecdrencai(int pageNum,int pageSize);
}
