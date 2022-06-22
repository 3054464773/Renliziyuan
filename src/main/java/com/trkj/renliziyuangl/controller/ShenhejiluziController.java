package com.trkj.renliziyuangl.controller;

import com.trkj.renliziyuangl.service.ShenhejiluziService;
import com.trkj.renliziyuangl.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShenhejiluziController {
    @Autowired
    private ShenhejiluziService shservice;

    @GetMapping("/findshenhegz")
    public AjaxResponse findshenhegz(int ym){
        return AjaxResponse.success(shservice.findshenhegz(ym));
    }
}
