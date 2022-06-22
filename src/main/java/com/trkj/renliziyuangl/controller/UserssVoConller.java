package com.trkj.renliziyuangl.controller;

import com.github.pagehelper.PageInfo;
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
    public AjaxResponse mohuRenyygg(int pageNum, int pageSize, String rzname,String rzsex){
        System.out.println("1111111111111"+rzname);
        return AjaxResponse.success(usersVoService.mohuchaxunygg(pageNum,pageSize,rzname,rzsex));

    }
    @GetMapping("/mohuchaxunyghmd")
    public AjaxResponse mohuchaxunyghmd(int pageNum, int pageSize, String rzname,String rzsex){
        System.out.println("1111111111111"+rzname);

        return AjaxResponse.success(usersVoService.mohuchaxunyghmd(pageNum,pageSize,rzname,rzsex));
    }
    @GetMapping("/mohuchaxunyglz")
    public AjaxResponse mohuchaxunyglz(int pageNum, int pageSize, String rzname,String rzsex){
        System.out.println("1111111111111"+rzname);
        return AjaxResponse.success(usersVoService.mohuchaxunyglz(pageNum,pageSize,rzname,rzsex));

    }
    @GetMapping("/mohuchaxunygwbd")
    public AjaxResponse mohuchaxunygwbd(int pageNum, int pageSize, String rzname,String rzsex){
        System.out.println("1111111111111"+rzname);

        return AjaxResponse.success(  usersVoService.mohuchaxunygwbd(pageNum,pageSize,rzname,rzsex));
    }
    @GetMapping("/mohuchaxunygsx")
    public AjaxResponse mohuchaxunygsx(int pageNum, int pageSize, String rzname,String rzsex){
        System.out.println("1111111111111"+rzname);
        System.out.println("1111111111111"+rzsex);

        return AjaxResponse.success(  usersVoService.mohuchaxunygsx(pageNum,pageSize,rzname,rzsex));
    }

}
