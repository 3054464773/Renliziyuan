package com.trkj.renliziyuangl.service;

import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.vo.rencaiVo;

import java.util.List;

public interface MohuJianliService {
    public PageInfo<rencaiVo> mohujianli(int pageNum,int pageSize,String rzname);
}
