package com.trkj.renliziyuangl.controller;

import com.trkj.renliziyuangl.service.Mianshi;
import com.trkj.renliziyuangl.vo.AjaxResponse;
import com.trkj.renliziyuangl.vo.ZpVo;
import com.trkj.renliziyuangl.vo.rencaiVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Mianshijilucoller {
    @Autowired
    private Mianshi mianshi;
    @PostMapping("insetmsjl")
    public AjaxResponse insetmsjl(@RequestBody ZpVo zpVo){
        System.out.println("===========2222222222222"+zpVo);
        return AjaxResponse.success(mianshi.msjl(zpVo));
    }
    @PostMapping("insetmsjlmg")
    public AjaxResponse insetmsjlmg(@RequestBody ZpVo zpVo){
        System.out.println("===========2222222222222"+zpVo);
        return AjaxResponse.success(mianshi.msjlmg(zpVo));
    }
    //预约面试记录
    @PostMapping("insetyymsjlmg")
    public AjaxResponse insetyymsjlmg(@RequestBody rencaiVo rencaiVo){
        System.out.println("===========2222222222222"+rencaiVo);
        return AjaxResponse.success(mianshi.yymsjl(rencaiVo));
    }
}




































