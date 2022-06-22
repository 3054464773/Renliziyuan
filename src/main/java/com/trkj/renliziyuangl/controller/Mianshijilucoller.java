package com.trkj.renliziyuangl.controller;

import com.trkj.renliziyuangl.service.Mianshi;
import com.trkj.renliziyuangl.vo.AjaxResponse;
import com.trkj.renliziyuangl.vo.ZpVo;
import com.trkj.renliziyuangl.vo.rencaiVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Mianshijilucoller {
    @Autowired
    private Mianshi mianshi;
    //入职修改当次面试状态
    @PostMapping("insetmsjl/{mjbh}")
    public AjaxResponse insetmsjl(@PathVariable("mjbh") int mjbh){
        System.out.println("===========2222222222222"+mjbh);
        return AjaxResponse.success(mianshi.msjl(mjbh));
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
    @GetMapping("xiugaimszt/{mjbh}")
    public AjaxResponse xiugaimszt(@PathVariable("mjbh") int mjbh){
        System.out.println("===========2222222222222"+mjbh);
        return AjaxResponse.success(mianshi.xiugaimszt(mjbh));
    }
}




































