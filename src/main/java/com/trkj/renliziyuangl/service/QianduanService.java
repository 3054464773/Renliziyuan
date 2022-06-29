package com.trkj.renliziyuangl.service;

import com.trkj.renliziyuangl.dao.JiaosebiaoDao;
import com.trkj.renliziyuangl.pojo.Qianduanbiao;
import com.trkj.renliziyuangl.vo.Xinzengcaidan;

import java.util.List;
import java.util.Map;

public interface QianduanService {
    Map findallqd(String qdfjid,int ym,String cxtj);

    int updatecd(Qianduanbiao qd);

    int insertcd(Qianduanbiao cdstl);

    Map findallqdym( String cxtj);

    int shanchucd(int jsid, int qdid);

    List<Qianduanbiao> chaxunwfpcd(List<Qianduanbiao> qdlist);

    int xinzengcaidan(Xinzengcaidan fpcdlist);
}
