package com.trkj.renliziyuangl.controller;

import com.trkj.renliziyuangl.service.UsersXzService;
import com.trkj.renliziyuangl.vo.AjaxResponse;
import com.trkj.renliziyuangl.vo.UsersXinZiVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserXzcoller {
    @Autowired
    private UsersXzService usersXzService;
    @GetMapping("/mohuchaxunyghxzzz")
    public AjaxResponse mohuchaxunyghxz(String rzname){
        List<UsersXinZiVo> usersXinZiVos=usersXzService.findxinzimohu(rzname);
        return AjaxResponse.success(usersXinZiVos);
    }
}
