package com.trkj.renliziyuangl.controller;

import com.trkj.renliziyuangl.service.Shenhejiluservice;
import com.trkj.renliziyuangl.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShenHeController {
    @Autowired
    private Shenhejiluservice shenheservice;
    //查询招聘计划
    @GetMapping("/findzpjh")
    public AjaxResponse findzpjh(){
        return AjaxResponse.success(shenheservice.findzpjh());
    }
    //审核招聘计划
    @GetMapping("/shzpjh")
    public AjaxResponse shzpjh(int pdtj,int shjlbh){
        return AjaxResponse.success(shenheservice.shzpjh(pdtj,shjlbh));
    }
    //查询员工转正
    @GetMapping("/findyggzjl")
    public AjaxResponse findyggzjl(){
        return AjaxResponse.success(shenheservice.findyggzjl());
    }
    //审核员工转正
    @GetMapping("/shygzz")
    public AjaxResponse shygzz(int pdtj,int shjlbh,int ygid,int ygzt){
        return  AjaxResponse.success(shenheservice.shygzz(pdtj,shjlbh,ygid,ygzt));
    }
    //查询请假
    @GetMapping("/findqj")
    public AjaxResponse findqj(){
        return AjaxResponse.success(shenheservice.findqj());
    }

    //审核请假
    @GetMapping("/shygqjia")
    public AjaxResponse shygqj(int pdtj,int shjlbh){
        System.out.println(pdtj+"aa"+shjlbh);
        return AjaxResponse.success(shenheservice.shygqj(pdtj,shjlbh));
    }
    //查询出差
    @GetMapping("/findygcc")
    public AjaxResponse findygcc(){
        return AjaxResponse.success(shenheservice.findygcc());
    }
    //审批出差
    @GetMapping("/shygcc")
    public AjaxResponse shygcc(int pdtj,int shjlbh){
        return AjaxResponse.success(shenheservice.shygqj(pdtj,shjlbh));
    }

}
