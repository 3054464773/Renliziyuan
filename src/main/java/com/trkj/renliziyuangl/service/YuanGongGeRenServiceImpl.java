package com.trkj.renliziyuangl.service;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.dao.GongzuorizhibiaoDao;
import com.trkj.renliziyuangl.dao.KaoqinjilubiaoDao;
import com.trkj.renliziyuangl.dao.YuangonggzjlbiaoDao;
import com.trkj.renliziyuangl.pojo.*;
import com.trkj.renliziyuangl.vo.RizhiVo;
import com.trkj.renliziyuangl.vo.YgPhoneVo;
import com.trkj.renliziyuangl.vo.canbaoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class YuanGongGeRenServiceImpl implements YuanGongGeRenService {
    @Autowired
    private YuangonggzjlbiaoDao ygdao;
    @Autowired
    private GongzuorizhibiaoDao gongzuorizhibiaoDao;
    @Autowired
    private KaoqinjilubiaoDao kaoqinjilubiaoDao;

    //查询员工通讯录
    @Override
    public List ygphone(YgPhoneVo phone) {
        return ygdao.selectygphone(phone);
    }

    //发表日志
    @Override
    public int fbrizhi(Gongzuorizhibiao gzrzb) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Yuangongbiao yhb = loginUser.getYhb();
        gzrzb.setYbh(yhb.getYbh());
        gzrzb.setGzrzsj(new Date());
        return gongzuorizhibiaoDao.insert(gzrzb);
    }

    //查询我的日志
    @Override
    public PageInfo<RizhiVo> selectMeRizhi(int pageNum, int pageSize) {
        //获取当前登录人的员工信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Yuangongbiao yhb = loginUser.getYhb();
        PageHelper.startPage(pageNum, pageSize);
        List<RizhiVo> cxmerizhi = ygdao.cxmerizhi(yhb.getYbh());
        PageInfo<RizhiVo> pageInfo = new PageInfo<>(cxmerizhi);
        System.out.println("123" + pageInfo);
        return pageInfo;
    }

    //查询已点评日志
    @Override
    public PageInfo<RizhiVo> selectydprz(int pageNum, int pageSize) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Yuangongbiao yhb = loginUser.getYhb();
        PageHelper.startPage(pageNum, pageSize);
        List<RizhiVo> cxyidianpingrz = ygdao.cxyidianpingrz(yhb.getYbh());
        PageInfo<RizhiVo> info = new PageInfo<>(cxyidianpingrz);
        System.out.println("已点评日志：" + info);
        return info;
    }

    //根据员工id查询员工个人考勤记录
    @Override
    public List selectkqjlbyid() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Yuangongbiao yhb = loginUser.getYhb();
        return ygdao.cxkaoqinjlByid(yhb.getYbh());
    }

    //根据员工id查询员工个人绩效记录
    @Override
    public List selectjixiaobyid() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Yuangongbiao yhb = loginUser.getYhb();
        return ygdao.cxjixiaoByid(yhb.getYbh());
    }

    //根据员工编号查询员工薪资记录
    @Override
    public List selectxinzibyid() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Yuangongbiao yhb = loginUser.getYhb();
        return ygdao.cxxinziByid(yhb.getYbh());
    }

    //根据员工编号查询员工出差记录
    @Override
    public List selectchuchaibyid() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Yuangongbiao yhb = loginUser.getYhb();
        return ygdao.cxchuchaiByid(yhb.getYbh());
    }

    //查询通知
    @Override
    public List selecttongzhi() {
        return ygdao.cxtongzhi();
    }

    //查询公告
    @Override
    public List selectgonggao() {
        return ygdao.cxgonggao();
    }

    //根据员工id查询员工个人资料
    @Override
    public canbaoryVo selectgrzl() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Yuangongbiao yhb = loginUser.getYhb();
        return ygdao.cxyuangonggerenziliao(yhb.getYbh());
    }

    //修改员工个人资料
    @Override
    public int xggerenziliao(Rencaizibiao rcb) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Yuangongbiao yhb = loginUser.getYhb();
        rcb.setRzbh(yhb.getRzbh());
        return ygdao.updategrzl(rcb);
    }

    //根据员工id查询班次
    @Override
    public Bancibiao selectbanci() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Yuangongbiao yhb = loginUser.getYhb();
        return ygdao.cxbancibyid(yhb.getYbh());
    }

    //根据员工id查询当天是否有考勤记录
    @Override
    public Kaoqinjilubiao cxkqjlbydate() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Yuangongbiao yhb = loginUser.getYhb();
        int ybh = yhb.getYbh();
        Kaoqinjilubiao kaoqinjilubiao = ygdao.cxkqjlByIdandDate(ybh);
        return kaoqinjilubiao;
    }

    //员工打卡操作
    @Override
    public Kaoqinjilubiao ygdk() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Yuangongbiao yhb = loginUser.getYhb();
        Kaoqinjilubiao kqjlb = new Kaoqinjilubiao();
        Kaoqinjilubiao kaoqinjilubiao = ygdao.cxkqjlByIdandDate(yhb.getYbh());
        Bancibiao cxbancibyid = ygdao.cxbancibyid(yhb.getYbh());
        Date bckssj = cxbancibyid.getBckssj();
        Date bcjssj = cxbancibyid.getBcjssj();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String kssj = dateFormat.format(bckssj);
        String jssj = dateFormat.format(bcjssj);
        System.out.println("上班时间：" + kssj);
        System.out.println("下班时间：" + jssj);
        Date sj=new Date();
        String xzsj=dateFormat.format(sj);
        System.out.println("当前时间："+xzsj);
        if (kaoqinjilubiao == null) {
            kqjlb.setYbh(yhb.getYbh());
            kqjlb.setKqsbzt(4);
            kqjlb.setKqxbzt(4);
            kqjlb.setXzsj(new Date());
            kaoqinjilubiaoDao.insert(kqjlb);
            if (xzsj.compareTo(kssj) < 0) {
                System.out.println("上班正常");
                kqjlb.setKqjlbh(kqjlb.getKqjlbh());
                kqjlb.setYbh(kqjlb.getYbh());
                kqjlb.setKqsbdksj(sj);
                kqjlb.setKqsbzt(1);
                kqjlb.setXzsj(kqjlb.getXzsj());
                kaoqinjilubiaoDao.updateById(kqjlb);
            } else if (kssj.compareTo(xzsj)<0 && jssj.compareTo(xzsj)>0) {
                System.out.println("迟到");
                kqjlb.setKqjlbh(kqjlb.getKqjlbh());
                kqjlb.setYbh(kqjlb.getYbh());
                kqjlb.setKqsbdksj(sj);
                kqjlb.setKqsbzt(2);
                kqjlb.setXzsj(kqjlb.getXzsj());
                kaoqinjilubiaoDao.updateById(kqjlb);
            }else if(jssj.compareTo(xzsj)<0){
                System.out.println("下班正常");
                kqjlb.setKqjlbh(kqjlb.getKqjlbh());
                kqjlb.setYbh(kqjlb.getYbh());
                kqjlb.setKqsbzt(kqjlb.getKqsbzt());
                kqjlb.setKqxbdksj(sj);
                kqjlb.setKqxbzt(1);
                kqjlb.setXzsj(kqjlb.getXzsj());
                kaoqinjilubiaoDao.updateById(kqjlb);
            }
        } else {
            if (kaoqinjilubiao.getKqsbdksj() != null && kssj.compareTo(xzsj)<0 && jssj.compareTo(xzsj)>0) {
                System.out.println("早退");
                kqjlb.setKqjlbh(kaoqinjilubiao.getKqjlbh());
                kqjlb.setYbh(kaoqinjilubiao.getYbh());
                kqjlb.setKqsbdksj(kaoqinjilubiao.getKqsbdksj());
                kqjlb.setKqsbzt(kaoqinjilubiao.getKqsbzt());
                kqjlb.setKqxbdksj(sj);
                kqjlb.setKqxbzt(3);
                kqjlb.setXzsj(kaoqinjilubiao.getXzsj());
                kaoqinjilubiaoDao.updateById(kqjlb);
            } else if (jssj.compareTo(xzsj)<0) {
                System.out.println("下班正常");
                kqjlb.setKqjlbh(kaoqinjilubiao.getKqjlbh());
                kqjlb.setYbh(kaoqinjilubiao.getYbh());
                kqjlb.setKqsbzt(kaoqinjilubiao.getKqsbzt());
                kqjlb.setKqxbdksj(sj);
                kqjlb.setKqxbzt(1);
                kqjlb.setXzsj(kaoqinjilubiao.getXzsj());
                kaoqinjilubiaoDao.updateById(kqjlb);
            }
        }
        return kqjlb;
    }


}
