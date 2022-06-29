package com.trkj.renliziyuangl.controller;

import com.trkj.renliziyuangl.pojo.Qianduanbiao;
import com.trkj.renliziyuangl.service.QianduanService;
import com.trkj.renliziyuangl.vo.AjaxResponse;
import com.trkj.renliziyuangl.vo.Xinzengcaidan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QianduanController {
    @Autowired
    private QianduanService qdservice;

    @GetMapping("/findallqd")
    public AjaxResponse findallqd(String qdfjid,int ym,String cxtj){
        return AjaxResponse.success(qdservice.findallqd(qdfjid,ym,cxtj));
    }

    @PostMapping("/updatecd")
    public AjaxResponse updatecd(@RequestBody Qianduanbiao qd){
        return AjaxResponse.success(qdservice.updatecd(qd));
    }
    @PostMapping("/insertcd")
    public AjaxResponse insertcd(@RequestBody Qianduanbiao cdstl){
        return AjaxResponse.success(qdservice.insertcd(cdstl));
    }

    @GetMapping("/findallqdym")
    public AjaxResponse findallqdym(String cxtj){
        return AjaxResponse.success(qdservice.findallqdym(cxtj));
    }

    @GetMapping("/shanchucd")
    public AjaxResponse shanchucd(int jsid,int qdid){
        return AjaxResponse.success(qdservice.shanchucd(jsid,qdid));
    }
    @PostMapping ("/chaxunwfpcd")
    public AjaxResponse chaxunwfpcd(@RequestBody List<Qianduanbiao> qdlist){
        return AjaxResponse.success(qdservice.chaxunwfpcd(qdlist));
    }
    @PostMapping("/xinzengcaidan")
    public AjaxResponse xinzengcaidan(@RequestBody Xinzengcaidan fpcdlist){
        return AjaxResponse.success(qdservice.xinzengcaidan(fpcdlist));
    }
}
