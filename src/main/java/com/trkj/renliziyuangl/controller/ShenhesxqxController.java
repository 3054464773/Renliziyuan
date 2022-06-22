package com.trkj.renliziyuangl.controller;

import com.trkj.renliziyuangl.pojo.Shenhesxqxbiao;
import com.trkj.renliziyuangl.service.ShenhesxqxService;
import com.trkj.renliziyuangl.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShenhesxqxController {
    @Autowired
    private ShenhesxqxService shservice;

    @GetMapping("/findsxqx")
    public AjaxResponse findsxqx(int ym,int shbid){
        return AjaxResponse.success(shservice.findsxqx(ym,shbid));
    }
    @DeleteMapping("/deletesxqx/{id}")
    public AjaxResponse deletesxqx(@PathVariable("id") int id){
        return AjaxResponse.success(shservice.deletesxqx(id));
    }

    @GetMapping("/insertsxqx")
    public AjaxResponse insertsxqx(int id){
        return AjaxResponse.success(shservice.insertsxqx(id));
    }

    @PostMapping("/insertsxqxx")
    public AjaxResponse insertsxqxx(@RequestBody Shenhesxqxbiao shstl2){
        return AjaxResponse.success(shservice.insertsxqxx(shstl2));
    }
}
