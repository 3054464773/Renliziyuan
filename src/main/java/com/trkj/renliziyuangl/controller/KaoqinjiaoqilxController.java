package com.trkj.renliziyuangl.controller;

import com.trkj.renliziyuangl.pojo.Kaoqinjiaqilxbiao;
import com.trkj.renliziyuangl.service.KaoqinjiaqilxService;
import com.trkj.renliziyuangl.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KaoqinjiaoqilxController {
    @Autowired
    private KaoqinjiaqilxService kqservice;


    @GetMapping("/findkqlx")
    public AjaxResponse findkqlx(int ym,String cxtj){
        return AjaxResponse.success(kqservice.findkqlx(ym,cxtj));
    }

    @PostMapping("/insertkqlx")
    public AjaxResponse insertkqlx(@RequestBody Kaoqinjiaqilxbiao kqbiao){
        return AjaxResponse.success(kqservice.insertkqlx(kqbiao));
    }

    @GetMapping("/shanchu")
    public AjaxResponse shanchu(int jqid){
        return AjaxResponse.success(kqservice.shanchu(jqid));
    }
}
