package com.trkj.renliziyuangl.controller;

import com.trkj.renliziyuangl.pojo.Nashuibiao;
import com.trkj.renliziyuangl.service.NashuiService;
import com.trkj.renliziyuangl.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class NashuiController {
    @Autowired
    private NashuiService nashuiService;

    //查询纳税信息
    @GetMapping("/selectnashuixx")
    public AjaxResponse selectnashuixx(int pageNum,int pageSize){
        return AjaxResponse.success(nashuiService.cxnashuixx(pageNum, pageSize));
    }

    //新增纳税信息
    @PostMapping("/insertnashuixx")
    public AjaxResponse insertnashuixx(@RequestBody Nashuibiao nsb){
        return AjaxResponse.success(nashuiService.insertnashui(nsb));
    }

    //根据id查询纳税信息
    @GetMapping("/cxnashuibyid")
    public AjaxResponse cxnashuibyid(int nsbbh){
        return AjaxResponse.success(nashuiService.cxnsxxbyid(nsbbh));
    }

    //根据纳税缴纳比例模糊查询纳税信息
    @GetMapping("/mhcxnsxx")
    public AjaxResponse mhcxnsxx(String nsjnbl){
        return AjaxResponse.success(nashuiService.mohucxns(nsjnbl));
    }

    //修改纳税
    @PutMapping("/updatensxx")
    public AjaxResponse updatensxx(@RequestBody Nashuibiao nsb){
        return AjaxResponse.success(nashuiService.xgnashuixx(nsb));
    }

    //删除纳税
    @DeleteMapping("/deletensxx")
    public AjaxResponse deletensxx(int nsbbh){
        return AjaxResponse.success(nashuiService.scnashuixx(nsbbh));
    }

}
