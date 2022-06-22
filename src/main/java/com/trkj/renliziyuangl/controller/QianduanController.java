package com.trkj.renliziyuangl.controller;

import com.trkj.renliziyuangl.pojo.Qianduanbiao;
import com.trkj.renliziyuangl.service.QianduanService;
import com.trkj.renliziyuangl.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QianduanController {
    @Autowired
    private QianduanService qdservice;

    @GetMapping("/findallqd")
    public AjaxResponse findallqd(int ym,String cxtj){
        return AjaxResponse.success(qdservice.findallqd(ym,cxtj));
    }

    @PostMapping("/updatecd")
    public AjaxResponse updatecd(@RequestBody Qianduanbiao qd){
        return AjaxResponse.success(qdservice.updatecd(qd));
    }
    @PostMapping("/insertcd")
    public AjaxResponse insertcd(@RequestBody Qianduanbiao cdstl){
        return AjaxResponse.success(qdservice.insertcd(cdstl));
    }
}
