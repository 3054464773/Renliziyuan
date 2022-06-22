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
//    @GetMapping("/mohuguizhan")
//    public AjaxResponse mohuguizhan(int page,String rzname){
//        System.out.println(rzname);
//        return AjaxResponse.success(mianshiguizhangService.mohuguizhan(page,rzname));
//    }
    @GetMapping("/mohuguizhan")
    public AjaxResponse mohuguizhan(int pageNum, int pageSize, String mmc){

        return AjaxResponse.success(mianshiguizhangService.mohuchaxunguiz(pageNum,pageSize,mmc));
    }
    @PostMapping("insertmsgz")
    public AjaxResponse insert(@RequestBody MianshigzVo mianshigzVo){
        return AjaxResponse.success(mianshiguizhangService.insetmsgz(mianshigzVo));
    }
  @GetMapping("guizhangzhiwei")
    public AjaxResponse guizhangzhiwei(){
        return  AjaxResponse.success(mianshiguizhangService.guizhangzhiwei());
  }
    @GetMapping("/bumenguiz")
    public AjaxResponse bumenguiz(int pageNum, int pageSize, String bmmc){

        return AjaxResponse.success(mianshiguizhangService.bumenguiz(pageNum,pageSize,bmmc));
    }
    @GetMapping("/bumenzpjh")
    public AjaxResponse bumenzpjh(int pageNum, int pageSize, String bmmc){

        return AjaxResponse.success(mianshiguizhangService.bumenzpjh(pageNum,pageSize,bmmc));
    }
    @GetMapping("/mohuzpjh")
    public AjaxResponse mohuzpjh(int pageNum, int pageSize,String zmc){
        System.out.println("传过来了"+zmc);
        return AjaxResponse.success(mianshiguizhangService.mohuzpjh(pageNum,pageSize,zmc));
    }
}
