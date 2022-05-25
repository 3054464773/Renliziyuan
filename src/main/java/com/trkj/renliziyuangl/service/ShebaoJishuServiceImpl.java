package com.trkj.renliziyuangl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.dao.ShebaofananbiaoDao;
import com.trkj.renliziyuangl.dao.ShebaojishubiaoDao;
import com.trkj.renliziyuangl.pojo.Shebaojishubiao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ShebaoJishuServiceImpl implements ShebaoJishuService {
    @Autowired
    private ShebaojishubiaoDao shebaojishubiaoDao;
    @Autowired
    private ShebaofananbiaoDao shebaofananbiaoDao;

    //查询社保基数信息
    @Override
    public PageInfo<Shebaojishubiao> cxshebaojishu(int pageNum, int PageSize) {
        PageHelper.startPage(pageNum, PageSize);
        QueryWrapper<Shebaojishubiao> qw=new QueryWrapper<>();
        List<Shebaojishubiao> shebaojishubiaos = shebaojishubiaoDao.selectList(qw);
        PageInfo<Shebaojishubiao> pageInfo=new PageInfo<>(shebaojishubiaos);
        System.out.println(pageInfo);
        return pageInfo;
    }

    //根据id查询基数信息
    @Override
    public Shebaojishubiao findjsByid(int sbjsbh) {
        Shebaojishubiao shebaojishubiao = shebaojishubiaoDao.selectById(sbjsbh);
        return shebaojishubiao;
    }

    //模糊查询社保基数信息
    @Override
    public List<Shebaojishubiao> cxjsbyname(String sbname) {
        return shebaofananbiaoDao.cxjsByName(sbname);
    }

    //添加社保基数信息
    @Override
    public Shebaojishubiao insertjsxx(Shebaojishubiao sbjsb) {
        int insert = shebaojishubiaoDao.insert(sbjsb);
        return sbjsb;
    }

    //修改基数信息
    @Override
    public int updatejsxx(Shebaojishubiao sbjsb) {
        return shebaojishubiaoDao.updateById(sbjsb);
    }

    //删除社保基数信息
    @Override
    public int deletejsxx(int sbjsbh) {
        return shebaojishubiaoDao.deleteById(sbjsbh);
    }
}
