package com.trkj.renliziyuangl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.dao.RencaibiaoDao;
import com.trkj.renliziyuangl.pojo.Rencaibiao;
import com.trkj.renliziyuangl.vo.interviewVo;
import com.trkj.renliziyuangl.vo.rencaiVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Service
public class RencaiServiceImpl implements RencaiService{
    @Autowired
    private RencaibiaoDao rencaibiaoDao;

    @Override
    public PageInfo<interviewVo> selecd(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<interviewVo> list=rencaibiaoDao.selecd();
        PageInfo<interviewVo> rencaibiaoPageInfo=new PageInfo<>(list);
        return rencaibiaoPageInfo;
    }

    @Override
    public PageInfo<Rencaibiao> selecdrencai(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Rencaibiao> list=rencaibiaoDao.selecdrencai();
        PageInfo<Rencaibiao> info=new PageInfo<>(list);
        return info;
    }
    @Transactional
    @Override
    public int xiugaizt(int rid) {
        return rencaibiaoDao.xiugaizt(rid);
    }
    @Transactional
    @Override
    public int xiugaiztt(int rid) {
        return rencaibiaoDao.xiugaiztt(rid);
    }
//添加双表
//    @Override
//    public int insersyygg(rencaiVo rencaiVo) {
//        Rencaibiao rencaibiao=new Rencaibiao();
//        rencaibiao.setRid(rencaiVo.getRid());
//        rencaibiao.setRzt(rencaiVo.getRzt());
//        rencaibiao.setRsj(rencaiVo.getRsj());
//        rencaibiao.setRsf(rencaiVo.getRsf());
//        int inset2=rencaibiaoDao.insert(rencaibiao);
//        return 1;
//    }
}
