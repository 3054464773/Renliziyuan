package com.trkj.renliziyuangl.controller;

import com.trkj.renliziyuangl.pojo.*;
import com.trkj.renliziyuangl.service.YuanGongGeRenService;
import com.trkj.renliziyuangl.vo.AjaxResponse;
import com.trkj.renliziyuangl.vo.YgPhoneVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class YuanGongGeRenController {
    @Autowired
    private YuanGongGeRenService yggrservice;

    //查询所有员工通讯录
    @GetMapping("/cxygphone")
    public AjaxResponse cxygphone(int pageNum,int pageSize){
        return AjaxResponse.success(yggrservice.ygphone(pageNum, pageSize));
    }

    //根据部门查询员工通讯录
    @GetMapping("/cxygtxlbybm")
    public AjaxResponse cxygtxlbybm(int bmbh){
        return AjaxResponse.success(yggrservice.selectygphonebybm(bmbh));
    }

    //根据员工姓名模糊查询员工通讯录
    @GetMapping("/mhcxygtxlbyname")
    public AjaxResponse mhcxygtxlbyname(String rzname){
        return AjaxResponse.success(yggrservice.mohucxygphonebyname(rzname));
    }

    //发表日志
    @PostMapping("/fabiaorz")
    public AjaxResponse fabiaorz(@RequestBody Gongzuorizhibiao gzrzb){
        System.out.println("111"+gzrzb);
        return AjaxResponse.success(yggrservice.fbrizhi(gzrzb));
    }

    //我的日志
    @GetMapping("/meRizhi")
    public AjaxResponse meRizhi(int pageNum,int pageSize){
        return AjaxResponse.success(yggrservice.selectMeRizhi(pageNum,pageSize));
    }

    //已点评日志
    @GetMapping("/yidianpingrz")
    public AjaxResponse yidianpingrz(int pageNum,int pageSize){
        return AjaxResponse.success(yggrservice.selectydprz(pageNum, pageSize));
    }

    //根据员工id查询该员工的考勤记录
    @GetMapping("/cxkqjlByid")
    public AjaxResponse cxkqjlByid(){
        return AjaxResponse.success(yggrservice.selectkqjlbyid());
    }

    //根据员工id查询员工个人绩效记录
    @GetMapping("/cxjxjlByid")
    public AjaxResponse cxjxjlByid(){
        return AjaxResponse.success(yggrservice.selectjixiaobyid());
    }

    //根据员工编号查询员工薪资记录
    @GetMapping("/cxxzjlByid")
    public AjaxResponse cxxzjlByid(){
        return AjaxResponse.success(yggrservice.selectxinzibyid());
    }

    //根据员工编号查询员工薪资记录
    @GetMapping("/cxccjlByid")
    public AjaxResponse cxccjlByid(){
        return AjaxResponse.success(yggrservice.selectchuchaibyid());
    }

    //查询通知
    @GetMapping("/tongzhixx")
    public AjaxResponse tongzhixx(){
        return AjaxResponse.success(yggrservice.selecttongzhi());
    }

    //查询公告
    @GetMapping("/gonggaoxx")
    public AjaxResponse gonggaoxx(){
        return AjaxResponse.success(yggrservice.selectgonggao());
    }

    //根据员工id查询员工个人资料信息
    @GetMapping("/selectgerenzl")
    public AjaxResponse selectgerenzl(){
        return AjaxResponse.success(yggrservice.selectgrzl());
    }

    //修改员工个人资料
    @PutMapping("/updategerenziliao")
    public AjaxResponse updategerenziliao(@RequestBody Rencaizibiao rczb){
        return AjaxResponse.success(yggrservice.xggerenziliao(rczb));
    }

    //根据员工id查询班次信息
    @GetMapping("/cxbcxx")
    public AjaxResponse cxbcxx(){
        return AjaxResponse.success(yggrservice.selectbanci());
    }

    //根据员工id查询当天是否有考勤记录
    @GetMapping("/selectkqjlbyDate")
    public AjaxResponse selectkqjlbyDate(){
        return AjaxResponse.success(yggrservice.cxkqjlbydate());
    }

    //员工打卡
    @PostMapping("/ygdaka")
    public AjaxResponse ygdaka(){
        return AjaxResponse.success(yggrservice.ygdk());
    }

    //员工申请出差
    @PostMapping("/sqchuchai")
    public AjaxResponse sqchuchai(@RequestBody Chuchaibiao ccb){
        return AjaxResponse.success(yggrservice.shenqingchuchai(ccb));
    }

    //查询员工的状态(判断员工是否能申请转正)
    @GetMapping("/selectyuangongzt")
    public AjaxResponse selectyuangongzt(){
        return AjaxResponse.success(yggrservice.cxygzt());
    }

    //查询所有考勤假期类型
    @GetMapping("/selectkqjqlx")
    public AjaxResponse selectkqjqlx(Kaoqinjiaqilxbiao kqjqlxb){
        return AjaxResponse.success(yggrservice.cxkqjqlx(kqjqlxb));
    }

    //申请排休
    @PostMapping("/sqpaixiu")
    public AjaxResponse sqpaixiu(@RequestBody Jiaqishenqibiao jqsqb){
        return AjaxResponse.success(yggrservice.shenqingpaixiu(jqsqb));
    }

    //申请转正
    @PostMapping("/sqzhuanzheng")
    public AjaxResponse sqzhuanzheng(@RequestBody Yuangonggzjlbiao yggzjlb){
        return AjaxResponse.success(yggrservice.shenqingzhuanzheng(yggzjlb));
    }

    //申请离职
    @PostMapping("/sqlizhi")
    public AjaxResponse sqlizhi(@RequestBody Yuangonggzjlbiao yggzjlb){
        return AjaxResponse.success(yggrservice.shenqinglizhi(yggzjlb));
    }

}
