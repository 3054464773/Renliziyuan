package com.trkj.renliziyuangl.service;

import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.pojo.Yuangongbiao;


public interface Userservice {
    //根据id查找
    public Yuangongbiao findUserById(int ybh);
    //分页以及查询所有
    public PageInfo<Yuangongbiao> findusers(int pageNum, int pageSize);
    //修改
    public Yuangongbiao updateUser(Yuangongbiao userVo);
    //删除
    public int deleteById(int ybh);
    //添加
    public Yuangongbiao insersUsers(Yuangongbiao userVo);

}
