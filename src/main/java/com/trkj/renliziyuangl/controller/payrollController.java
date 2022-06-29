package com.trkj.renliziyuangl.controller;

import com.trkj.renliziyuangl.service.payrollService;
import com.trkj.renliziyuangl.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@Slf4j
public class payrollController {
    @Autowired
    private payrollService service;
    @GetMapping("/selectEmpInfo")
    public AjaxResponse selectEmpInfo(int pageNum,int pageSize){
        return AjaxResponse.success(service.selectEmpInfo(pageNum,pageSize));
    }

    @GetMapping("/selectEmpInfoByMonth")
    public AjaxResponse selectEmpInfoByMonth(int pageNum, int pageSize, String szjlsj){
        return AjaxResponse.success(service.selectEmpInfoByMonth(pageNum,pageSize,szjlsj));
    }

    @GetMapping("/selectEmpInfoByBmmc")
    public AjaxResponse selectEmpInfoByBmmc(int pageNum,int pageSize,String bmmc){
        return AjaxResponse.success(service.selectEmpInfoByBmmc(pageNum,pageSize,bmmc));
    }

    @GetMapping("/selectEmpInfoByName")
    public AjaxResponse selectEmpInfoByName(int pageNum,int pageSize,String rzname){
     return AjaxResponse.success(service.selectEmpInfoByName(pageNum,pageSize,rzname))   ;
    }
}
