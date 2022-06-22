package com.trkj.renliziyuangl.controller;

import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.pojo.Rencaizibiao;

import com.trkj.renliziyuangl.service.RecruitService;
import com.trkj.renliziyuangl.vo.*;
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
    //分页查询
    @GetMapping("/selectMs")
    public AjaxResponse selectMs(int pageNum, int pageSize){
        PageInfo<rencaiVo> info=recruitService.selectMs(pageNum,pageSize);
        return AjaxResponse.success(info);
    }
    //分页查询
    @GetMapping("/selectMss")
    public AjaxResponse selectMss(int pageNum, int pageSize){
        PageInfo<rencaiVo> info=recruitService.selectMss(pageNum,pageSize);
        return AjaxResponse.success(info);
    }
    //分页查询
    @GetMapping("/selectMsss")
    public AjaxResponse selectMsss(int pageNum, int pageSize){
        PageInfo<ZpVo> info=recruitService.selectMsss(pageNum,pageSize);
        return AjaxResponse.success(info);
    }
    //导入
    @PostMapping("daoru")
    public AjaxResponse daoru(@RequestBody rencaiVo rencaiVo){
        List<rencaiVo> list=recruitService.daoru(rencaiVo);
        return AjaxResponse.success(list);
    }
    //双表添加
    @PostMapping("inserttttt")
    public AjaxResponse inserttttt(@RequestBody rencaiVo rencaiVo){
        System.out.println("传过来了"+rencaiVo);
        return AjaxResponse.success(recruitService.insersyygg(rencaiVo));
    }
//    @PostMapping("inserttttt")
//    public AjaxResponse inserttttt(@RequestBody rencaiVo rencaiVo){
//
//        System.out.println("传过来了"+rencaiVo);
//        return AjaxResponse.success(recruitService.insersyygg(rencaiVo));
//    }
//
    @GetMapping("/mianshijilu/{ybh}")
    public AjaxResponse mianshijilu(@PathVariable("ybh") int ybh){
        return AjaxResponse.success(recruitService.miianshi(ybh));
    }
    @GetMapping("/jixiaojilu/{ybh}")
    public AjaxResponse jixiaojilu(@PathVariable("ybh") int ybh){

        return AjaxResponse.success(recruitService.jixiao(ybh));
    }
    @GetMapping("/kaoqinjilu/{ybh}")
    public AjaxResponse kaoqinjilu(@PathVariable("ybh") int ybh){
        return AjaxResponse.success(recruitService.kaoqin(ybh));
    }
    @GetMapping("/chuchaijilu/{ybh}")
    public AjaxResponse chuchaijilu(@PathVariable("ybh") int ybh){
        return AjaxResponse.success(recruitService.chuchaijjll(ybh));
    }
    //面试官
    @GetMapping("/mianshiguan/{rid}")
    public AjaxResponse mianshiguan(@PathVariable int rid){
        return AjaxResponse.success(recruitService.mianshiguan(rid));
    }
    @GetMapping("/mianshiguaneee")
    public AjaxResponse mianshiguaneee(){
        return AjaxResponse.success(recruitService.mianshiguaneee());
    }


}
