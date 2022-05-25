package com.trkj.renliziyuangl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.dao.XinzijibengongzibiaoDao;
import com.trkj.renliziyuangl.exception.CustomError;
import com.trkj.renliziyuangl.exception.CustomErrorType;
import com.trkj.renliziyuangl.vo.basePay;
import com.trkj.renliziyuangl.vo.job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryServiceImpl implements SalaryService {
    @Autowired
    private XinzijibengongzibiaoDao dao;

    @Override
    public PageInfo<basePay> findAllBasePay(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<basePay> list=dao.findAllBasePay();
        PageInfo<basePay> info=new PageInfo<>(list);
        return info;
    }

    @Override
    public PageInfo<basePay> findAllBasePayByName(int pageNum, int pageSize,String rzname) {
        PageHelper.startPage(pageNum,pageSize);
        List<basePay> list=dao.findAllBasePayByName(rzname);
        PageInfo<basePay> info=new PageInfo<>(list);
        System.out.println(list+"===========================================");
        return info;
    }

    @Override
    public PageInfo<job> findAllPositionSalary(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<job> list=dao.findAllPositionSalary();
        PageInfo<job> info=new PageInfo<>(list);
        System.out.println(list+"------------------------------------------------------------------------------------");
        return info;
    }

    @Override
    public PageInfo<job> findAllPositionSalaryByZwmc(int pageNum, int pageSize, String zwmc) {
        PageHelper.startPage(pageNum,pageSize);
        List<job> list=dao.findAllPositionSalaryByZwmc(zwmc);
        PageInfo<job> info=new PageInfo<>(list);
        return info;
    }

    @Override
    public job selectPositionSalaryByXzjbbh(int xzjbbh) {
        return dao.selectPositionSalaryByXzjbbh(xzjbbh);
    }

    @Override
    public job updatePositionSalaryByXzjbbh(job vo) {
        int count=dao.updatePositionSalaryByXzjbbh(vo);
        System.out.println("++++++++++++++++++++++++++++++++"+vo.toString());
        if(count==0){
            throw new CustomError(CustomErrorType.SYSTEM_ERROR,"数据更新异常");
        }
        return vo;
    }


}
