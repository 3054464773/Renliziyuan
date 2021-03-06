package com.trkj.renliziyuangl.controller;

import com.trkj.renliziyuangl.service.MohuJianliService;
import com.trkj.renliziyuangl.vo.AjaxResponse;
import com.trkj.renliziyuangl.vo.rencaiVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class MOhujianliController {
    @Autowired
    public MohuJianliService mohuJianliService;
    @GetMapping("/mohujianli")
    public AjaxResponse mohujianli(int pageNum,int pageSize,String rzname){

        return AjaxResponse.success(mohuJianliService.mohujianli(pageNum,pageSize,rzname));
    }
}
