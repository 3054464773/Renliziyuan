package com.trkj.renliziyuangl.service;

import com.trkj.renliziyuangl.pojo.Gonggaobiao;

import java.util.List;
import java.util.Map;

public interface GonggaoService {
    int fabutongzhi(Gonggaobiao ggbiao);

    Map findallgg(int page,String cxtj);
}
