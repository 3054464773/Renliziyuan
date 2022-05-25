package com.trkj.renliziyuangl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.renliziyuangl.pojo.Xinziyaosuxiangbiao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface XinziyaosuxiangbiaoDao extends BaseMapper<Xinziyaosuxiangbiao> {
    List<Xinziyaosuxiangbiao> findAllSalaryElement();
    int insertSalaryElement(Xinziyaosuxiangbiao vo);
    int updateSalaryElement(Xinziyaosuxiangbiao vo);
    Xinziyaosuxiangbiao findSalaryElementByYsbh(int xzysbh);
    List<Xinziyaosuxiangbiao> findSalaryElementByYsmc(String xzysmc);
    int deleteSalaryElementByYsbh(int xzysbh);
}