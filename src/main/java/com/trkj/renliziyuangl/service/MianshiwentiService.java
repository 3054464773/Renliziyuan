package com.trkj.renliziyuangl.service;

import com.trkj.renliziyuangl.pojo.Mianshiguizhanzibiao;
import com.trkj.renliziyuangl.pojo.Mianshijilubiao;

import java.util.Date;
import java.util.List;

public interface MianshiwentiService {
    public List<Mianshiguizhanzibiao> mianshizi(int mbh);
    public int deleteById(int mbh);
    public Mianshiguizhanzibiao xiugaigzz(Mianshiguizhanzibiao mianshiguizhanzibiao);
    //简历预约面试
    public List<Mianshiguizhanzibiao> mianshiwenti(int zwbh,int rid, int ybh, Date mjsj);
//    public Mianshijilubiao mianshiwentitt(int mzbh, int rid, Date mjsj,int msyg,int mjbh,String mspj);
public Mianshijilubiao mianshiwentitt(int rid, Date mjsj,int msyg,int mjbh,String mspj);
    public Mianshiguizhanzibiao insertmz(Mianshiguizhanzibiao mianshiguizhanzibiao);
    public int shanchuwenti(int mzbh);

}
