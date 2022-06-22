package com.trkj.renliziyuangl.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.pojo.Mianshiguizhanbiao;
import com.trkj.renliziyuangl.pojo.Mianshiguizhanzibiao;
import com.trkj.renliziyuangl.vo.GuizhanVo;
import com.trkj.renliziyuangl.vo.MianshigzVo;
import com.trkj.renliziyuangl.vo.zpjhVo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface MianshiguizhangService {
    public PageInfo<Mianshiguizhanbiao> mianshiguizhang(int pageNum,int pageSize);
    public PageInfo<GuizhanVo> mohuchaxunguiz(int pageNum,int pageSize,String mmc);
    //双表添加
    public int insetmsgz(MianshigzVo mianshigzVo);
    public List<Mianshiguizhanbiao> guizhangzhiwei();
    PageInfo<GuizhanVo> bumenguiz(int pageNum,int pageSize,String bmmc);
    //根据部门查询
    PageInfo<zpjhVo>   bumenzpjh(int pageNum,int pageSize,String bmmc);
    //根据招聘计划名称查询
    PageInfo<zpjhVo> mohuzpjh(int pageNum, int pageSize,String zmc);

//    int xiugai(Mianshiguizhanzibiao mianshiguizhanzibiao);
}
