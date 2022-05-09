package com.trkj.renliziyuangl.controller;

import com.trkj.renliziyuangl.service.UsersVoService;
import com.trkj.renliziyuangl.vo.AjaxResponse;
import com.trkj.renliziyuangl.vo.usersssVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserssVoConller {
    @Autowired
    private UsersVoService usersVoService;
    @GetMapping("/mohuRenyygg")
    public AjaxResponse mohuRenyygg(String rzname){
        System.out.println("1111111111111"+rzname);
        List<usersssVo> usersssVo=usersVoService.mohuchaxunygg(rzname);

        return AjaxResponse.success(usersssVo);

    }
    @GetMapping("/mohuchaxunyghmd")
    public AjaxResponse mohuchaxunyghmd(String rzname){
        System.out.println("1111111111111"+rzname);
        List<usersssVo> usersssVo=usersVoService.mohuchaxunyghmd(rzname);
        return AjaxResponse.success(usersssVo);
    }
}
