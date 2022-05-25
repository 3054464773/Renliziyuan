package com.trkj.renliziyuangl.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.dao.MianshiguizhanbiaoDao;
import com.trkj.renliziyuangl.dao.MianshiguizhanzibiaoDao;
import com.trkj.renliziyuangl.pojo.Mianshiguizhanbiao;
import com.trkj.renliziyuangl.pojo.Mianshiguizhanzibiao;
import com.trkj.renliziyuangl.vo.MianshigzVo;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public PageInfo<Mianshiguizhanbiao> mianshiguizhang(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Mianshiguizhanbiao> list=mianshiguizhanbiaoDao.mianshiguizhang();
        PageInfo<Mianshiguizhanbiao> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Map mohuguizhan(int ym, String rzname) {
        Page<Mianshiguizhanbiao> page=new Page<>(ym,4);
        LambdaQueryWrapper<Mianshiguizhanbiao> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Mianshiguizhanbiao::getMmc,rzname);
        Page<Mianshiguizhanbiao> page1=mianshiguizhanbiaoDao.selectPage(page,lambdaQueryWrapper);
        Map map=new HashMap();
        map.put("list",page1.getRecords());
        map.put("xxx",page1.getPages());
        return map;
    }

    @Override
    public int insetmsgz(MianshigzVo mianshigzVo) {
        Mianshiguizhanbiao a=new Mianshiguizhanbiao();
        a.setMbh(mianshigzVo.getMbh());
        a.setYbh(mianshigzVo.getYbh());
        a.setZwbh(mianshigzVo.getZwbh());
        a.setMmc(mianshigzVo.getMmc());
        int y=mianshiguizhanbiaoDao.insert(a);
        Mianshiguizhanzibiao b=new Mianshiguizhanzibiao();
        b.setMbh(a.getMbh());
        b.setYbh(mianshigzVo.getYbh1());
        b.setMzwt(mianshigzVo.getMzwt());
        int c=mianshiguizhanzibiaoDao.insert(b);
        return 1;
    }

    @Override
    public List<Mianshiguizhanbiao> guizhangzhiwei() {
        return mianshiguizhanbiaoDao.guizhangzhiwei();
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
