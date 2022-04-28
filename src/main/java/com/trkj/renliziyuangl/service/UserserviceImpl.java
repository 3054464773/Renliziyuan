package com.trkj.renliziyuangl.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.dao.YuangongbiaoDao;
import com.trkj.renliziyuangl.exception.CustomError;
import com.trkj.renliziyuangl.exception.CustomErrorType;
import com.trkj.renliziyuangl.pojo.Yuangongbiao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
        Yuangongbiao user=new Yuangongbiao();
        int count=userDao.updateUser(user);
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
}