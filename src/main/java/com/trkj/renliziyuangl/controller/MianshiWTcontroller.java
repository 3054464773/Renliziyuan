package com.trkj.renliziyuangl.controller;

import com.trkj.renliziyuangl.pojo.Mianshiguizhanzibiao;
import com.trkj.renliziyuangl.service.Mianshi;
import com.trkj.renliziyuangl.service.MianshiwentiService;
import com.trkj.renliziyuangl.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
public class MianshiWTcontroller {
    @Autowired
    private MianshiwentiService mianshiwentiService;
        @GetMapping("/mianshizi/{mbh}")
    public AjaxResponse mianshizi(@PathVariable("mbh") int mbh){
            List<Mianshiguizhanzibiao> list=mianshiwentiService.mianshizi(mbh);
            System.out.println(mbh);
        return AjaxResponse.success(list) ;
    }
    @PostMapping("/shanchu/{mbh}")
    public AjaxResponse shanchu(@PathVariable("mbh") int mbh){
        System.out.println(mbh);
        return AjaxResponse.success(mianshiwentiService.deleteById(mbh)) ;
    }
    @PostMapping("/sahnchumianshiwenti/{mzbh}")
    public AjaxResponse shanchuwenti(@PathVariable("mzbh") int mzbh){
            return  AjaxResponse.success(mianshiwentiService.shanchuwenti(mzbh));

    }
    @PutMapping("xiugaigzz")
    public AjaxResponse xiugai(@RequestBody Mianshiguizhanzibiao mianshigzVo){
        return AjaxResponse.success(mianshiwentiService.xiugaigzz(mianshigzVo));
    }
    //预约面试
    @GetMapping("/mianshiwenti/{zwbh}/{rid}/{ybh}/{mjsj}")
    public AjaxResponse mianshiwenti(@PathVariable("zwbh") int zwbh,@PathVariable("rid")int rid,@PathVariable("ybh") int ybh, @PathVariable("mjsj")Date mjsj){
        System.out.println(zwbh);
        System.out.println(rid);
        System.out.println(ybh);
        System.out.println(mjsj);
        List<Mianshiguizhanzibiao>  list=mianshiwentiService.mianshiwenti(zwbh,rid,ybh,mjsj);
        return AjaxResponse.success(list) ;
    }
    //添加面试问题
    @PostMapping("/tianjiawt")
    public AjaxResponse tianjiawt(@RequestBody Mianshiguizhanzibiao mianshiguizhanzibiao){
            return AjaxResponse.success(mianshiwentiService.insertmz(mianshiguizhanzibiao));
    }
    //复试
    @GetMapping("/fushi/{rid}/{ybh}/{mjsj}/{mjbh}/{mspj}")
    public AjaxResponse fushi(@PathVariable("rid")int rid,@PathVariable("ybh") int msyg, @PathVariable("mjsj")Date mjsj,@PathVariable("mjbh")int mjbh,@PathVariable("mspj")String mspj){
        System.out.println(rid);
        System.out.println(msyg);
        System.out.println(mjsj);
        System.out.println("jinlail"+mjbh);
        System.out.println("面试评价"+mspj);
        return AjaxResponse.success(mianshiwentiService.mianshiwentitt(rid,mjsj,msyg,mjbh,mspj));
    }
//    @GetMapping("/fushi/{mzbh}/{rid}/{ybh}/{mjsj}/{mjbh}/{mspj}")
//    public AjaxResponse fushi(@PathVariable("mzbh") int mzbh,@PathVariable("rid")int rid,@PathVariable("ybh") int msyg, @PathVariable("mjsj")Date mjsj,@PathVariable("mjbh")int mjbh,@PathVariable("mspj")String mspj){
//        System.out.println(mzbh);
//        System.out.println(rid);
//        System.out.println(msyg);
//        System.out.println(mjsj);
//        System.out.println(mjbh);
//        System.out.println("面试评价"+mspj);
//        return AjaxResponse.success(mianshiwentiService.mianshiwentitt(mzbh,rid,mjsj,msyg,mjbh,mspj));
//    }
}
