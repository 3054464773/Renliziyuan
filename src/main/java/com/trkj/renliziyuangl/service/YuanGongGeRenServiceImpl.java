package com.trkj.renliziyuangl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.dao.*;
import com.trkj.renliziyuangl.pojo.*;
import com.trkj.renliziyuangl.vo.RizhiVo;
import com.trkj.renliziyuangl.vo.YgPhoneVo;
import com.trkj.renliziyuangl.vo.canbaoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
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
    @Autowired
    private ChuchaibiaoDao chuchaibiaoDao;
    @Autowired
    private KaoqinjiaqilxbiaoDao kaoqinjiaqilxbiaoDao;
    @Autowired
    private ShenhejilubiaoDao shenhejilubiaoDao;
    @Autowired
    private ShenghebiaoDao shenghebiaoDao;
    @Autowired
    private JiaqishenqibiaoDao jiaqishenqibiaoDao;

    //查询员工通讯录
    @Override
    public PageInfo<YgPhoneVo> ygphone(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        YgPhoneVo ygPhoneVo=new YgPhoneVo();
        List selectygphone = ygdao.selectygphone(ygPhoneVo);
        PageInfo<YgPhoneVo> info=new PageInfo<>(selectygphone);
        return info;
    }

    //根据部门查询员工通讯录
    @Override
    public List selectygphonebybm(int bmbh) {
        return ygdao.cxygphonebybm(bmbh);
    }

    //根据员工姓名模糊查询员工通讯录
    @Override
    public List mohucxygphonebyname(String rzname) {
        return ygdao.mhcxygphonebyname(rzname);
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

    //申请出差（员工个人）
    @Override
    public int shenqingchuchai(Chuchaibiao ccb) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Yuangongbiao yhb = loginUser.getYhb();
        Shenhejilubiao shjlb=new Shenhejilubiao();
        shjlb.setShbid(ccb.getShbid());
        shjlb.setYbh(yhb.getYbh());
        shjlb.setShjlzt(3);
        shjlb.setShjlsj(new Date());
        shenhejilubiaoDao.insert(shjlb);
        ccb.setCzt(1);
        ccb.setShjlbh(shjlb.getShjlbh());
        int insert = chuchaibiaoDao.insert(ccb);
        return insert;
    }

    //查询员工的状态(判断员工是否能申请转正)
    @Override
    public canbaoryVo cxygzt() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Yuangongbiao yhb = loginUser.getYhb();
        return ygdao.yuangongxxbyid(yhb.getYbh());
    }

    //查询所有考勤假期类型
    @Override
    public List cxkqjqlx(Kaoqinjiaqilxbiao kqjqlxb) {
        QueryWrapper<Kaoqinjiaqilxbiao> qw=new QueryWrapper<>();
        return kaoqinjiaqilxbiaoDao.selectList(qw);
    }

    //申请排休
    @Override
    public int shenqingpaixiu(Jiaqishenqibiao jqsqb) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Yuangongbiao yhb = loginUser.getYhb();
        Shenhejilubiao shjlb=new Shenhejilubiao();
        shjlb.setShbid(jqsqb.getShbid());
        shjlb.setYbh(yhb.getYbh());
        shjlb.setShjlzt(3);
        shjlb.setShjlsj(new Date());
        shenhejilubiaoDao.insert(shjlb);
        jqsqb.setShjlbh(shjlb.getShjlbh());
        jiaqishenqibiaoDao.insert(jqsqb);
        return 1;
    }

    //申请转正
    @Override
    public int shenqingzhuanzheng(Yuangonggzjlbiao yggzjlb) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Yuangongbiao yhb = loginUser.getYhb();
        Shenhejilubiao shjlb=new Shenhejilubiao();
        shjlb.setShbid(yggzjlb.getShbid());
        shjlb.setYbh(yhb.getYbh());
        shjlb.setShjlzt(3);
        shjlb.setShjlsj(new Date());
        shenhejilubiaoDao.insert(shjlb);
        yggzjlb.setShjlbh(shjlb.getShjlbh());
        yggzjlb.setYbh(yhb.getYbh());
        yggzjlb.setYggzzt(2);
        yggzjlb.setYggzsj(new Date());
        ygdao.insert(yggzjlb);
        return 1;
    }

    //申请离职
    @Override
    public int shenqinglizhi(Yuangonggzjlbiao yggzjlb) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Yuangongbiao yhb = loginUser.getYhb();
        Shenhejilubiao shjlb = new Shenhejilubiao();
        shjlb.setShbid(yggzjlb.getShbid());
        shjlb.setYbh(yhb.getYbh());
        shjlb.setShjlzt(3);
        shjlb.setShjlsj(new Date());
        shenhejilubiaoDao.insert(shjlb);
        yggzjlb.setShjlbh(shjlb.getShjlbh());
        yggzjlb.setYbh(yhb.getYbh());
        yggzjlb.setYggzzt(3);
        yggzjlb.setYggzsj(new Date());
        ygdao.insert(yggzjlb);
        return 1;
    }

}
