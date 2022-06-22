package com.trkj.renliziyuangl.service;

import com.trkj.renliziyuangl.pojo.Qianduanbiao;

import java.util.Map;

public interface QianduanService {
    Map findallqd(int ym,String cxtj);

    int updatecd(Qianduanbiao qd);

    int insertcd(Qianduanbiao cdstl);
}
