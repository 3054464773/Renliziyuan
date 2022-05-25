package com.trkj.renliziyuangl.controller;

import com.trkj.renliziyuangl.pojo.Xinziyaosuxiangbiao;
import com.trkj.renliziyuangl.service.SalaryService;
import com.trkj.renliziyuangl.service.salaryElementService;
import com.trkj.renliziyuangl.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class salaryElementController {

    @Autowired
    private salaryElementService service;


    @GetMapping("/findAllSalaryElement")
    public AjaxResponse findAllSalaryElement(int pageNum,int pageSize){
        return AjaxResponse.success(service.findAllSalaryElement(pageNum,pageSize));
    }

    @PostMapping("/insertSalaryElement")
    public AjaxResponse insertSalaryElement(@RequestBody Xinziyaosuxiangbiao vo){
        return AjaxResponse.success(service.insertSalaryElement(vo));
    }

    @GetMapping("/findSalaryElementByYsbh")
    public AjaxResponse findSalaryElementByYsbh(int xzysbh){
        return AjaxResponse.success(service.findSalaryElementByYsbh(xzysbh));
    }

    @PutMapping("/updateSalaryElement")
    public AjaxResponse updateSalaryElement(@RequestBody Xinziyaosuxiangbiao vo){
        return AjaxResponse.success(service.updateSalaryElement(vo));
    }

    @GetMapping("/findSalaryElementByYsmc")
    public AjaxResponse findSalaryElementByYsmc(int pageNum,int pageSize,String xzysmc){
        return AjaxResponse.success(service.findSalaryElementByYsmc(pageNum,pageSize,xzysmc));
    }

    @DeleteMapping("/deleteSalaryElementByYsbh")
    public AjaxResponse deleteSalaryElementByYsbh(int xzysbh){
        return AjaxResponse.success(service.deleteSalaryElementByYsbh(xzysbh));
    }
}
