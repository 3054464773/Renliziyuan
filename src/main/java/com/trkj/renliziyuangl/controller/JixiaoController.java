package com.trkj.renliziyuangl.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.pojo.Jixiaobiao;
import com.trkj.renliziyuangl.pojo.Jixiaopinfenbiao;
import com.trkj.renliziyuangl.service.JixiaoService;
import com.trkj.renliziyuangl.vo.AjaxResponse;
import com.trkj.renliziyuangl.vo.gradeVo;
import com.trkj.renliziyuangl.vo.scoreVo;
import com.trkj.renliziyuangl.vo.sheetVo;
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
}