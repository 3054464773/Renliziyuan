package com.trkj.renliziyuangl.service;

import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.pojo.Xinziyaosuxiangbiao;

public interface salaryElementService {
    PageInfo<Xinziyaosuxiangbiao> findAllSalaryElement(int pageNum,int pageSize);
    Xinziyaosuxiangbiao insertSalaryElement(Xinziyaosuxiangbiao vo);
    Xinziyaosuxiangbiao updateSalaryElement(Xinziyaosuxiangbiao vo);
    Xinziyaosuxiangbiao findSalaryElementByYsbh(int xzysbh);
    PageInfo<Xinziyaosuxiangbiao> findSalaryElementByYsmc(int pageNum,int pageSize,String xzysmc);
    int deleteSalaryElementByYsbh(int xzysbh);
}
