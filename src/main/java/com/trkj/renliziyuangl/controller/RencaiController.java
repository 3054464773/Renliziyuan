package com.trkj.renliziyuangl.controller;

import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.pojo.Rencaibiao;
import com.trkj.renliziyuangl.service.RencaiService;
import com.trkj.renliziyuangl.vo.AjaxResponse;
import com.trkj.renliziyuangl.vo.interviewVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RencaiController {
    @Autowired
    private RencaiService rencaiService;
    @GetMapping("/selectRencai")
    public AjaxResponse select(int pageNum,int pageSize){
        PageInfo<interviewVo> info=rencaiService.selecd(pageNum,pageSize);
        return AjaxResponse.success(info);
    }
    @GetMapping("/selecdrencai")
    public AjaxResponse selecdrencai(int pageNum,int pageSize){
        PageInfo<Rencaibiao> info=rencaiService.selecdrencai(pageNum,pageSize);
        return AjaxResponse.success(info);
    }
}
