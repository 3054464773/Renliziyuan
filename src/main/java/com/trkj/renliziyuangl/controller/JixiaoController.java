package com.trkj.renliziyuangl.controller;

import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.pojo.Jixiaobiao;
import com.trkj.renliziyuangl.service.JixiaoService;
import com.trkj.renliziyuangl.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@RestController
public class JixiaoController {

    @Autowired
    private JixiaoService service;

    @GetMapping("/findJixiao")
    public AjaxResponse findJixiao(int pageNum, int pageSize){
        PageInfo<Jixiaobiao> info=service.findJixiao(pageNum,pageSize);
        return AjaxResponse.success(info);
    }

    @PostMapping("/insertJixiao")
    public AjaxResponse insertJixiao(@RequestBody Jixiaobiao vo){
        return AjaxResponse.success(service.insertJixiao(vo));
    }

    @PutMapping("/updateJixiao")
    public AjaxResponse updateJixiao(@RequestBody Jixiaobiao vo){
        return AjaxResponse.success(service.updateJixiao(vo));
    }

    @GetMapping("/findJixiaoById")
    public AjaxResponse findJixiaoById( int jbh){
        return AjaxResponse.success(service.findJixiaoById(jbh));
    }

    @DeleteMapping("/deleteJixiao")
    public AjaxResponse deleteJixiao(int jbh){
        return AjaxResponse.success(service.deleteJixiao(jbh));
    }

    @GetMapping("/findJixiaoByName")
    public AjaxResponse findJixiaoByName(int page,String jmc){
        return AjaxResponse.success(service.findJixiaoByName(page,jmc));
    }

    @GetMapping("/findGrade")
    public AjaxResponse findGrade(int pageNum,int pageSize){
        PageInfo<gradeVo> info=service.findGrade(pageNum,pageSize);
        return AjaxResponse.success(info);
    }

    @GetMapping("/findGradeByJxsj")
    public AjaxResponse findGradeByJxsj(int pageNum,int pageSize, String jxsj){
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        return AjaxResponse.success(service.findGradeByJxsj(pageNum,pageSize,jxsj));
    }

    @GetMapping("/findGrade2")
    public AjaxResponse findGrade2(int pageNum,int pageSize){
        return AjaxResponse.success(service.findGrade2(pageNum,pageSize));
    }

    @GetMapping("/findGrade2ByName")
    public AjaxResponse findGrade2ByName(int pageNum,int pageSize,String rzname){
        return AjaxResponse.success(service.findGrade2ByName(pageNum,pageSize,rzname));
    }

    @GetMapping("/findGradeByJxbh")
    private AjaxResponse findGradeByJxbh(int jxbh){
        return AjaxResponse.success(service.findGradeByJxbh(jxbh));
    }

    @PutMapping("/updataGradePf")
    public AjaxResponse updataGradePf(@RequestBody grade2Vo vo){
        return AjaxResponse.success(service.updataGradePf(vo));
    }

    @PutMapping("/updateGrade")
    public AjaxResponse updateGrade(@RequestBody gradeVo grade){
        return AjaxResponse.success(service.updateGrade(grade));
    }

    @GetMapping("findGradeById")
    public AjaxResponse findGradeById(int jbh){
        return AjaxResponse.success(service.findGradeById(jbh));
    }

    @DeleteMapping("/deleteGrade")
    public AjaxResponse deleteGrade(int jxbh){
        return AjaxResponse.success(service.deleteGrade(jxbh));
    }

    @GetMapping("/findAllScore")
    public AjaxResponse findAllScore(){
        List<scoreVo> echarts=service.findAllScore();

        System.out.println(echarts);
        HashMap<String,Object> res=new HashMap<>();
        List<String> name=new ArrayList<>();
        List<Integer> num=new ArrayList<>();
        for(int i=0;i<echarts.size();i++){
            name.add(echarts.get(i).getJdjb());
            num.add(echarts.get(i).getEmpCount());
            System.out.println(echarts.get(i).getEmpCount()+"===============================");
        }
        res.put("name",name);
        res.put("num",num);
        System.out.println(res);
        return AjaxResponse.success(res);
    }

    @GetMapping("/findAllScoreByBmbh")
    public AjaxResponse findAllScoreByBmbh(int bmbh){
        List<scoreVo> echarts=service.findAllScoreByBmbh(bmbh);

        System.out.println(echarts);
        HashMap<String,Object> res=new HashMap<>();
        List<String> name=new ArrayList<>();
        List<Integer> num=new ArrayList<>();
        for(int i=0;i<echarts.size();i++){
            name.add(echarts.get(i).getJdjb());
            num.add(echarts.get(i).getEmpCount());
            System.out.println(echarts.get(i).getEmpCount()+"===============================");
        }
        res.put("name",name);
        res.put("num",num);
        System.out.println(res);
        return AjaxResponse.success(res);
    }

    @GetMapping("/findGradeByName")
    public AjaxResponse findGradeByName(int pageNum,int pageSize,String rzname){
        return AjaxResponse.success(service.findGradeByName(pageNum,pageSize,rzname));
    }

    @GetMapping("/findAllScoreByJxsj")
    public AjaxResponse findAllScoreByJxsj(String jxsj){
        List<scoreVo> echarts=service.findAllScoreByJxsj(jxsj);

        System.out.println(echarts);
        HashMap<String,Object> res=new HashMap<>();
        List<String> name=new ArrayList<>();
        List<Integer> num=new ArrayList<>();
        for(int i=0;i<echarts.size();i++){
            name.add(echarts.get(i).getJdjb());
            num.add(echarts.get(i).getEmpCount());
            System.out.println(echarts.get(i).getEmpCount()+"===============================");
        }
        res.put("name",name);
        res.put("num",num);
        System.out.println(res);
        return AjaxResponse.success(res);
    }
}