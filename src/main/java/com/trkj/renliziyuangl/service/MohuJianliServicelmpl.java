package com.trkj.renliziyuangl.service;

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
    public List<rencaiVo> mohujianli(String rzname) {
        List<rencaiVo> pp=mohuJianliDao.mohujianli(rzname);
        return pp;
    }
}
