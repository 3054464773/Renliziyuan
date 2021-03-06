package com.trkj.renliziyuangl.service;

import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.pojo.Zhaopingjihuabiao;
import com.trkj.renliziyuangl.vo.zpjhVo;

import java.util.List;

public interface ZpjhService {
    //分页以及查询
    public PageInfo<zpjhVo> findszpjh(int pageNum,int pageSize);
    //删除
    public int deleteById(int zhb);
    //添加
    public   Zhaopingjihuabiao tianjiazpjh(Zhaopingjihuabiao zhaopingjihuabiao);
    //根据id查询
    public Zhaopingjihuabiao idchaxun(int zhb);
    //修改
   public Zhaopingjihuabiao updataZpjh(Zhaopingjihuabiao zhaopingjihuabiao);

    List<zpjhVo> zhaoppxxp();
}
