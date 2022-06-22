package com.trkj.renliziyuangl.service;

import com.trkj.renliziyuangl.pojo.Jiaosebiao;
import com.trkj.renliziyuangl.pojo.Shenhesxqxbiao;

import java.util.List;
import java.util.Map;

public interface ShenhesxqxService {
    Map findsxqx(int ym, int shbid);

    int deletesxqx(int id);

    List<Jiaosebiao> insertsxqx(int id);

    int insertsxqxx(Shenhesxqxbiao shstl2);
}
