package com.trkj.renliziyuangl.service;

import com.trkj.renliziyuangl.pojo.Shenghebiao;

import java.util.Map;

public interface ShengsheService {
    Map findallshenhe(String shname, int ym);

    int insertshenhe(Shenghebiao sh);

    int deleteshenhe(int id);
}
