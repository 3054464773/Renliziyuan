package com.trkj.renliziyuangl.service;

import com.trkj.renliziyuangl.pojo.Bumenbiao;
import com.trkj.renliziyuangl.pojo.Tongzhibiao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface TongzhiService {
    //发布通知
    int insertTongzhi(Tongzhibiao tz, HttpServletRequest request);
   //查找所有部门和通知记录
    Map findallbmandtzjilu( HttpServletRequest request,int dqy,String sstj);
}
