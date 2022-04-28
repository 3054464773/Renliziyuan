package com.trkj.renliziyuangl.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.dao.JixiaobiaoDao;
import com.trkj.renliziyuangl.exception.CustomError;
import com.trkj.renliziyuangl.exception.CustomErrorType;
import com.trkj.renliziyuangl.pojo.Jixiaobiao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JixiaoServiceImpl implements JixiaoService {
    @Autowired
    private JixiaobiaoDao dao;

    @Override
    public PageInfo<Jixiaobiao> findJixiao(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Jixiaobiao> list=dao.findJixiao();
        PageInfo<Jixiaobiao> pageInfo=new PageInfo<>(list);
        System.out.println(pageInfo);
        return pageInfo;
    }

    @Override
    public Jixiaobiao insertJixiao(Jixiaobiao vo){
        int count=dao.insert(vo);
        if (count==0){
            throw new CustomError(CustomErrorType. SYSTEM_ERROR,"数据插入异常");

        }
        return vo;
    }

    @Override
    public Jixiaobiao updateJixiao(Jixiaobiao vo) {
        System.out.println("updateJixiao.....................");
        int count=dao.update(vo);
        if(count==0){
            throw new CustomError(CustomErrorType.SYSTEM_ERROR,"数据更新异常");
        }
        return vo;
    }

    @Override
    public Jixiaobiao findJixiaoById(int jbh) {
        Jixiaobiao entity=dao.findJixiaoById(jbh);
        return entity;
    }

    @Override
    public int deleteJixiao(int jbh) {
        return dao.deleteJixiao(jbh);
    }
}
