package com.trkj.renliziyuangl.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.dao.MianshiguizhanbiaoDao;
import com.trkj.renliziyuangl.dao.MianshiguizhanzibiaoDao;
import com.trkj.renliziyuangl.dao.MohuGuizhanVoDao;
import com.trkj.renliziyuangl.dao.ZpjhVoDao;
import com.trkj.renliziyuangl.pojo.LoginUser;
import com.trkj.renliziyuangl.pojo.Mianshiguizhanbiao;
import com.trkj.renliziyuangl.pojo.Mianshiguizhanzibiao;
import com.trkj.renliziyuangl.pojo.Yuangongbiao;
import com.trkj.renliziyuangl.vo.GuizhanVo;
import com.trkj.renliziyuangl.vo.MianshigzVo;
import com.trkj.renliziyuangl.vo.zpjhVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MianshiguizhangServicelmpl implements MianshiguizhangService{
    @Autowired
    private MianshiguizhanbiaoDao mianshiguizhanbiaoDao;
    @Autowired
    private MianshiguizhanzibiaoDao mianshiguizhanzibiaoDao;
    @Autowired
    private MohuGuizhanVoDao mohuchax;
    @Autowired
    private ZpjhVoDao zpjhVoDao;
//分页查询
    @Override
    public PageInfo<Mianshiguizhanbiao> mianshiguizhang(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Mianshiguizhanbiao> list=mianshiguizhanbiaoDao.mianshiguizhang();
        PageInfo<Mianshiguizhanbiao> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<GuizhanVo> mohuchaxunguiz(int pageNum, int pageSize, String mmc) {
        PageHelper.startPage(pageNum,pageSize);
        List<GuizhanVo> list=mohuchax.mohuchaxunguiz(mmc);
        PageInfo info=new PageInfo<>(list);
        return info;
    }

    //规章表模糊查XUN
//    @Override
//    public Map mohuguizhan(int ym, String rzname) {
//        Page<Mianshiguizhanbiao> page=new Page<>(ym,4);
//        LambdaQueryWrapper<Mianshiguizhanbiao> lambdaQueryWrapper=new LambdaQueryWrapper<>();
//        lambdaQueryWrapper.like(Mianshiguizhanbiao::getMmc,rzname);
//        Page<Mianshiguizhanbiao> page1=mianshiguizhanbiaoDao.selectPage(page,lambdaQueryWrapper);
//        Map map=new HashMap();
//        map.put("list",page1.getRecords());
//        map.put("xxx",page1.getPages());
//        return map;
//    }
//规章子父表添加
    @Override
    public int insetmsgz(MianshigzVo mianshigzVo) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Yuangongbiao yhb = loginUser.getYhb();
        Mianshiguizhanbiao a=new Mianshiguizhanbiao();
        a.setMbh(mianshigzVo.getMbh());
        a.setYbh(yhb.getYbh());
        a.setZwbh(mianshigzVo.getZwbh());
        a.setMmc(mianshigzVo.getMmc());
        int y=mianshiguizhanbiaoDao.insert(a);
        Mianshiguizhanzibiao b=new Mianshiguizhanzibiao();
        b.setMbh(a.getMbh());
        b.setYbh(yhb.getYbh());
        b.setMzwt(mianshigzVo.getMzwt());
        int c=mianshiguizhanzibiaoDao.insert(b);
        return 1;
    }

    @Override
    public List<Mianshiguizhanbiao> guizhangzhiwei() {
        return mianshiguizhanbiaoDao.guizhangzhiwei();
    }
//规章部门查询
    @Override
    public PageInfo<GuizhanVo> bumenguiz(int pageNum, int pageSize, String bmmc) {
        PageHelper.startPage(pageNum,pageSize);
        List<GuizhanVo> list=mohuchax.bumenguiz("%"+bmmc+"%");
        PageInfo info=new PageInfo<>(list);
        return info;
    }
    //招聘计划部门查询
    @Override
    public PageInfo<zpjhVo> bumenzpjh(int pageNum, int pageSize, String bmmc) {
        PageHelper.startPage(pageNum,pageSize);
        List<zpjhVo> list=zpjhVoDao.bumenzpjh("%"+bmmc+"%");
        PageInfo info=new PageInfo<>(list);
        return info;
    }

    @Override
    public PageInfo<zpjhVo> mohuzpjh(int pageNum, int pageSize,String zmc) {
        PageHelper.startPage(pageNum,pageSize);
        List<zpjhVo> list=zpjhVoDao.mohuzpjh("%"+zmc+"%");
        PageInfo<zpjhVo> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }
//  @Override
//    public  int xiugai(Mianshiguizhanzibiao mianshiguizhanzibiao){
//        UpdateWrapper<Mianshiguizhanzibiao> a=new UpdateWrapper<>();
//        a.set("ybh",mianshiguizhanzibiao.getYbh());
//        a.set("mzbh",mianshiguizhanzibiao.getMzbh());
//        a.set("mzwt",mianshiguizhanzibiao.getMzwt());
//        int b=mianshiguizhanzibiaoDao.update(null,a);
//        return b;
//
//    }
}
