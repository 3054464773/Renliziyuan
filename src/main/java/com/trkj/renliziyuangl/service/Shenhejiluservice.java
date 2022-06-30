package com.trkj.renliziyuangl.service;

import com.trkj.renliziyuangl.pojo.Chuchaibiao;
import com.trkj.renliziyuangl.pojo.Jiaqishenqibiao;
import com.trkj.renliziyuangl.pojo.Yuangonggzjlbiao;
import com.trkj.renliziyuangl.pojo.Zhaopingjihuabiao;

import java.util.List;

public interface Shenhejiluservice {
    List<Zhaopingjihuabiao> findzpjh();

    int shzpjh(int pdtj,int shjlbh);

    List<Yuangonggzjlbiao> findyggzjl();

    int shygzz(int yggzt, int shjlbh,int ygid,int ygzt);


    List<Jiaqishenqibiao> findqj();

    int shygqj(int pdtj, int shjlbh);

    List<Chuchaibiao> findygcc();
}
