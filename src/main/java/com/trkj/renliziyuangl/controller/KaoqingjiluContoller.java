package com.trkj.renliziyuangl.controller;

import com.trkj.renliziyuangl.service.KaoqingjiluService;
import com.trkj.renliziyuangl.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KaoqingjiluContoller {
    @Autowired
    private KaoqingjiluService kqservice;

    @GetMapping("/findkaoqin")
    public AjaxResponse findkaoqin(String rzname,String bmmc,String dkzt,String xzsj,int ym){
        System.out.println(xzsj + "AAAAAAAAAAAAAAAA");
        return AjaxResponse.success(kqservice.findkaoqin(rzname,bmmc,dkzt,xzsj,ym));
    }
}
