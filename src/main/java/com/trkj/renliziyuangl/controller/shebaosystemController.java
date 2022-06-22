package com.trkj.renliziyuangl.controller;

import com.trkj.renliziyuangl.pojo.Bumenbiao;
import com.trkj.renliziyuangl.pojo.Shebaofananbiao;
import com.trkj.renliziyuangl.pojo.Shebaojishubiao;
import com.trkj.renliziyuangl.pojo.Yuangongbiao;
import com.trkj.renliziyuangl.service.shebaosystemService;
import com.trkj.renliziyuangl.vo.AjaxResponse;
import com.trkj.renliziyuangl.vo.ShebaofaVo;
import com.trkj.renliziyuangl.vo.canbaoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class shebaosystemController {
    @Autowired
    private shebaosystemService sbservice;

    //查询所有数据(班次表)
    @GetMapping("/selectList")
    public AjaxResponse selectList(int pageNum,int pageSize){
        List list = sbservice.findBancb(pageNum, pageSize);
        return AjaxResponse.success(list);
    }

    //查询社保方案
    @GetMapping("/cxsbfa")
    public AjaxResponse cxsbfa(int pageNum,int pageSize){
        return AjaxResponse.success(sbservice.cxsbfa(pageNum, pageSize));
    }

    //查询所有的社保方案（具体）
    @GetMapping("/selectsbfa")
    public AjaxResponse selectsbfa(int sbbh){
        return AjaxResponse.success(sbservice.selectsbfa(sbbh));
    }

    //根据社保方案的id或名称模糊查询其信息
    @GetMapping("/cxfabidorname")
    public AjaxResponse cxfabidorname(String sbmc){
        return AjaxResponse.success(sbservice.cxsbidorname(sbmc));
    }

    //查询社保基数表信息，用于显示新增社保方案的级联菜单
    @GetMapping("/selectsbjsxx")
    public AjaxResponse selectsbjsxx(Shebaojishubiao sbjsb){
        return AjaxResponse.success(sbservice.selectsbjsxx(sbjsb));
    }

    //新增社保方案
    @PostMapping("/insertsbfa")
    public AjaxResponse insertsbfa(@RequestBody ShebaofaVo sbvo){
        System.out.println(sbvo+"1111111111111");
        return AjaxResponse.success(sbservice.insertsbfa(sbvo));
    }

    //删除社保方案
    @GetMapping("/deletesbfa")
    public AjaxResponse deletesbfa(int sbbh){
        return AjaxResponse.success(sbservice.deletesbfa(sbbh));
    }

    //查询参保人员信息--实习员工
    @GetMapping("/selectcbryxxSx")
    public AjaxResponse selectcbryxxSx(int pageNum,int pageSize){
        return AjaxResponse.success(sbservice.cxcbrySx(pageNum, pageSize));
    }

    //查询参保人员信息--正式员工
    @GetMapping("/selectcbryxxZs")
    public AjaxResponse selectcbryxxZs(int pageNum,int pageSize){
        return AjaxResponse.success(sbservice.cxcbryZs(pageNum, pageSize));
    }

    //查询社保缴费信息
    @GetMapping("/selectsbjfxx")
    public AjaxResponse selectsbjfxx(int pageNum,int pageSize){
        return AjaxResponse.success(sbservice.cxsbjf(pageNum, pageSize));
    }

    //修改社保状态
    @PutMapping("/xgzt")
    public AjaxResponse xgzt(@RequestBody Shebaofananbiao fab){
        return AjaxResponse.success(sbservice.updatesbzt(fab));
    }

    //通过员工姓名模糊查询其员工信息（参保人员）--实习员工
    @GetMapping("/selectygBynamesx")
    public AjaxResponse selectygBynamesx(String rzname){
        return AjaxResponse.success(sbservice.cxygbynamesx(rzname));
    }

    //通过员工姓名模糊查询其员工信息（参保人员）--正式员工
    @GetMapping("/selectygByname")
    public AjaxResponse selectygByname(String rzname){
        return AjaxResponse.success(sbservice.cxygbyname(rzname));
    }

    //通过员工姓名模糊查询其员工信息（社保缴费）
    @GetMapping("/selectygByname1")
    public AjaxResponse selectygByname1(String rzname){
        return AjaxResponse.success(sbservice.cxygbyname1(rzname));
    }

    //根据员工id查询员工信息
    @GetMapping("/selectygxx")
    public AjaxResponse selectygxx(int ybh){
        return AjaxResponse.success(sbservice.cxygxx(ybh));
    }

    //查询社保状态为1的方案，用于给在职员工参保
    @GetMapping("/selectsbfaByzt")
    public AjaxResponse selectsbfaByzt(Shebaofananbiao fab){
        return AjaxResponse.success(sbservice.cxsbfaByzt(fab));
    }

    //给正式员工（员工状态为3）未参保的人员设置社保方案
    @PostMapping("/xzygsb")
    public AjaxResponse xzygsb(@RequestBody Yuangongbiao ygb){
        System.out.println(ygb);
        return AjaxResponse.success(sbservice.updateygsb(ygb));
    }

    //修改社保方案
    @PutMapping("/xgsbfa")
    public  AjaxResponse xgsbfa(@RequestBody ShebaofaVo favo){
        System.out.println("社保方案："+favo);
        return AjaxResponse.success(sbservice.updatesbfa(favo));
    }

    //查询部门表信息
    @GetMapping("/selectdept")
    public AjaxResponse selectdept(){
        return AjaxResponse.success(sbservice.cxdept());
    }

    //根据部门id查询员工信息（社保缴费）
    @GetMapping("/selectygbybhid")
    public AjaxResponse selectygbybhid(int bmbh){
        return AjaxResponse.success(sbservice.findygxxBybmbh(bmbh));
    }

    //根据部门id查询员工信息（未参保人员缴费--实习员工（ygzt=2））
    @GetMapping("/selectygbybhid1")
    public AjaxResponse selectygbybhid1(int bmbh){
        return AjaxResponse.success(sbservice.findygxxBybmbh1(bmbh));
    }

    //根据部门id查询员工信息（未参保人员缴费--正式员工（ygzt=3））
    @GetMapping("/selectygbybhid2")
    public AjaxResponse selectygbybhid2(int bmbh){
        return AjaxResponse.success(sbservice.findygxxBybmbh2(bmbh));
    }

    //判断社保基数所被绑定的条数
    @GetMapping("/pdsbjsCount")
    public AjaxResponse pdsbjsCount(int sbjsbh){
        return AjaxResponse.success(sbservice.sbjsCount(sbjsbh));
    }

    //社保方案判断（删除，修改状态）
    @GetMapping("/pdsbfaCount")
    public AjaxResponse pdsbfaCount(int sbbh){
        return AjaxResponse.success(sbservice.sbfaCount(sbbh));
    }
}
