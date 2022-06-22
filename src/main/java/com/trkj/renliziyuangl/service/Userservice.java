package com.trkj.renliziyuangl.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.pojo.Yuangongbiao;
import com.trkj.renliziyuangl.pojo.Yuangonggzjlbiao;
import com.trkj.renliziyuangl.vo.UsersXinZiVo;
import com.trkj.renliziyuangl.vo.ZpVo;
import com.trkj.renliziyuangl.vo.usersssVo;

import java.util.Date;
import java.util.List;
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
    public PageInfo<usersssVo> findusersx(int pageNum, int pageSize);

  //分页查询员工基本工资
    public List<UsersXinZiVo> findxinzi(int ybh);
    //员工黑名单
    public  PageInfo<usersssVo> findusershmd(int pageNum,int pageSize);
    //员工未到岗
    public  PageInfo<usersssVo> findwdg(int pageNum,int pageSize);
    //员工离职
    public PageInfo<usersssVo> finduserslz(int pageNum,int pageSize);
  //员工入职时间查询
    public PageInfo<usersssVo> ruzhishijian(int pageNum, int pageSize,String ygrzsj);
    public PageInfo<usersssVo> ruzhishijianhmd(int pageNum, int pageSize,String ygrzsj);
    public PageInfo<usersssVo> ruzhishijianlz(int pageNum, int pageSize,String ygrzsj);
    public PageInfo<usersssVo> ruzhishijiansx(int pageNum, int pageSize,String ygrzsj);

  //修改员工状态
    public int xiugairuzhi(int ybh);
    //通过面试添加员工
    public int rzyg(ZpVo zpVo);
    //根据部门查询
    PageInfo<usersssVo> bumenchauxn(int pageNum,int pageSize,String bmmc);
    PageInfo<usersssVo> bumenchauxnhmd(int pageNum,int pageSize,String bmmc);
    PageInfo<usersssVo> bumenchauxnlz(int pageNum,int pageSize,String bmmc);
    PageInfo<usersssVo> bumenchauxwbd(int pageNum,int pageSize,String bmmc);
    PageInfo<usersssVo> bumenchauxsx(int pageNum,int pageSize,String bmmc);
    //员工转正申请
    public int zzsq(Yuangonggzjlbiao yuangonggzjlbiao);

}
