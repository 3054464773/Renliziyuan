package com.trkj.renliziyuangl.controller;

import com.trkj.renliziyuangl.pojo.Yuangongbiao;
import com.trkj.renliziyuangl.vo.AjaxResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class YuangongController {
        @PostMapping("/YuangongLogin")
        public AjaxResponse  YuangongLogin(@RequestBody Yuangongbiao yg){
            System.out.println(yg.getYzh()+yg.getYmm());
            return AjaxResponse.success();
        }
}
