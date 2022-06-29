package com.trkj.renliziyuangl.service;

import com.trkj.renliziyuangl.dao.ShenhejilubiaoDao;
import com.trkj.renliziyuangl.pojo.Yuangonggzjlbiao;
import com.trkj.renliziyuangl.pojo.Zhaopingjihuabiao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShenhejiluserviceImpl implements Shenhejiluservice {
    @Autowired
    private ShenhejilubiaoDao shdao;


    @Override
    public List<Zhaopingjihuabiao> findzpjh() {
        return shdao.findzpjh();
    }

    @Override
    public int shzpjh(int pdtj, int shjlbh) {
        return shdao.shzpjh(pdtj,shjlbh);
    }

    @Override
    public List<Yuangonggzjlbiao> findyggzjl() {
        return shdao.findyggzjl();
    }

    @Override
    public int shygzz(int pdtj, int shjlbh,int ygid,int ygzt) {
        if (pdtj==1){
            shdao.shygzz(pdtj,shjlbh);
            if (ygzt==2){
                return  shdao.xiugaiygzt(ygid,3);
            }else {
                return  shdao.xiugaiygzt(ygid,4);
            }

        }else {
            return shdao.shygzz(pdtj,shjlbh);
        }

    }
}
