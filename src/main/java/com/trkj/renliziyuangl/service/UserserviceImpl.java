package com.trkj.renliziyuangl.service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.dao.YuangongbiaoDao;
import com.trkj.renliziyuangl.pojo.Yuangongbiao;
import com.trkj.renliziyuangl.vo.UsersXinZiVo;
import com.trkj.renliziyuangl.vo.usersssVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserserviceImpl implements Userservice {
    @Autowired
    private YuangongbiaoDao userDao;
//根据id查找
    @Override
    public Yuangongbiao findUserById(int ybh) {
        Yuangongbiao userentity = userDao.findUserById(ybh);
        return userentity;
    }
//分页以及查询所有
    @Override
    public PageInfo<Yuangongbiao> findusers(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Yuangongbiao> list = userDao.findusers();
        PageInfo<Yuangongbiao> pageInfo = new PageInfo<>(list);
        System.out.println(pageInfo);
        return pageInfo;
    }

//修改
    @Override
    public Yuangongbiao updateUser(Yuangongbiao userVo) {
        int count=userDao.updateUser(userVo);
        return userVo;
    }

//根据id删除
    @Override
    public int deleteById(int ybh) {
        return   userDao.deleteById(ybh);
    }
//添加
    @Override
    public Yuangongbiao insersUsers(Yuangongbiao userVo) {
        userDao.insersUsers(userVo);

        return userVo;
    }

    @Override
    public PageInfo<usersssVo> finduserssss(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<usersssVo> list = userDao.finduserssss();
        PageInfo<usersssVo> pageInfo = new PageInfo<>(list);
        System.out.println(pageInfo);
        return pageInfo;
    }
    //多表查询以及分页
    @Override
    public PageInfo<UsersXinZiVo> findxinzi(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<UsersXinZiVo> list=userDao.findxinzi();
        PageInfo<UsersXinZiVo> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }
    //多表查询以及分页
    @Override
    public PageInfo<usersssVo> findusershmd(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<usersssVo> list=userDao.findusershmd();
        PageInfo<usersssVo> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }
//多表查询以及分页
    @Override
    public PageInfo<usersssVo> findwdg(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<usersssVo> list=userDao.findwdg();
        PageInfo<usersssVo> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<usersssVo> finduserslz(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<usersssVo> list=userDao.finduserslz();
        PageInfo<usersssVo> pageInfo=new PageInfo<>(list);
        return  pageInfo;
    }

    //修改员工状态
    @Override
    public int xiugairuzhi(int ybh) {
        System.out.println("55555555"+ybh);
    return   userDao.xiugairuzhi(ybh);
    }


}