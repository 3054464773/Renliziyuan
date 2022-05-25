package com.trkj.renliziyuangl.service;

import com.trkj.renliziyuangl.pojo.Mianshiguizhanzibiao;

import java.util.List;

public interface MianshiwentiService {
    public List<Mianshiguizhanzibiao> mianshizi(int mbh);
    public int deleteById(int mbh);
    public Mianshiguizhanzibiao xiugaigzz(Mianshiguizhanzibiao mianshiguizhanzibiao);
    //简历预约面试
    public List<Mianshiguizhanzibiao> mianshiwenti(int zwbh,int rid);
    public List<Mianshiguizhanzibiao> mianshiwentitt(int zwbh,int rid);
    public Mianshiguizhanzibiao insertmz(Mianshiguizhanzibiao mianshiguizhanzibiao);

}
