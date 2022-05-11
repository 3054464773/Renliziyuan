package com.trkj.renliziyuangl.controller;

import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.pojo.Zhaopingjihuabiao;
import com.trkj.renliziyuangl.service.ZpjhService;
import com.trkj.renliziyuangl.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ZpjhCotroller {
    @Autowired
    private ZpjhService zpjhService;
    @PostMapping("/delectzhb/{zbh}")
    public AjaxResponse delete(@PathVariable("zbh")int zbh){
        return  AjaxResponse.success(zpjhService.deleteById(zbh));
    }
    @GetMapping("/findszpjh")
    public AjaxResponse findszpjh(int pageNum,int pageSize){
        PageInfo<Zhaopingjihuabiao> pageInfo=zpjhService.findszpjh(pageNum,pageSize);
        return AjaxResponse.success(pageInfo);
    }
    //添加
    @PostMapping("/addzpjh")
    public AjaxResponse addzpjh(@RequestBody Zhaopingjihuabiao zhaopingjihuabiao){
        return AjaxResponse.success(zpjhService.tianjiazpjh(zhaopingjihuabiao));
    }
    //根据id查找
    @GetMapping("/findzpjhid/{zbh}")
    public AjaxResponse findzpjhid(@PathVariable("zbh") int zbh){
        return AjaxResponse.success(zpjhService.idchaxun(zbh));
    }
    //修改
    @PutMapping("/xxxxgai")
    public AjaxResponse xiugai(@RequestBody Zhaopingjihuabiao zhaopingjihuabiao){
        return AjaxResponse.success(zpjhService.updataZpjh(zhaopingjihuabiao));
    }
}
