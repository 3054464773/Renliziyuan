package com.trkj.renliziyuangl.controller;


import com.trkj.renliziyuangl.pojo.Bumenbiao;
import com.trkj.renliziyuangl.pojo.Jiaosebiao;
import com.trkj.renliziyuangl.pojo.Zhiweibiao;
import com.trkj.renliziyuangl.service.BuMenservice;
import com.trkj.renliziyuangl.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class BuMenController {
    @Autowired
    private BuMenservice buMenservice;

    @GetMapping("/findallbm")
    public AjaxResponse findallbm(int ym){
        return AjaxResponse.success(buMenservice.findallbm(ym));
    }
    @GetMapping("/mohufindallbm")
    public AjaxResponse mohufindallbm(int page,String bmname){
        return AjaxResponse.success(buMenservice.mohufindbm(page,bmname));
    }
    @DeleteMapping("/deletebm")
    public AjaxResponse deletebm( int bmbh){
        String issc = buMenservice.deletebm(bmbh);
        return AjaxResponse.success(issc);
    }
    @PostMapping("/insertbm")
    public AjaxResponse insertbm(@Validated @RequestBody Bumenbiao bm){
        boolean insertbm = buMenservice.insertbm(bm);
        return AjaxResponse.success(insertbm);
    }
    @PutMapping("/updatbm")
    public AjaxResponse updatbm(@Validated @RequestBody  Bumenbiao bm){
        boolean isxgok = buMenservice.updatebm(bm);
        return AjaxResponse.success(isxgok);
    }
    @GetMapping("/inidfindzw")
    public AjaxResponse inidfindzw(int id,int ym){
        Map inidfindzw = buMenservice.inidfindzw(id, ym);
        return AjaxResponse.success(inidfindzw);
    }
    @GetMapping("/suoybumen")
    public AjaxResponse suoybumen(){
        return AjaxResponse.success(buMenservice.bumen());
    }
    @GetMapping("/bububumen")
    public AjaxResponse bububumen(){
        return AjaxResponse.success(buMenservice.bububumen());
    }
    @GetMapping("/bumenmmm")
    public AjaxResponse bumenmmm(){
        return AjaxResponse.success(buMenservice.bumenmmm());
    }


}
