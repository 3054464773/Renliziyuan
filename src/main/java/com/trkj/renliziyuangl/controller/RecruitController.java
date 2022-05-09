package com.trkj.renliziyuangl.controller;

import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.pojo.Rencaizibiao;
import com.trkj.renliziyuangl.service.RecruitService;
import com.trkj.renliziyuangl.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RecruitController {
    @Autowired
    private RecruitService recruitService;
    //分页查询
    @GetMapping("/selectRecruit")
    public AjaxResponse selectRecruit(int pageNum, int pageSize){
        PageInfo<Rencaizibiao> info=recruitService.selectRecruit(pageNum,pageSize);
        return AjaxResponse.success(info);
    }
    //根据id查询
    @GetMapping("/selectid/{rzbh}")
    public AjaxResponse selectid(@PathVariable("rzbh") int rzbh){
        Rencaizibiao rencaizibiaos=recruitService.selectid(rzbh);
        List<Rencaizibiao> list=new ArrayList<>();
        list.add(rencaizibiaos);
        return AjaxResponse.success(list);
    }
    //根据id查询
    @GetMapping("/selectidd/{rzbh}")
    public AjaxResponse selectidd(@PathVariable("rzbh") int rzbh){
        System.out.println(rzbh);
        return AjaxResponse.success(recruitService.selectid(rzbh));
    }
    //修改
    @PutMapping("/updata")
    public AjaxResponse updata(@RequestBody Rencaizibiao rencaizibiao){
        System.out.println("修改11111111111"+rencaizibiao);
   return AjaxResponse.success(recruitService.updataRecruit(rencaizibiao));
    }
    //删除
    @PostMapping("/delecte/{rzbh}")
    public AjaxResponse delect(@PathVariable("rzbh") int rzbh){
        System.out.println("删除2222222"+rzbh);
        return AjaxResponse.success(recruitService.deleteById(rzbh));
    }
    //添加
    @PostMapping("insert")
    public AjaxResponse insert(@RequestBody Rencaizibiao rencaizibiao){
       return AjaxResponse.success(recruitService.insertRecruit(rencaizibiao));
    }
    //模糊查询
    @GetMapping("/mohuRencaizibiao")
    public AjaxResponse mohuRencaizibiao(int page,String rzname){
        System.out.println(rzname);
        return AjaxResponse.success(recruitService.mohuRencaizibiao(page,rzname));
    }
}
