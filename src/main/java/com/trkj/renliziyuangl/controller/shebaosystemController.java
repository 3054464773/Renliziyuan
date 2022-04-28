package com.trkj.renliziyuangl.controller;

import com.trkj.renliziyuangl.service.shebaosystemService;
import com.trkj.renliziyuangl.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class shebaosystemController {
    @Autowired
    private shebaosystemService service;
    //查询所有数据
    @GetMapping("/selectList")
    public AjaxResponse selectList(int pageNum,int pageSize){
        List list = service.findBancb(pageNum, pageSize);
        return AjaxResponse.success(list);
    }
}
