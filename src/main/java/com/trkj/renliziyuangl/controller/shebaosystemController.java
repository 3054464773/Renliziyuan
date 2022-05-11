package com.trkj.renliziyuangl.controller;

import com.trkj.renliziyuangl.pojo.Shebaofananbiao;
import com.trkj.renliziyuangl.pojo.Shebaojishubiao;
import com.trkj.renliziyuangl.service.shebaosystemService;
import com.trkj.renliziyuangl.vo.AjaxResponse;
import com.trkj.renliziyuangl.vo.canbaoryVo;
import com.trkj.renliziyuangl.vo.ShebaofaVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class shebaosystemController {
    @Autowired
    private shebaosystemService sbservice;
    //查询所有数据(班次表)
    @GetMapping("/selectList")
    public AjaxResponse selectList(int pageNum,int pageSize){
        List list = sbservice.findBancb(pageNum, pageSize);
        return AjaxResponse.success(list);
    }
    //查询社保方案
    @GetMapping("/cxsbfa")
    public AjaxResponse cxsbfa(Shebaofananbiao fa){
        List cxsbfa = sbservice.cxsbfa(fa);
        return AjaxResponse.success(cxsbfa);
    }
    //查询所有的社保方案（具体）
    @GetMapping("/selectsbfa")
    public AjaxResponse selectsbfa(int sbbh){
        return AjaxResponse.success(sbservice.selectsbfa(sbbh));
    }
    //根据社保方案的id或名称模糊查询其信息
    @GetMapping("/cxfabidorname")
    public AjaxResponse cxfabidorname(String sbmc){
        return AjaxResponse.success(sbservice.cxsbidorname(sbmc));
    }
    //查询社保基数表信息，用于显示新增社保方案的级联菜单
    @GetMapping("/selectsbjsxx")
    public AjaxResponse selectsbjsxx(Shebaojishubiao sbjsb){
        return AjaxResponse.success(sbservice.selectsbjsxx(sbjsb));
    }
    //新增社保方案
    @PostMapping("/insertsbfa")
    public AjaxResponse insertsbfa(@RequestBody ShebaofaVo sbvo){
        System.out.println(sbvo+"1111111111111");
        return AjaxResponse.success(sbservice.insertsbfa(sbvo));
    }
    //删除社保方案
    @DeleteMapping("/deletesbfa")
    public AjaxResponse deletesbfa(int sbbh){
        return AjaxResponse.success(sbservice.deletesbfa(sbbh));
    }
    //查询参保人员信息
    @GetMapping("/selectcbryxx")
    public AjaxResponse selectcbryxx(canbaoryVo cbry){
        return AjaxResponse.success(sbservice.cxcbry(cbry));
    }
}
