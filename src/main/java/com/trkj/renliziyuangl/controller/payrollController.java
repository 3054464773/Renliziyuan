package com.trkj.renliziyuangl.controller;

import com.trkj.renliziyuangl.service.payrollService;
import com.trkj.renliziyuangl.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class payrollController {
    @Autowired
    private payrollService service;

    @GetMapping("/selectEmpInfo")
    public AjaxResponse selectEmpInfo(int pageNum,int pageSize){
        return AjaxResponse.success(service.selectEmpInfo(pageNum,pageSize));
    }
}
