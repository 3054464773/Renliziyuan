package com.trkj.renliziyuangl.controller;


import com.trkj.renliziyuangl.pojo.Quanxianbiao;
import com.trkj.renliziyuangl.service.Quanxianservice;
import com.trkj.renliziyuangl.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuanxianController {
    @Autowired
    private Quanxianservice qxservice;

    @GetMapping("/findallquanxian")
    public AjaxResponse findallquanxian(int page){
        return AjaxResponse.success(qxservice.findallquanxian(page));
    }
    @GetMapping("/mohufindallquanxian")
    public AjaxResponse mohufindallquanxian(int page,String qxname){
        return AjaxResponse.success(qxservice.mohufindquanxian(page,qxname));
    }
    @PostMapping("/insertquanxian")
    public AjaxResponse insertquanxian(@RequestBody Quanxianbiao qx){
        boolean isxzok = qxservice.insertquanxian(qx);
        return AjaxResponse.success(isxzok);
    }
}
