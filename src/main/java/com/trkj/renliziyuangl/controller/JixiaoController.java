package com.trkj.renliziyuangl.controller;

import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.pojo.Jixiaobiao;
import com.trkj.renliziyuangl.service.JixiaoService;
import com.trkj.renliziyuangl.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class JixiaoController {

    @Autowired
    private JixiaoService service;

    @GetMapping("/findJixiao")
    public AjaxResponse findJixiao(int pageNum, int pageSize){
        PageInfo<Jixiaobiao> info=service.findJixiao(pageNum,pageSize);
        return AjaxResponse.success(info);
    }

    @PostMapping("/insertJixiao")
    public AjaxResponse insertJixiao(@RequestBody Jixiaobiao vo){
        return AjaxResponse.success(service.insertJixiao(vo));
    }

    @PutMapping("/updateJixiao")
    public AjaxResponse updateJixiao(@RequestBody Jixiaobiao vo){
        return AjaxResponse.success(service.updateJixiao(vo));
    }

    @GetMapping("/findJixiaoById")
    public AjaxResponse findJixiaoById( int jbh){
        return AjaxResponse.success(service.findJixiaoById(jbh));
    }

    @DeleteMapping("/deleteJixiao")
    public AjaxResponse deleteJixiao(int jbh){
        return AjaxResponse.success(service.deleteJixiao(jbh));
    }

}
