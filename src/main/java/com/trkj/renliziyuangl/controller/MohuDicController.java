package com.trkj.renliziyuangl.controller;

import com.trkj.renliziyuangl.service.MohudicimianshiServce;
import com.trkj.renliziyuangl.vo.AjaxResponse;
import com.trkj.renliziyuangl.vo.ZpVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class MohuDicController {
    @Autowired
    public MohudicimianshiServce mohudicimianshiServce;
    @GetMapping("mohudiyci")
    public AjaxResponse mohudiyici(int pageNum,int pageSize,String rzname){
        return AjaxResponse.success(mohudicimianshiServce.mohudiyici(pageNum,pageSize,rzname));
    }
}
