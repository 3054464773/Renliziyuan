package com.trkj.renliziyuangl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.dao.UsersssDao;
import com.trkj.renliziyuangl.vo.usersssVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class usersVolmpl implements UsersVoService {
    @Autowired
    private UsersssDao userssssdao;

    @Override
    public PageInfo<usersssVo> mohuchaxunygg(int pageNum,int pageSize,String rzname,String rzsex) {
        PageHelper.startPage(pageNum,pageSize);
        List<usersssVo> list=userssssdao.mohuchaxunygg(rzname,rzsex);
        System.out.println("2222222222222Service");
        PageInfo info=new PageInfo<>(list);
        return info;
    }
    @Override
    public PageInfo<usersssVo> mohuchaxunyghmd(int pageNum,int pageSize,String rzname,String rzsex){
        PageHelper.startPage(pageNum,pageSize);
        List<usersssVo> list=userssssdao.mohuchaxunyghmd(rzname,rzsex);
        PageInfo info=new PageInfo<>(list);
        System.out.println("2222222222222Service");
        return info;
    }

    @Override
    public PageInfo<usersssVo> mohuchaxunyglz(int pageNum,int pageSize,String rzname,String rzsex) {
        PageHelper.startPage(pageNum,pageSize);
        List<usersssVo> list=userssssdao.mohuchaxunyglz(rzname,rzsex);
        System.out.println("2222222222222Service");
        PageInfo info=new PageInfo<>(list);
        return info;
    }

    @Override
    public PageInfo<usersssVo> mohuchaxunygwbd(int pageNum,int pageSize,String rzname,String rzsex){
        PageHelper.startPage(pageNum,pageSize);
        List<usersssVo> list=userssssdao.mohuchaxunygwbd(rzname,rzsex);
        System.out.println("2222222222222Service");
        PageInfo info=new PageInfo<>(list);
        return info;
    }
    @Override
    public PageInfo<usersssVo> mohuchaxunygsx(int pageNum,int pageSize,String rzname,String rzsex){
        PageHelper.startPage(pageNum,pageSize);
        List<usersssVo> list=userssssdao.mohuchaxunygsx(rzname,rzsex);
        System.out.println("2222222222222Service");
        PageInfo info=new PageInfo<>(list);
        return info;
    }

}

