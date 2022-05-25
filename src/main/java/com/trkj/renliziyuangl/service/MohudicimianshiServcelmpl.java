package com.trkj.renliziyuangl.service;

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
    public List<ZpVo> mohudiyici(String rzname) {
        List<ZpVo> ZpVo=mohuchaxunygg.mohudiyici(rzname);
        System.out.println("2222222222222Service");
        return ZpVo;
    }
}
