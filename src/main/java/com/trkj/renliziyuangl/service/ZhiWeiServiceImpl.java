package com.trkj.renliziyuangl.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.renliziyuangl.dao.MianshiguizhanbiaoDao;
import com.trkj.renliziyuangl.dao.ZhaopingjihuabiaoDao;
import com.trkj.renliziyuangl.dao.ZhiweibiaoDao;
import com.trkj.renliziyuangl.pojo.Bumenbiao;
import com.trkj.renliziyuangl.pojo.Mianshiguizhanbiao;
import com.trkj.renliziyuangl.pojo.Zhaopingjihuabiao;
import com.trkj.renliziyuangl.pojo.Zhiweibiao;
import com.trkj.renliziyuangl.vo.zpjhVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ZhiWeiServiceImpl implements ZhiWeiService {
    @Autowired
    private ZhiweibiaoDao zwdao;
    @Autowired
    private MianshiguizhanbiaoDao msgzDao;
    @Autowired
    private ZhaopingjihuabiaoDao zhaopingjihuabiaoDao;
    @Override
    public Map findallzw(int ym) {
        Page<Zhiweibiao> bumenbiaoPage = zwdao.selectPage(new Page<>(ym, 8),  new LambdaQueryWrapper<Zhiweibiao>().orderByDesc(Zhiweibiao::getZwbh));
        Map map=new HashMap();
        map.put("zwlist",bumenbiaoPage.getRecords());
        map.put("zts",bumenbiaoPage.getPages());
        return map;
    }

    @Override
    public Map mohufindzw(int ym, String zwname) {
        Page<Zhiweibiao> page=new Page<>(ym,8);
        LambdaQueryWrapper<Zhiweibiao> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Zhiweibiao::getZwmc,zwname).orderByDesc(Zhiweibiao::getZwbh);
        Page<Zhiweibiao> bumenbiaoPage = zwdao.selectPage(page, lambdaQueryWrapper);
        Map map=new HashMap();
        map.put("zwlist",bumenbiaoPage.getRecords());
        map.put("zys",bumenbiaoPage.getPages());
        return map;
    }

    @Override
    public boolean insertzw(Zhiweibiao zw) {
        zw.setZwsj(new Date());
        int insert = zwdao.insert(zw);
        return insert>0?true:false;
    }

    @Override
    public boolean updatezw(Zhiweibiao zw) {
        int jg = zwdao.updateById(zw);
        return jg>0?true:false;
    }

    @Override
    public List<Zhiweibiao> zhiwei() {

        return zwdao.zhiwei();
    }
    @Override
    public List<Zhiweibiao> zhaopzhiwei(int bmbh) {

        return zwdao.zhaopzhiwei(bmbh);
    }
    @Override
    public List<Zhiweibiao> zhaopjhzhiwei(int bmbh) {
        System.out.println("进来了！！！！！！");
        List<zpjhVo> list=zhaopingjihuabiaoDao.findszpjh();
        List<Zhiweibiao> list1=zwdao.zhaopjhzhiwei(bmbh);
        for (int i = 0; i < list.size(); i++) {
            for (int i1 = 0; i1 < list1.size(); i1++) {
                if (list.get(i).getZwbh()==list1.get(i1).getZwbh()){
                    list1.remove(i1);
                }
            }
        }
        return list1;
    }
//    @Override
//    public List<Zhiweibiao> zhaopjhzhiwei(int bmbh) {
//        return zwdao.zhaopjhzhiwei(bmbh);
//    }

//
//    @Override
//    public List<Zhiweibiao> zhiweiqc() {
//        QueryWrapper<Zhiweibiao> queryWrapper=new QueryWrapper<>();
//        queryWrapper.select("distinct   9,zwbh");
//
//        return zwdao.selectList(queryWrapper);
//    }

}
