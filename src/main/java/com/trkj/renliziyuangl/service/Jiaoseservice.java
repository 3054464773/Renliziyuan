package com.trkj.renliziyuangl.service;
import com.trkj.renliziyuangl.pojo.Jiaosebiao;

import java.util.Map;

public interface Jiaoseservice {
    Map findalljiaose(int page);
    Map mohufindjiaose(int page,String jsname);
    boolean insertjiaose(Jiaosebiao js);
    boolean updatejiaose(Jiaosebiao js);
    boolean deletejiaose(int id);
}
