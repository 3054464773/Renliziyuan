package com.trkj.renliziyuangl.controller;


import com.alibaba.fastjson.JSON;
import com.trkj.renliziyuangl.pojo.Quanxianbiao;
import com.trkj.renliziyuangl.service.Quanxianservice;
import com.trkj.renliziyuangl.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

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
    public AjaxResponse insertquanxian(@Validated @RequestBody Quanxianbiao qx){
        boolean isxzok = qxservice.insertquanxian(qx);
        return AjaxResponse.success(isxzok);
    }
    @PutMapping("/updatquanxian")
    public AjaxResponse updatquanxian(@Validated @RequestBody Quanxianbiao qx){
        boolean isxgok = qxservice.updatequanxian(qx);
        return AjaxResponse.success(isxgok);
    }
    @DeleteMapping("/deletequanxian")
    public AjaxResponse deletequanxian( int qxbh){
        boolean issc = qxservice.deletequanxian(qxbh);
        return AjaxResponse.success(issc);
    }
    @GetMapping("/injsidfindqxs")
    public AjaxResponse injsidfindqxs(int jsid){
        Map map = qxservice.injiaoseidfindqxs(jsid);
        return AjaxResponse.success(map);
    }
    @GetMapping("/insertjiaoseqx")
    public AjaxResponse insertjiaoseqx( int jsid, int [] qxs){

        Boolean jg = qxservice.insertjiaoseqx(jsid, qxs);
        return AjaxResponse.success(jg);
    }
    @GetMapping("/deletejiaoseqx")
    public AjaxResponse deletejiaoseqx(int jsid,int [] qxs){
        System.out.println("进来了");
        Boolean jg = qxservice.deletejiaoseqx(jsid, qxs);
        return AjaxResponse.success(jg);
    }
}
