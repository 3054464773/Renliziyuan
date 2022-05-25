package com.trkj.renliziyuangl.service;

import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.pojo.Mianshiguizhanbiao;
import com.trkj.renliziyuangl.pojo.Mianshiguizhanzibiao;
import com.trkj.renliziyuangl.vo.MianshigzVo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface MianshiguizhangService {
    public PageInfo<Mianshiguizhanbiao> mianshiguizhang(int pageNum,int pageSize);
    public Map mohuguizhan(int page, String rzname);
    //双表添加
    public int insetmsgz(MianshigzVo mianshigzVo);
    public List<Mianshiguizhanbiao> guizhangzhiwei();


//    int xiugai(Mianshiguizhanzibiao mianshiguizhanzibiao);
}
