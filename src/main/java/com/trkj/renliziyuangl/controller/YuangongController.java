package com.trkj.renliziyuangl.controller;

import com.trkj.renliziyuangl.pojo.Yuangongbiao;
import com.trkj.renliziyuangl.service.Loginservice;
import com.trkj.renliziyuangl.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class YuangongController {
        @Autowired
        private Loginservice loginservice;
    
        @PostMapping("/YuangongLogin")
        public AjaxResponse  YuangongLogin(@RequestBody Yuangongbiao yg){
            Map login = loginservice.login(yg);
            return AjaxResponse.success(login);
        }
}
