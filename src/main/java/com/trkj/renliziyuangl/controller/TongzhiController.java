package com.trkj.renliziyuangl.controller;

import com.trkj.renliziyuangl.pojo.Tongzhibiao;
import com.trkj.renliziyuangl.service.TongzhiService;
import com.trkj.renliziyuangl.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class TongzhiController {
    @Autowired
    private TongzhiService tzservice;

    @PreAuthorize("hasAnyAuthority('insertTongzhi')")
    @PostMapping("/insertTongzhi")
    public AjaxResponse insertTongzhi(HttpServletRequest request, @RequestBody Tongzhibiao tongzhibiao){
        int i = tzservice.insertTongzhi(tongzhibiao, request);
        return AjaxResponse.success(i);
    }
    @GetMapping("/findallbmandtzjilu")
    public AjaxResponse findallbmandtzjilu(HttpServletRequest request,int dqy,String sstj){
        return AjaxResponse.success(tzservice.findallbmandtzjilu(request,dqy,sstj));
    }
    @GetMapping("/mohufindallbmandtzjilu")
    public AjaxResponse mohufindallbmandtzjilu(HttpServletRequest request,int dqy,String sstj){
        return AjaxResponse.success(tzservice.findallbmandtzjilu(request,dqy,sstj));
    }
}
