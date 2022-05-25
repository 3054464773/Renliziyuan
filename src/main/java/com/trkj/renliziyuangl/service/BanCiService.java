package com.trkj.renliziyuangl.service;

import com.trkj.renliziyuangl.pojo.Bancibiao;

import java.util.Map;

public interface BanCiService {
    int insertbanci(Bancibiao bcbiao);

    Map findbanci(int ym);

    int shanchubanci(int bcid);

    int xiugaibanci(Bancibiao bcbiao2);
}
