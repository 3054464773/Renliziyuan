package com.trkj.renliziyuangl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.dao.*;
import com.trkj.renliziyuangl.pojo.*;
import com.trkj.renliziyuangl.vo.canbaoryVo;
import com.trkj.renliziyuangl.vo.ShebaofaVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class shebaosystemServiceImpl implements shebaosystemService {
    @Autowired
    private BancibiaoDao bcdao;
    @Autowired
    private ShebaofananbiaoDao sbfadao;//社保方案表dao
    @Autowired
    private SbzjbDao sbdao;//社保中间表dao
    @Autowired
    private YuangongbiaoDao ygbd;//员工表dao
    @Autowired
    private BumenbiaoDao bmbd;//部门表dao

    /*查询班次表信息*/
    @Override
    public List findBancb(int pageNum, int pageSize) {
        List<Bancibiao> bancibiaos = bcdao.selectList(null);
        return bancibiaos;
    }

    /*查询社保方案*/
    @Override
    public PageInfo<Shebaofananbiao> cxsbfa(int pageNum, int PageSize) {
        PageHelper.startPage(pageNum, PageSize);
        Shebaofananbiao sbfa=new Shebaofananbiao();
        List<Shebaofananbiao> shebaofananbiaos = sbfadao.cxshebaofangan(sbfa);
        PageInfo<Shebaofananbiao> pageInfo=new PageInfo<>(shebaofananbiaos);
        System.out.println(pageInfo);
        return pageInfo;
    }
    /*查询所有社保方案(具体)*/
    @Override
    public List<ShebaofaVo> selectsbfa(int sbbh) {
        return  sbfadao.selectsbfa(sbbh);
    }

    /*根据方案id或名称模糊查询社保方案信息*/
    @Override
    public List<Shebaofananbiao> cxsbidorname(String sbmc) {
        return sbfadao.cxfaByIdAndName(sbmc);
    }

    /*查询社保基数表信息*/
    @Override
    public List selectsbjsxx(Shebaojishubiao sbjsb) {
        return sbfadao.selectsbjsxx(sbjsb);
    }

    /*新增社保方案*/
    @Override
    public int insertsbfa(ShebaofaVo sbvo) {
        Shebaofananbiao sb=new Shebaofananbiao();
        sb.setSbmc(sbvo.getSbmc());
        int insert = sbfadao.insert(sb);
        System.out.println(sb.toString()+"11111111111111111111111");
        System.out.println(sbvo.getQbsj());
        List qbsj = sbvo.getQbsj();
        for (Object o : qbsj) {
            Sbzjb sb2=new Sbzjb();
            sb2.setSbbh(sb.getSbbh());
            sb2.setSbjsbh(Integer.parseInt(o+""));
            sbdao.insert(sb2);
        }
        return 1;
    }

    /*删除社保方案*/
    @Override
    public int deletesbfa(int sbbh) {
        return sbfadao.deletesbfaxx(sbbh);
    }

    /*查询参保人员信息--实习员工*/
    @Override
    public PageInfo<canbaoryVo> cxcbrySx(int pageNum, int PageSize) {
        PageHelper.startPage(pageNum, PageSize);
        canbaoryVo vo=new canbaoryVo();
        List cxcanbaorenyuan = sbfadao.cxcanbaorenyuanSx(vo);
        PageInfo<canbaoryVo> pageInfo=new PageInfo<>(cxcanbaorenyuan);
        System.out.println(pageInfo);
        return pageInfo;
    }

    /*查询参保人员信息--正式员工*/
    @Override
    public PageInfo<canbaoryVo> cxcbryZs(int pageNum, int PageSize) {
        PageHelper.startPage(pageNum, PageSize);
        canbaoryVo vo=new canbaoryVo();
        List cxcanbaorenyuan = sbfadao.cxcanbaorenyuanZs(vo);
        PageInfo<canbaoryVo> pageInfo=new PageInfo<>(cxcanbaorenyuan);
        System.out.println(pageInfo);
        return pageInfo;
    }

    /*查询社保缴费信息*/
    @Override
    public PageInfo<canbaoryVo> cxsbjf(int pageNum, int PageSize) {
        PageHelper.startPage(pageNum, PageSize);
        canbaoryVo vo=new canbaoryVo();
        List cxshebaojiaofei = sbfadao.cxshebaojiaofei(vo);
        PageInfo<canbaoryVo> pageInfo=new PageInfo<>(cxshebaojiaofei);
        System.out.println(pageInfo);
        return pageInfo;
    }

    @Override//社保状态
    public int updatesbzt(Shebaofananbiao sbfab) {
        return sbfadao.xgzt(sbfab);
    }

    /*通过员工姓名模糊查询其员工信息（参保人员）--实习员工  */
    @Override
    public List<canbaoryVo> cxygbynamesx(String rzname) {
        return sbfadao.cxygBynamesx(rzname);
    }

    /*通过员工姓名模糊查询其员工信息（参保人员）--正式员工  */
    @Override
    public List<canbaoryVo> cxygbyname(String rzname) {
        return sbfadao.cxygByname(rzname);
    }

    /*通过员工姓名模糊查询其员工信息（社保缴费）*/
    @Override
    public List<canbaoryVo> cxygbyname1(String rzname) {
        return sbfadao.cxygByname1(rzname);
    }

    /*根据员工id查询员工信息*/
    @Override
    public canbaoryVo cxygxx(int ybh) {
        return sbfadao.cxygxxbyid(ybh);
    }

    /*查询社保状态为启用状态的方案*/
    @Override
    public List cxsbfaByzt(Shebaofananbiao fab) {
        return sbfadao.cxsbfabyzt(fab);
    }

    //给正式员工（员工状态为3）未参保的人员设置社保方案
    @Override
    public int updateygsb(Yuangongbiao ygb) {
        int update=sbfadao.xgygsbxx(ygb);
        return update;
    }

    //修改社保方案
    @Override
    public int updatesbfa(ShebaofaVo favo) {
        Shebaofananbiao fab=new Shebaofananbiao();
        fab.setSbbh(favo.getSbbh());
        fab.setSbmc(favo.getSbmc());
        sbfadao.xgsbfacbzt(fab);
        System.out.println("fab:"+fab);
        int[] sbjslistss = favo.getSbjslistss();
        Sbzjb zjb=new Sbzjb();
        sbdao.deleteById(favo.getSbbh());
        for(int o:sbjslistss){
            zjb.setSbbh(favo.getSbbh());
            zjb.setSbjsbh(Integer.parseInt(o+""));
            sbdao.insert(zjb);
        }
        return 1;
    }

    //查询部门表数据信息
    @Override
    public List<Bumenbiao> cxdept() {
        QueryWrapper<Bumenbiao> qw=new QueryWrapper<>();
        return bmbd.selectList(qw);
    }

    //根据部门id查询员工信息（社保缴费）
    @Override
    public List findygxxBybmbh(int bmbh) {
        return sbfadao.findygBybmbh(bmbh);
    }

    //根据部门id查询员工信息（未参保人员缴费--实习员工ygzt=2）
    @Override
    public List findygxxBybmbh1(int bmbh) {
        return sbfadao.findygBybmbh1(bmbh);
    }

    //根据部门id查询员工信息（未参保人员缴费--正式员工ygzt=3）
    @Override
    public List findygxxBybmbh2(int bmbh) {
        return sbfadao.findygBybmbh2(bmbh);
    }

    //判断社保基数所被绑定的条数
    @Override
    public int sbjsCount(int sbjsbh) {
        return sbfadao.pdsbjsCount(sbjsbh);
    }

    //社保方案判断（删除，修改状态）
    @Override
    public int sbfaCount(int sbbh) {
        return sbfadao.pdsbfaCount(sbbh);
    }

}
