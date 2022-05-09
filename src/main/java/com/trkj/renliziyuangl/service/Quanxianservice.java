package com.trkj.renliziyuangl.service;

import com.trkj.renliziyuangl.pojo.Quanxianbiao;

import java.util.List;
import java.util.Map;

public interface Quanxianservice {
    Map findallquanxian(int page);
    Map mohufindquanxian(int page,String qxname);
    boolean insertquanxian(Quanxianbiao qx);
    boolean updatequanxian(Quanxianbiao qx);
    boolean deletequanxian(int id);
    Map injiaoseidfindqxs(int jsid);
    Boolean insertjiaoseqx(int jsid,int[] qxid);
    Boolean deletejiaoseqx(int jsid,int[] qxid);
}
