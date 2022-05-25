package com.trkj.renliziyuangl.controller;

import com.trkj.renliziyuangl.pojo.Gonggaobiao;
import com.trkj.renliziyuangl.service.GonggaoService;
import com.trkj.renliziyuangl.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GonggaoController {
    @Autowired
    private GonggaoService gonggaoService;


    @PostMapping("/fabugonggao")
    public AjaxResponse fabutongzhi(@RequestBody Gonggaobiao ggbiao){
        return AjaxResponse.success(gonggaoService.fabutongzhi(ggbiao));
    }

    @GetMapping("/findallgg")
    public AjaxResponse findallgg(int page,String cxtj){
        return AjaxResponse.success(gonggaoService.findallgg(page,cxtj));
    }
}
