package com.trkj.renliziyuangl.service;

import com.trkj.renliziyuangl.pojo.Kaoqinjiaqilxbiao;

import java.util.List;
import java.util.Map;

public interface KaoqinjiaqilxService {
    Map findkqlx(int ym,String cxtj);

    int insertkqlx(Kaoqinjiaqilxbiao kqbiao);

    int shanchu(int jqid);
}
