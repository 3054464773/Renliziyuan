package com.trkj.renliziyuangl.controller;

import com.trkj.renliziyuangl.pojo.Jiaosebiao;
import com.trkj.renliziyuangl.pojo.Quanxianbiao;
import com.trkj.renliziyuangl.service.JiaoseserviceImpl;
import com.trkj.renliziyuangl.vo.AjaxResponse;
import com.trkj.renliziyuangl.vo.Fenpeiyhjs;
import com.trkj.renliziyuangl.vo.Jiaoseandquanxianvo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
public class JiaoseController {
    @Autowired
    private JiaoseserviceImpl jsservice;


    @GetMapping("/findalljiaose")
    public AjaxResponse findalljiaose(int page){
        Map map = jsservice.findalljiaose(page);
        return AjaxResponse.success(map);
    }
    @GetMapping("/mohufindalljiaose")
    public AjaxResponse mohufindalljiaose(int page,String jsname){
        return AjaxResponse.success(jsservice.mohufindjiaose(page,jsname));
    }
    @PostMapping("/insertjiaose")
    public AjaxResponse insertjiaose(@Validated @RequestBody Jiaosebiao js){
        boolean isxzok = jsservice.insertjiaose(js);
        return AjaxResponse.success(isxzok);
    }
    @PutMapping("/updatjiaose")
    public AjaxResponse updatjiaose(@Validated @RequestBody Jiaosebiao js){
        boolean isxgok = jsservice.updatejiaose(js);
        return AjaxResponse.success(isxgok);
    }
    @DeleteMapping("/deletejiaose")
    public AjaxResponse deletejiaose( int jsbh){
        boolean issc = jsservice.deletejiaose(jsbh);
        return AjaxResponse.success(issc);
    }

    //查询所有员工角色，分配角色业务
    @GetMapping("/findallygjs")
    public AjaxResponse findallygjs(){
        List<Fenpeiyhjs> findallygjs = jsservice.findallygjs();
        System.out.println("11111"+findallygjs);
        return  AjaxResponse.success(findallygjs);
    }
    //删除员工角色
    @DeleteMapping("/deleteygjs")
    public AjaxResponse deleteygjs(HttpServletRequest request, int ybh, int jsid){
        System.out.println(ybh+jsid+"aaaaaaaaaaaa");
        return AjaxResponse.success(jsservice.deleteygjs(request,ybh,jsid));
    }
    @PostMapping("/findalljs")
    public AjaxResponse findalljs(@RequestBody Fenpeiyhjs js){

        List<Jiaosebiao> jslist = js.getJslist();
        int[] a=new int[jslist.size()];
        for (int i = 0; i < jslist.size(); i++) {
            a[i]=jslist.get(i).getJsbh();
        }
        List<Jiaoseandquanxianvo> findalljs = jsservice.findalljs(a);
        return AjaxResponse.success(findalljs);
    }
    //给用户新增角色
    @PostMapping("/xzyhjs")
    public  AjaxResponse xzyhjs(HttpServletRequest request,@RequestBody Jiaoseandquanxianvo js){
        return AjaxResponse.success(jsservice.insertygjs(request,js));
    }
    //模糊查询
    @GetMapping("/mohufindallygjs")
    public AjaxResponse mohufindallygjs(String cxtj){
        return AjaxResponse.success(jsservice.mohufindallygjs(cxtj));
    }
}
