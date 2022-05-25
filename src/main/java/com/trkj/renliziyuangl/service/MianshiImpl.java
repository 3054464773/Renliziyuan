package com.trkj.renliziyuangl.service;

import com.trkj.renliziyuangl.dao.MianshijilubiaoDao;
import com.trkj.renliziyuangl.pojo.Mianshiguizhanzibiao;
import com.trkj.renliziyuangl.pojo.Mianshijilubiao;
import com.trkj.renliziyuangl.vo.ZpVo;
import com.trkj.renliziyuangl.vo.rencaiVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class MianshiImpl implements Mianshi {
    @Autowired
    private MianshijilubiaoDao mianshijilubiaoDao;

    //面试记录
    @Override
    public int msjl(ZpVo zpvo) {
        Mianshiguizhanzibiao b=new Mianshiguizhanzibiao();
        Mianshijilubiao a=new Mianshijilubiao();

        a.setRid(zpvo.getRid());
        a.setYbh(zpvo.getYbh());
        a.setMzbh(zpvo.getMzbh());
        a.setMjsj(new Date());
        a.setMjzt(1);
        int count= mianshijilubiaoDao.insert(a);
        return 1;
    }

    @Override
    public int msjlmg(ZpVo zpVo) {
        Mianshiguizhanzibiao b=new Mianshiguizhanzibiao();
        Mianshijilubiao a=new Mianshijilubiao();

        a.setRid(zpVo.getRid());
        a.setYbh(zpVo.getYbh());
        a.setMzbh(zpVo.getMzbh());
        a.setMjsj(new Date());
        a.setMjzt(2);
        int count= mianshijilubiaoDao.insert(a);
        return 1;
    }

    @Override
    public int yymsjl(rencaiVo rencaiVo) {
        Mianshijilubiao a=new Mianshijilubiao();
        Mianshiguizhanzibiao b=new Mianshiguizhanzibiao();
       a.setRid(rencaiVo.getRid());
       a.setMzbh(b.getMzbh());
       a.setMjsj(new Date());
       a.setMjzt(3);
       int l=mianshijilubiaoDao.insert(a);
        return 1;
    }
}
