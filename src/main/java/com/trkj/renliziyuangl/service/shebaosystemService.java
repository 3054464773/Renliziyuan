package com.trkj.renliziyuangl.service;

import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.pojo.Bumenbiao;
import com.trkj.renliziyuangl.pojo.Shebaofananbiao;
import com.trkj.renliziyuangl.pojo.Shebaojishubiao;
import com.trkj.renliziyuangl.pojo.Yuangongbiao;
import com.trkj.renliziyuangl.vo.canbaoryVo;
import com.trkj.renliziyuangl.vo.ShebaofaVo;
import java.util.List;

public interface shebaosystemService {
    public List findBancb(int pageNum,int pageSize);

    //查询社保方案
    public PageInfo<Shebaofananbiao> cxsbfa(int pageNum, int PageSize);

    //查询所有社保方案(具体)
    public List<ShebaofaVo> selectsbfa(int sbbh);

    //根据方案id或名称模糊查询社保方案信息
    List<Shebaofananbiao> cxsbidorname(String sbmc);

    //查询社保基数表信息
    List selectsbjsxx(Shebaojishubiao sbjsb);

    //新增社保方案
    int insertsbfa(ShebaofaVo sbvo);

    //删除社保方案
    int deletesbfa(int sbbh);

    //查询参保人员信息（实习员工）
    public PageInfo<canbaoryVo> cxcbrySx(int pageNum, int PageSize);

    //查询参保人员信息（正式员工）
    public PageInfo<canbaoryVo> cxcbryZs(int pageNum, int PageSize);

    //查询社保缴费信息
    public PageInfo<canbaoryVo> cxsbjf(int pageNum, int PageSize);

    //修改社保状态
    int updatesbzt(Shebaofananbiao sbfab);

    //通过员工姓名模糊查询其员工信息（参保人员）--实习员工
    List<canbaoryVo> cxygbynamesx(String rzname);

    //通过员工姓名模糊查询其员工信息（参保人员）--正式员工
    List<canbaoryVo> cxygbyname(String rzname);

    //通过员工姓名模糊查询其员工信息（社保缴费）
    List<canbaoryVo> cxygbyname1(String rzname);

    //根据员工id查询员工信息
    canbaoryVo cxygxx(int ybh);

    //查询社保状态为启用（1）的方案
    List cxsbfaByzt(Shebaofananbiao fab);

    //给正式员工（员工状态为3）未参保的人员设置社保方案
    int updateygsb(Yuangongbiao ygb);

    //修改社保方案
    int updatesbfa(ShebaofaVo favo);

    //查询所有部门信息
    List<Bumenbiao> cxdept();

    //根据部门编号查询员工信息（社保缴费界面）
    List findygxxBybmbh(int bmbh);

    //根据部门编号查询员工信息（未参保人员界面--实习员工（ygzt=2））
    List findygxxBybmbh1(int bmbh);

    //根据部门编号查询员工信息（未参保人员界面--正式员工（ygzt=3））
    List findygxxBybmbh2(int bmbh);

    //判断社保基数所被绑定的条数
    int sbjsCount(int sbjsbh);

    //社保方案判断（删除，修改状态）
    int sbfaCount(int sbbh);
}
