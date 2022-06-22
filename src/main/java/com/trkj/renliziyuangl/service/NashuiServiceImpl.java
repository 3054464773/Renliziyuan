package com.trkj.renliziyuangl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.dao.NashuibiaoDao;
import com.trkj.renliziyuangl.dao.ShebaofananbiaoDao;
import com.trkj.renliziyuangl.pojo.Nashuibiao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NashuiServiceImpl implements NashuiService {
    @Autowired
    private NashuibiaoDao nashuibiaoDao;
    @Autowired
    private ShebaofananbiaoDao shebaofananbiaoDao;

    //查询所有纳税表信息
    @Override
    public PageInfo<Nashuibiao> cxnashuixx(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        QueryWrapper<Nashuibiao> qw=new QueryWrapper<>();
        List<Nashuibiao> nashuibiaos = nashuibiaoDao.selectList(qw);
        PageInfo<Nashuibiao> info=new PageInfo<>(nashuibiaos);
        return info;
    }

    //新增纳税
    @Override
    public Nashuibiao insertnashui(Nashuibiao nsb) {
        int insert = nashuibiaoDao.insert(nsb);
        return nsb;
    }

    //根据id查询纳税信息
    @Override
    public Nashuibiao cxnsxxbyid(int nsbbh) {
        return nashuibiaoDao.selectById(nsbbh);
    }

    //根据纳税缴纳比例模糊查询纳税信息
    @Override
    public List<Nashuibiao> mohucxns(String nsjnbl) {
        return shebaofananbiaoDao.mohucxnsxx(nsjnbl);
    }

    //修改纳税
    @Override
    public int xgnashuixx(Nashuibiao nsb) {
        return nashuibiaoDao.updateById(nsb);
    }

    //删除纳税
    @Override
    public int scnashuixx(int nsbbh) {
        return nashuibiaoDao.deleteById(nsbbh);
    }


}
