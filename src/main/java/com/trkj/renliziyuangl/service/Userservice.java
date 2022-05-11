package com.trkj.renliziyuangl.service;

import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.pojo.Yuangongbiao;
import com.trkj.renliziyuangl.vo.UsersXinZiVo;
import com.trkj.renliziyuangl.vo.usersssVo;

import java.util.Map;


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

    //分页以及查询所有
    public PageInfo<usersssVo> finduserssss(int pageNum, int pageSize);
  //分页查询员工基本工资
    public  PageInfo<UsersXinZiVo> findxinzi(int pageNum,int pageSize);
    //员工黑名单
    public  PageInfo<usersssVo> findusershmd(int pageNum,int pageSize);
    //员工未到岗
    public  PageInfo<usersssVo> findwdg(int pageNum,int pageSize);
    //员工离职
    public PageInfo<usersssVo> finduserslz(int pageNum,int pageSize);

  //修改员工状态
    public int xiugairuzhi(int ybh);
}
