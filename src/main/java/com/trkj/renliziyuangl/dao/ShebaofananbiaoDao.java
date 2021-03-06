package com.trkj.renliziyuangl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.renliziyuangl.pojo.Nashuibiao;
import com.trkj.renliziyuangl.pojo.Shebaofananbiao;
import com.trkj.renliziyuangl.pojo.Shebaojishubiao;
import com.trkj.renliziyuangl.pojo.Yuangongbiao;
import com.trkj.renliziyuangl.vo.canbaoryVo;
import com.trkj.renliziyuangl.vo.ShebaofaVo;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ShebaofananbiaoDao extends BaseMapper<Shebaofananbiao> {
    //查询社保方案
    List cxshebaofangan(Shebaofananbiao sbfa);

    //查询所有社保方案(具体)
    List<ShebaofaVo> selectsbfa(int sbbh);

    //根据方案id或名称模糊查询社保方案信息
    List<Shebaofananbiao> cxfaByIdAndName(String sbmc);

    //查询社保基数表信息
    List selectsbjsxx(Shebaojishubiao sbjsb);

    //删除社保方案
    int deletesbfaxx(int sbbh);

    //根据社保基数名称模糊查询基数信息
    List<Shebaojishubiao> cxjsByName(String sbname);

    //查询参保人员信息(实习员工)
    List cxcanbaorenyuanSx(canbaoryVo sbryvo);


    //查询参保人员信息(正式员工)
    List cxcanbaorenyuanZs(canbaoryVo sbryvo);

    //查询社保缴费信息
    List cxshebaojiaofei(canbaoryVo sbryvo);

    //修改社保状态
    int xgzt(Shebaofananbiao sbfab);

    //通过员工姓名模糊查询其员工信息(参保人员)--实习员工
    List<canbaoryVo> cxygBynamesx(String rzname);

    //通过员工姓名模糊查询其员工信息(参保人员)--正式员工
    List<canbaoryVo> cxygByname(String rzname);

    //通过员工姓名模糊查询其员工信息(社保缴费)
    List<canbaoryVo> cxygByname1(String rzname);

    //根据员工id查询员工信息
    canbaoryVo cxygxxbyid(int ybh);

    //查询社保状态为启用的方案，sbzt=1
    List cxsbfabyzt(Shebaofananbiao fab);

    //给正式员工（员工状态为3）未参保的人员设置社保方案
    int xgygsbxx(Yuangongbiao ygb);

    //修改社保方案保持社保状态不变
    int xgsbfacbzt(Shebaofananbiao fab);

    //根据部门编号查询员工信息（社保缴费界面）
    List findygBybmbh(int bmbh);

    //根据部门编号查询员工信息（未参保人员界面--实习员工（ygzt=2））
    List findygBybmbh1(int bmbh);

    //根据部门编号查询员工信息（未参保人员界面--正式员工（ygzt=3））
    List findygBybmbh2(int bmbh);

    //判断社保基数所被绑定的条数
    int pdsbjsCount(int sbjsbh);

    //社保方案判断（删除，修改状态）
    int pdsbfaCount(int sbbh);

    //根据社保基数名称模糊查询基数信息
    List<Nashuibiao> mohucxnsxx(String nsjnbl);
}