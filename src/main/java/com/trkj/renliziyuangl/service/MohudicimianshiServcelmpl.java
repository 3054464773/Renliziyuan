package com.trkj.renliziyuangl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.dao.MohudiyicimsDao;
import com.trkj.renliziyuangl.vo.ZpVo;
import com.trkj.renliziyuangl.vo.usersssVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MohudicimianshiServcelmpl implements MohudicimianshiServce{
    @Autowired
    public MohudiyicimsDao mohuchaxunygg;
    @Override
    public PageInfo<ZpVo> mohudiyici(int pageNum,int pageSize,String rzname) {
        PageHelper.startPage(pageNum,pageSize);
        List<ZpVo> list=mohuchaxunygg.mohudiyici(rzname);
        System.out.println("传过来了"+list);
        PageInfo info=new PageInfo<>(list);
        return info;
    }
}
