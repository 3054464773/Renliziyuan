package com.trkj.renliziyuangl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.dao.ZhaopingjihuabiaoDao;
import com.trkj.renliziyuangl.dao.ZpjhVoDao;
import com.trkj.renliziyuangl.pojo.Zhaopingjihuabiao;
import com.trkj.renliziyuangl.vo.zpjhVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ZpjhServiceImpl implements ZpjhService{
    @Autowired
    private ZhaopingjihuabiaoDao zhaopingjihuabiaoDao;
    @Autowired
    private ZpjhVoDao zpjhVoDao;
    @Override
    public PageInfo<Zhaopingjihuabiao> findszpjh(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Zhaopingjihuabiao> list=zhaopingjihuabiaoDao.findszpjh();
        PageInfo<Zhaopingjihuabiao> pageInfo=new PageInfo<>(list);
        return  pageInfo;
    }

    @Override
    public int deleteById(int zhb) {
        return zhaopingjihuabiaoDao.deleteById(zhb);
    }

    @Override
    public Zhaopingjihuabiao tianjiazpjh(Zhaopingjihuabiao zhaopingjihuabiao) {
        zhaopingjihuabiaoDao.tianjiazpjh(zhaopingjihuabiao);
        return zhaopingjihuabiao;
    }

    @Override
    public Zhaopingjihuabiao idchaxun(int zhb) {
        Zhaopingjihuabiao zhaopingjihuabiao=zhaopingjihuabiaoDao.findZpjhById(zhb);
        return zhaopingjihuabiao;
    }

    @Override
    public Zhaopingjihuabiao updataZpjh(Zhaopingjihuabiao zhaopingjihuabiao) {

             int count=   zhaopingjihuabiaoDao.updateZpjh(zhaopingjihuabiao);
        return zhaopingjihuabiao;

    }



    @Override
    public List<zpjhVo> zhaoppxxp() {
        return zpjhVoDao.zhaoppxxp();
    }

}
