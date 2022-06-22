package com.trkj.renliziyuangl.service;

import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.vo.ZpVo;



public interface MohudicimianshiServce {
    public PageInfo<ZpVo> mohudiyici(int pageNum,int pageSize,String rzname);
}
