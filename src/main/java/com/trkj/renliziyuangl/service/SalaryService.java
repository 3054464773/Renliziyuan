package com.trkj.renliziyuangl.service;

import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.vo.basePay;
import com.trkj.renliziyuangl.vo.job;

import java.util.List;

public interface SalaryService {
    PageInfo<basePay> findAllBasePay(int pageNum,int pageSize);
    PageInfo<basePay> findAllBasePayByName(int pageNum,int pageSize,String rzname);
    PageInfo<job> findAllPositionSalary(int pageNum,int pageSize);
    PageInfo<job> findAllPositionSalaryByZwmc(int pageNum,int pageSize,String zwmc);
    job selectPositionSalaryByXzjbbh(int xzjbbh);
    job updatePositionSalaryByXzjbbh(job vo);
}
