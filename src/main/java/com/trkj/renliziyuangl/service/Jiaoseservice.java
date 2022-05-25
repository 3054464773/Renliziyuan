package com.trkj.renliziyuangl.service;
import com.trkj.renliziyuangl.pojo.Jiaosebiao;
import com.trkj.renliziyuangl.vo.Fenpeiyhjs;
import com.trkj.renliziyuangl.vo.Jiaoseandquanxianvo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface Jiaoseservice {
    Map findalljiaose(int page);
    Map mohufindjiaose(int page,String jsname);
    boolean insertjiaose(Jiaosebiao js);
    boolean updatejiaose(Jiaosebiao js);
    boolean deletejiaose(int id);
    List<Fenpeiyhjs> findallygjs();
    int deleteygjs(HttpServletRequest request, int yhid, int jsid);
    List<Jiaoseandquanxianvo> findalljs(int [] jsid);
    int insertygjs(HttpServletRequest request,Jiaoseandquanxianvo jv);
    List<Fenpeiyhjs> mohufindallygjs(String cxtj);
}
