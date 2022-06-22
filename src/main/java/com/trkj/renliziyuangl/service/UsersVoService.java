package com.trkj.renliziyuangl.service;

import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.vo.usersssVo;

import java.util.List;


public interface UsersVoService {
    //模糊查询根据姓名
    public PageInfo<usersssVo> mohuchaxunygg(int pageNum,int pageSize,String rzname,String rzsex);
    public PageInfo<usersssVo> mohuchaxunyghmd(int pageNum,int pageSize,String rzname,String rzsex);
    public PageInfo<usersssVo> mohuchaxunyglz(int pageNum,int pageSize,String rzname,String rzsex);
    public PageInfo<usersssVo> mohuchaxunygwbd(int pageNum,int pageSize,String rzname,String rzsex);
    public PageInfo<usersssVo> mohuchaxunygsx(int pageNum,int pageSize,String rzname,String rzsex);


}
