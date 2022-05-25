package com.trkj.renliziyuangl.controller;

import com.trkj.renliziyuangl.service.ShenhesxqxService;
import com.trkj.renliziyuangl.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
