package com.trkj.renliziyuangl.controller;

import com.trkj.renliziyuangl.pojo.Jiaosebiao;
import com.trkj.renliziyuangl.pojo.Quanxianbiao;
import com.trkj.renliziyuangl.service.JiaoseserviceImpl;
import com.trkj.renliziyuangl.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class JiaoseController {
    @Autowired
    private JiaoseserviceImpl jsservice;

    @GetMapping("/findalljiaose")
    public AjaxResponse findalljiaose(int page){
        Map map = jsservice.findalljiaose(page);
        return AjaxResponse.success(map);
    }
    @GetMapping("/mohufindalljiaose")
    public AjaxResponse mohufindalljiaose(int page,String jsname){
        return AjaxResponse.success(jsservice.mohufindjiaose(page,jsname));
    }
    @PostMapping("/insertjiaose")
    public AjaxResponse insertjiaose(@Validated @RequestBody Jiaosebiao js){
        boolean isxzok = jsservice.insertjiaose(js);
        return AjaxResponse.success(isxzok);
    }
    @PutMapping("/updatjiaose")
    public AjaxResponse updatjiaose(@Validated @RequestBody Jiaosebiao js){
        boolean isxgok = jsservice.updatejiaose(js);
        return AjaxResponse.success(isxgok);
    }
    @DeleteMapping("/deletejiaose")
    public AjaxResponse deletejiaose( int jsbh){
        boolean issc = jsservice.deletejiaose(jsbh);
        return AjaxResponse.success(issc);
    }

}
