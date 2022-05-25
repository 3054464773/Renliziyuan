package com.trkj.renliziyuangl.service;

import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.pojo.Rencaibiao;
import com.trkj.renliziyuangl.vo.interviewVo;
import com.trkj.renliziyuangl.vo.rencaiVo;


public interface RencaiService {
    public PageInfo<interviewVo> selecd(int pageNum, int pageSize);
    public PageInfo<Rencaibiao> selecdrencai(int pageNum,int pageSize);
    public int xiugaizt(int rid);
    public int xiugaiztt(int rid);
//    public int insersyygg(rencaiVo rencaiVo);


}
