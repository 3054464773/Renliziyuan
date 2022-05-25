package com.trkj.renliziyuangl.controller;

import com.trkj.renliziyuangl.pojo.Shebaojishubiao;
import com.trkj.renliziyuangl.service.ShebaoJishuService;
import com.trkj.renliziyuangl.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShebaojishuController {
    @Autowired
    private ShebaoJishuService shebaoJishuService;

    //查询社保基数信息
    @GetMapping("/cxsbjs")
    public AjaxResponse cxsbjs(int pageNum,int pageSize){
        return AjaxResponse.success(shebaoJishuService.cxshebaojishu(pageNum, pageSize));
    }

    //根据id查询
    @GetMapping("/findbyjsid")
    public AjaxResponse findbyjsid(int sbjsbh){
        return AjaxResponse.success(shebaoJishuService.findjsByid(sbjsbh));
    }

    //模糊查询社保基数信息
    @GetMapping("/cxjsbyname")
    public AjaxResponse cxjsbyname(String sbname){
        return AjaxResponse.success(shebaoJishuService.cxjsbyname(sbname));
    }

    //添加基数表信息
    @PostMapping("/insertjsxx")
    public AjaxResponse insertjsxx(@RequestBody Shebaojishubiao sbjsb){
        return AjaxResponse.success(shebaoJishuService.insertjsxx(sbjsb));
    }

    //修改基数信息
    @PutMapping("/updatejsxx")
    public AjaxResponse updatejsxx(@RequestBody Shebaojishubiao sbjsb){
        System.out.println(sbjsb+"12345678");
        return AjaxResponse.success(shebaoJishuService.updatejsxx(sbjsb));
    }

    //删除基数信息
    @DeleteMapping("/deletejsxx")
    public AjaxResponse deletejsxx(int sbjsbh){
        return AjaxResponse.success(shebaoJishuService.deletejsxx(sbjsbh));
    }
}
