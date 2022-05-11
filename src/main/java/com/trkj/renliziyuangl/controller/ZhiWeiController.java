package com.trkj.renliziyuangl.controller;

import com.trkj.renliziyuangl.pojo.Bumenbiao;
import com.trkj.renliziyuangl.pojo.Zhiweibiao;
import com.trkj.renliziyuangl.service.ZhiWeiService;
import com.trkj.renliziyuangl.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class ZhiWeiController {
    @Autowired
    private ZhiWeiService zwservice;

    @GetMapping("/findallzw")
    public AjaxResponse findallbm(int ym){
        return AjaxResponse.success(zwservice.findallzw(ym));
    }

    @GetMapping("/mohufindallzw")
    public AjaxResponse mohufindallzw(int page,String zwname){
        return AjaxResponse.success(zwservice.mohufindzw(page,zwname));
    }
    @PostMapping("/insertzw")
    public AjaxResponse insertzw(@Validated @RequestBody Zhiweibiao zw){
        boolean insertbm = zwservice.insertzw(zw);
        return AjaxResponse.success(insertbm);
    }
    @PutMapping("/updatzw")
    public AjaxResponse updatzw(@Validated @RequestBody  Zhiweibiao zw){
        boolean isxgok = zwservice.updatezw(zw);
        return AjaxResponse.success(isxgok);
    }
}
