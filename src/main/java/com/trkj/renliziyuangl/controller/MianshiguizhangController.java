package com.trkj.renliziyuangl.controller;

import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.pojo.Mianshiguizhanbiao;
import com.trkj.renliziyuangl.pojo.Mianshiguizhanzibiao;
import com.trkj.renliziyuangl.pojo.Rencaizibiao;
import com.trkj.renliziyuangl.service.MianshiguizhangService;
import com.trkj.renliziyuangl.vo.AjaxResponse;
import com.trkj.renliziyuangl.vo.MianshigzVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MianshiguizhangController {
    @Autowired
    private MianshiguizhangService mianshiguizhangService;
    @GetMapping("/mianshiguizhang")
    public AjaxResponse mianshiguizhang(int pageNum,int pageSize){
        PageInfo<Mianshiguizhanbiao> pageInfo=mianshiguizhangService.mianshiguizhang(pageNum,pageSize);
        return AjaxResponse.success(pageInfo);

    }
    @GetMapping("/mohuguizhan")
    public AjaxResponse mohuguizhan(int page,String rzname){
        System.out.println(rzname);
        return AjaxResponse.success(mianshiguizhangService.mohuguizhan(page,rzname));
    }
    @PostMapping("insertmsgz")
    public AjaxResponse insert(@RequestBody MianshigzVo mianshigzVo){
        return AjaxResponse.success(mianshiguizhangService.insetmsgz(mianshigzVo));
    }
  @GetMapping("guizhangzhiwei")
    public AjaxResponse guizhangzhiwei(){
        return  AjaxResponse.success(mianshiguizhangService.guizhangzhiwei());
  }
}
