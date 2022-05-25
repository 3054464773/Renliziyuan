package com.trkj.renliziyuangl.controller;

import com.trkj.renliziyuangl.pojo.Mianshiguizhanzibiao;
import com.trkj.renliziyuangl.service.Mianshi;
import com.trkj.renliziyuangl.service.MianshiwentiService;
import com.trkj.renliziyuangl.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    @PutMapping("xiugaigzz")
    public AjaxResponse xiugai(@RequestBody Mianshiguizhanzibiao mianshigzVo){
        return AjaxResponse.success(mianshiwentiService.xiugaigzz(mianshigzVo));
    }
    @GetMapping("/mianshiwenti/{zwbh}/{rid}")
    public AjaxResponse mianshiwenti(@PathVariable("zwbh") int zwbh,@PathVariable("rid")int rid){
        System.out.println(zwbh);
        System.out.println(rid);
        List<Mianshiguizhanzibiao>  list=mianshiwentiService.mianshiwenti(zwbh,rid);
        return AjaxResponse.success(list) ;
    }
    @PostMapping("/tianjiawt")
    public AjaxResponse tianjiawt(@RequestBody Mianshiguizhanzibiao mianshiguizhanzibiao){
            return AjaxResponse.success(mianshiwentiService.insertmz(mianshiguizhanzibiao));
    }
}
