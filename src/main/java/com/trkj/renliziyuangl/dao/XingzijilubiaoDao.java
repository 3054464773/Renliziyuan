package com.trkj.renliziyuangl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.renliziyuangl.pojo.Xingzijilubiao;
import com.trkj.renliziyuangl.vo.SalaryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface XingzijilubiaoDao extends BaseMapper<Xingzijilubiao> {


    List<SalaryVo> selectEmpInfo();//工资条基本信息
    SalaryVo selectEmpYCQTS(@Param("ybh") int ybh);//工资条出勤信息
    List<SalaryVo> selectEmpSocial(int ybh);
    SalaryVo selectEmpYCQTS2(int ybh);
    SalaryVo selectEmpYCQTS3(int ybh);
    SalaryVo AttendanceEmp(int ybh);
    SalaryVo AttendanceEmp2(int ybh);
    List<SalaryVo> selectEmpInfoByMonth(String szjlsj);//按月份查工资条基本信息
    SalaryVo selectEmpYCQTSByMonth(@Param("ybh") int ybh,@Param("xzsj") String xzsj);
    SalaryVo selectEmpYCQTS2ByMonth(@Param("ybh") int ybh,@Param("xzsj") String xzsj);
    SalaryVo selectEmpYCQTS3ByMonth(@Param("ybh") int ybh,@Param("xzsj") String xzsj);
    SalaryVo AttendanceEmpByMonth(@Param("ybh") int ybh ,@Param("xzsj") String xzsj);
    SalaryVo AttendanceEmp2ByMonth(@Param("ybh") int ybh, @Param("xzsj") String xzsj);
    List<SalaryVo> selectEmpInfoByBmmc(String bmmc);
    List<SalaryVo> selectEmpInfoByName(String rzname);
    List<SalaryVo> selectEmpInfoByybh(int  ybh);

}