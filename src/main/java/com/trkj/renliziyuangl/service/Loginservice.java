package com.trkj.renliziyuangl.service;

import com.trkj.renliziyuangl.pojo.Qianduanbiao;
import com.trkj.renliziyuangl.pojo.Yuangongbiao;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Loginservice {
    Map login(Yuangongbiao ygb);
    void logout();
    List<Qianduanbiao> byyhfindqd(int yhid);
}
