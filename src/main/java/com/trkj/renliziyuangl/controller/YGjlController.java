package com.trkj.renliziyuangl.controller;

import com.trkj.renliziyuangl.service.YgjlService;
import com.trkj.renliziyuangl.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class YGjlController {
    @Autowired
    private YgjlService ygjlService;
    @GetMapping("/mohumianshijl")
    public AjaxResponse mohumianshijl(String rzname){
        System.out.println("11111111面试模糊11111"+rzname);
        List<MianshijiluVo> mohumianshijilu=ygjlService.mohumianshijilu(rzname);
        return AjaxResponse.success(mohumianshijilu);

    }
    @GetMapping("/mohuchaxunjxjl")
    public AjaxResponse mohuchaxunjxjl(String rzname){
        System.out.println("1111111绩效模糊111111"+rzname);
        List<JixiaojiluVo> jixiaojiluVos=ygjlService.mohujixiaojilu(rzname);
        return AjaxResponse.success(jixiaojiluVos);
    }
    @GetMapping("/mohuchaxunkqjl")
    public AjaxResponse mohuchaxunkqjl(String rzname){
        System.out.println("11111111考勤记录模糊11111"+rzname);
        List<KaoqinjiluVo> mohumianshijilu=ygjlService.mohukaoqin(rzname);
        return AjaxResponse.success(mohumianshijilu);

    }
    @GetMapping("/mohuchaxunchuchaijl")
    public AjaxResponse mohuchaxunchuchaijl(String rzname){
        System.out.println("11111111考勤记录模糊11111"+rzname);
        List<Chuchaivo> mohumianshijilu=ygjlService.mohuchuchaijjll(rzname);
        return AjaxResponse.success(mohumianshijilu);

    }
}
