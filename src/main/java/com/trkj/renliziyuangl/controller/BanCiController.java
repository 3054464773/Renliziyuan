package com.trkj.renliziyuangl.controller;

import com.trkj.renliziyuangl.pojo.Bancibiao;
import com.trkj.renliziyuangl.service.BanCiService;
import com.trkj.renliziyuangl.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BanCiController {
    @Autowired
    private BanCiService banCiService;

    @PostMapping("/insertbanci")
    public AjaxResponse insertbanci(@RequestBody Bancibiao bcbiao){
        return AjaxResponse.success(banCiService.insertbanci(bcbiao));
    }

    @GetMapping("/findbanci")
    public AjaxResponse findbanci(int ym){
        return AjaxResponse.success(banCiService.findbanci(ym));
    }

    @DeleteMapping("/shanchubanci/{bcid}")
    public AjaxResponse shanchubanci(@PathVariable("bcid") int bcid){
        return AjaxResponse.success(banCiService.shanchubanci(bcid));
    }

    @PutMapping("/xiugaibanci")
    public AjaxResponse xiugaibanci(@RequestBody Bancibiao bcbiao2){

        return AjaxResponse.success(banCiService.xiugaibanci(bcbiao2));
    }
}
