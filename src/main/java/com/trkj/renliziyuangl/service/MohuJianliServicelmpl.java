package com.trkj.renliziyuangl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.dao.MohuJianliDao;
import com.trkj.renliziyuangl.vo.rencaiVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MohuJianliServicelmpl implements MohuJianliService{
    @Autowired
    public MohuJianliDao mohuJianliDao;
    @Override
    public PageInfo<rencaiVo> mohujianli(int pageNum, int pageSize, String rzname) {
        PageHelper.startPage(pageNum,pageSize);
        List<rencaiVo> pp=mohuJianliDao.mohujianli(rzname);
        PageInfo info=new PageInfo(pp);
        return info;
    }
}
