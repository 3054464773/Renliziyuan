package com.trkj.renliziyuangl.service;

import com.trkj.renliziyuangl.dao.Chuchaijilu;
import com.trkj.renliziyuangl.dao.Mianjilu;
import com.trkj.renliziyuangl.dao.Mohukaoq;
import com.trkj.renliziyuangl.dao.YuangongjiluDao;
import com.trkj.renliziyuangl.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class YgjlServicelmpl implements YgjlService{
    @Autowired
    private YuangongjiluDao yuangongjiluDao;
    @Autowired
    private Mohukaoq mohukaoqin;
    @Autowired
    private Mianjilu mianjilu;
    @Autowired
    private Chuchaijilu chuchaijilu;
    @Override
    public List<JixiaojiluVo> mohujixiaojilu(String rzname) {
        List<JixiaojiluVo> jixiaojiluVos=yuangongjiluDao.mohujixiaojilu(rzname);
        System.out.println("2222222222222Service");
        return jixiaojiluVos;
    }

    @Override
    public List<Chuchaivo> mohuchuchaijjll(String rzname) {
        List<Chuchaivo> list=chuchaijilu.mohuchuchaijjll(rzname);
        return list;
    }

    @Override
    public List<MianshijiluVo> mohumianshijilu(String rzname) {
        List<MianshijiluVo> mohumianshijilu=mianjilu.mohumianshijilu(rzname);
        System.out.println("66666666666+面试记录模糊查询");
        return mohumianshijilu;
    }

    @Override
    public List<KaoqinjiluVo>   mohukaoqin(String rzname) {
        List<KaoqinjiluVo> kaoqinjiluVos=mohukaoqin.mohukaoqin(rzname);
        System.out.println("66666666666+考勤记录模糊查询");
        return kaoqinjiluVos;

    }
}
