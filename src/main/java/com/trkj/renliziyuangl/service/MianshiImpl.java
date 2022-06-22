package com.trkj.renliziyuangl.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
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

    //入职修改当次面试状态
    @Override
    public int msjl(int  mjbh) {
        UpdateWrapper<Mianshijilubiao> wrapper=new UpdateWrapper();
        wrapper.eq("mjbh",mjbh);
        wrapper.set("mjzt",1);
        int ppp=mianshijilubiaoDao.update(null,wrapper);
        return ppp;
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

    @Override
    public int xiugaimszt(int mjbh) {
        return mianshijilubiaoDao.xiugaimszt(mjbh);
    }
}
