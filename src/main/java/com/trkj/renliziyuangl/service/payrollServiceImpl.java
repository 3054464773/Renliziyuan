package com.trkj.renliziyuangl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.dao.XingzijilubiaoDao;
import com.trkj.renliziyuangl.vo.SalaryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class payrollServiceImpl implements payrollService {
    @Autowired
    private XingzijilubiaoDao dao;

    @Override
    public PageInfo<SalaryVo> selectEmpInfo(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SalaryVo> list=dao.selectEmpInfo();
        PageInfo<SalaryVo> info=new PageInfo<>(list);
        return info;
    }
}
