package com.trkj.renliziyuangl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.dao.XinziyaosuxiangbiaoDao;
import com.trkj.renliziyuangl.exception.CustomError;
import com.trkj.renliziyuangl.exception.CustomErrorType;
import com.trkj.renliziyuangl.pojo.Xinziyaosuxiangbiao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class salaryElementServiceImpl implements salaryElementService {

    @Autowired
    private XinziyaosuxiangbiaoDao dao;

    @Override
    public PageInfo<Xinziyaosuxiangbiao> findAllSalaryElement(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Xinziyaosuxiangbiao> list=dao.findAllSalaryElement();
        PageInfo<Xinziyaosuxiangbiao> info=new PageInfo<>(list);
        return info;
    }

    @Override
    public Xinziyaosuxiangbiao insertSalaryElement(Xinziyaosuxiangbiao vo) {
        int count=dao.insertSalaryElement(vo);
        if(count==0){
            throw new CustomError(CustomErrorType.SYSTEM_ERROR,"添加要素项失败！");
        }
        return vo;
    }

    @Override
    public Xinziyaosuxiangbiao updateSalaryElement(Xinziyaosuxiangbiao vo) {
        int count=dao.updateSalaryElement(vo);
        if (count==0){
            throw new CustomError(CustomErrorType.SYSTEM_ERROR,"数据更新异常");
        }
        return vo;
    }

    @Override
    public Xinziyaosuxiangbiao findSalaryElementByYsbh(int xzysbh) {
        System.out.println("++++++++++++++++++++++++++++++++++++++");
        return dao.findSalaryElementByYsbh(xzysbh);
    }

    @Override
    public PageInfo<Xinziyaosuxiangbiao> findSalaryElementByYsmc(int pageNum, int pageSize, String xzysmc) {
        PageHelper.startPage(pageNum,pageSize);
        List<Xinziyaosuxiangbiao> list=dao.findSalaryElementByYsmc(xzysmc);
        PageInfo<Xinziyaosuxiangbiao> info=new PageInfo<>(list);
        return info;
    }

    @Override
    public int deleteSalaryElementByYsbh(int xzysbh) {
        return dao.deleteSalaryElementByYsbh(xzysbh);
    }
}
