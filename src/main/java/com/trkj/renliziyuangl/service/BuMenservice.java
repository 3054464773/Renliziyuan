package com.trkj.renliziyuangl.service;

import com.trkj.renliziyuangl.pojo.Bumenbiao;
import com.trkj.renliziyuangl.pojo.Jiaosebiao;
import com.trkj.renliziyuangl.pojo.Zhiweibiao;

import java.util.List;
import java.util.Map;

public interface BuMenservice {
    Map findallbm(int ym);
    Map mohufindbm(int page,String bmname);
    String deletebm(int id);
    boolean insertbm(Bumenbiao bm);
    boolean updatebm(Bumenbiao bm);
    Map inidfindzw(int id,int page);
    List<Bumenbiao> bumen();
    List<Bumenbiao> bububumen();
    List<Bumenbiao> bumenmmm();

}
