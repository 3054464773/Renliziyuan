package com.trkj.renliziyuangl.controller;

import com.trkj.renliziyuangl.service.SalaryService;
import com.trkj.renliziyuangl.vo.AjaxResponse;
import com.trkj.renliziyuangl.vo.job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalaryController {

    @Autowired
    private SalaryService service;

    @GetMapping("/findAllBasePay")
    public AjaxResponse findAllBasePay(int pageNum,int pageSize){
        return AjaxResponse.success(service.findAllBasePay(pageNum,pageSize));
    }

    @GetMapping("/findAllBasePayByName")
    public AjaxResponse findAllBasePayByName(int pageNum,int pageSize,String rzname){
        return AjaxResponse.success(service.findAllBasePayByName(pageNum,pageSize,rzname));
    }

    @GetMapping("/findAllPositionSalary")
    public AjaxResponse findAllPositionSalary(int pageNum,int pageSize){
        return AjaxResponse.success(service.findAllPositionSalary(pageNum,pageSize));
    }

    @GetMapping("/findAllPositionSalaryByZwmc")
    public AjaxResponse findAllPositionSalaryByZwmc(int pageNum,int pageSize,String zwmc){
        return AjaxResponse.success(service.findAllPositionSalaryByZwmc(pageNum,pageSize,zwmc));
    }

    @GetMapping("/selectPositionSalaryByXzjbbh")
    public AjaxResponse selectPositionSalaryByXzjbbh(int xzjbbh){
        return AjaxResponse.success(service.selectPositionSalaryByXzjbbh(xzjbbh));
    }

    @PutMapping("/updatePositionSalaryByXzjbbh")
    public AjaxResponse updatePositionSalaryByXzjbbh(@RequestBody job vo){
        return AjaxResponse.success(service.updatePositionSalaryByXzjbbh(vo));
    }
}
