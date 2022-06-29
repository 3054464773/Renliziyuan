package com.trkj.renliziyuangl.controller;

import com.trkj.renliziyuangl.pojo.Shenghebiao;
import com.trkj.renliziyuangl.service.ShengsheService;
import com.trkj.renliziyuangl.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShengheController {
    @Autowired
    private ShengsheService shservice;

    @GetMapping("/findallshenhe")
    public AjaxResponse findallshenhe(String shname,int ym){
        return AjaxResponse.success(shservice.findallshenhe(shname,ym));
    }

    @PostMapping("/insertshenhe")
    public AjaxResponse insertshenhe(@RequestBody Shenghebiao sh){
            return AjaxResponse.success(shservice.insertshenhe(sh));
    }

    @DeleteMapping("/deleteshenhe/{id}")
    public AjaxResponse deleteshenhe(@PathVariable("id") int id){
        return AjaxResponse.success(shservice.deleteshenhe(id));
    }
    @GetMapping("shenheneir")
    public AjaxResponse shenheneir(){
        return AjaxResponse.success(shservice.shenheneir());
    }

}
