package com.trkj.renliziyuangl.controller;

import com.trkj.renliziyuangl.service.ZhiWeiService;
import com.trkj.renliziyuangl.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZhiWeiController {
    @Autowired
    private ZhiWeiService zwservice;

    @GetMapping("/findallzw")
    public AjaxResponse findallbm(int ym){
        return AjaxResponse.success(zwservice.findallzw(ym));
    }
}
