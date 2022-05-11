package com.trkj.renliziyuangl.controller;

import com.trkj.renliziyuangl.service.GradeService;
import com.trkj.renliziyuangl.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GradeController {

    @Autowired
    private GradeService service;

    //查询员工列表
    @GetMapping("/findAllEmp")
    public AjaxResponse findAllEmp(){
        return AjaxResponse.success(service.findAllEmp());
    }

    //根据名称模糊查询
    @GetMapping("/findAllEmpByName")
    public AjaxResponse findAllEmpByName(String rzname){
        return AjaxResponse.success(service.findAllEmpByName(rzname));
    }
}
