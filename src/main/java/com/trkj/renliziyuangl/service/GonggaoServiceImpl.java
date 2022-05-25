package com.trkj.renliziyuangl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.renliziyuangl.dao.GonggaobiaoDao;
import com.trkj.renliziyuangl.pojo.Gonggaobiao;
import com.trkj.renliziyuangl.pojo.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GonggaoServiceImpl implements GonggaoService {
    @Autowired
    private GonggaobiaoDao gonggaobiaoDao;

    @Override
    public int fabutongzhi(Gonggaobiao ggbiao) {
        ggbiao.setGgsj(new Date());
        ggbiao.setGgyds(0);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        ggbiao.setYbh(loginUser.getYhb().getYbh());
        return gonggaobiaoDao.insert(ggbiao);
    }

    @Override
    public Map findallgg(int page,String cxtj) {
        Map map=new HashMap();
        IPage<Gonggaobiao> findallgg = gonggaobiaoDao.findallgg(new Page(page,6),"%"+cxtj+"%");
        map.put("gglist",findallgg.getRecords());
        map.put("zts",findallgg.getPages());
        return map;
    }
}
