package com.trkj.renliziyuangl.service;

import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.vo.SalaryVo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface payrollService {
    PageInfo<SalaryVo> selectEmpInfo(int pageNum,int pageSize);//工资条基本信息
    SalaryVo selectEmpYCQTS(int ybh);
    List<SalaryVo> selectEmpSocial(int ybh);
    SalaryVo selectEmpYCQTS2(int ybh);
    SalaryVo selectEmpYCQTS3(int ybh);
    SalaryVo AttendanceEmp(int ybh);
    SalaryVo AttendanceEmp2(int ybh);
    PageInfo<SalaryVo> selectEmpInfoByMonth(int pageNum,int pageSize,String szjlsj);//工资条基本信息
    SalaryVo selectEmpYCQTSByMonth(int ybh, String xzsj);
    SalaryVo selectEmpYCQTS2ByMonth(int ybh, String xzsj);
    SalaryVo selectEmpYCQTS3ByMonth(int ybh, String xzsj);
    SalaryVo AttendanceEmpByMonth(int ybh ,String xzsj);
    SalaryVo AttendanceEmp2ByMonth( int ybh,String xzsj);
    PageInfo<SalaryVo> selectEmpInfoByBmmc(int pageNum,int pageSize,String bmmc);
    PageInfo<SalaryVo> selectEmpInfoByName(int pageNum,int pageSize,String rzname);
    List<SalaryVo> selectEmpInfoByybh(int  ybh);
}
