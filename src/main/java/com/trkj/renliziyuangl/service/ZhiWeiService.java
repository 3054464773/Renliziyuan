package com.trkj.renliziyuangl.service;

import com.trkj.renliziyuangl.pojo.Bumenbiao;
import com.trkj.renliziyuangl.pojo.Zhiweibiao;
import com.trkj.renliziyuangl.vo.zwVo;

import java.util.List;
import java.util.Map;

public interface ZhiWeiService {
    Map findallzw(int ym);
    Map mohufindzw(int ym, String zwname);
    boolean insertzw(zwVo zw);
    boolean updatezw(Zhiweibiao zw);
    List<Zhiweibiao> zhiwei();
    List<Zhiweibiao> zhaopzhiwei(int bmbh);
    List<Zhiweibiao> zhaopjhzhiwei(int bmbh);


//    List<Zhiweibiao> zhiweiqc();
}
