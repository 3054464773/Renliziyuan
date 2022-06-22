package com.trkj.renliziyuangl.service;

import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.vo.SalaryVo;

import java.util.List;

public interface payrollService {
    PageInfo<SalaryVo> selectEmpInfo(int pageNum, int pageSize);//工资条基本信息
}
