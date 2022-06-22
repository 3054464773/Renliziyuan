package com.trkj.renliziyuangl.controller;

import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.pojo.Yuangongbiao;
import com.trkj.renliziyuangl.pojo.Yuangonggzjlbiao;
import com.trkj.renliziyuangl.service.Userservice;
import com.trkj.renliziyuangl.vo.AjaxResponse;

import com.trkj.renliziyuangl.vo.UsersXinZiVo;
import com.trkj.renliziyuangl.vo.ZpVo;
import com.trkj.renliziyuangl.vo.usersssVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private Userservice userservice;
    //根据id查找
    @GetMapping("/findcxid/{ybh}")
    public AjaxResponse findcxid(@PathVariable("ybh") int ybh){
        System.out.println("111111111111"+ybh);
        return AjaxResponse.success(userservice.findUserById(ybh));
    }
    //根据id查找
    @GetMapping("/user/{ybh}")
    public AjaxResponse findUserById(@PathVariable("ybh") int ybh){
            Yuangongbiao userById = userservice.findUserById(ybh);
            List<Yuangongbiao> list=new ArrayList<>();
            list.add(userById);
            return AjaxResponse.success(list);
        }
    //查询所有以及分页
    @GetMapping("/findusers")
    public AjaxResponse findusers(int pageNum,int pageSize){
        PageInfo<Yuangongbiao> info=userservice.findusers(pageNum,pageSize);
        return AjaxResponse.success(info);
    }
    //修改
    @PutMapping("/user")
    public AjaxResponse user(@RequestBody Yuangongbiao userVo){
        System.out.println(userVo);
        return AjaxResponse.success(userservice.updateUser(userVo));
    }
    //根据id删除
  @PostMapping("/delete/{ybh}")
    public AjaxResponse delete(@PathVariable("ybh")int ybh){
    return  AjaxResponse.success(userservice.deleteById(ybh));
  }
  //修改员工状态
  @GetMapping ("/xgtgrz")
  public AjaxResponse xgtgrz(int yhb){
      System.out.println("66666"+yhb);
        return AjaxResponse.success(userservice.xiugairuzhi(yhb));
  }
  //添加
  @PostMapping("/adddept")
    public AjaxResponse adddept(@RequestBody Yuangongbiao userVo){
      System.out.println(userVo);
        return AjaxResponse.success(userservice.insersUsers(userVo));
  }
    //查询所有以及分页
    @GetMapping("/finduserssss")
    public AjaxResponse finduserssss(int pageNum,int pageSize){
        PageInfo<usersssVo> info=userservice.finduserssss(pageNum,pageSize);
        return AjaxResponse.success(info);
    }
    @GetMapping("/findusersx")
    public AjaxResponse findusersx(int pageNum,int pageSize){
        PageInfo<usersssVo> info=userservice.findusersx(pageNum,pageSize);
        return AjaxResponse.success(info);
    }

    //查询员工薪资信息
    @GetMapping("/findusersxinzi/{ybh}")
    public AjaxResponse findxinzi(@PathVariable("ybh") int ybh){
        return AjaxResponse.success(userservice.findxinzi(ybh));
    }
    //黑名单
    @GetMapping("/findusershmd")
    public AjaxResponse findusershmd(int pageNum,int pageSize){
        PageInfo<usersssVo> info=userservice.findusershmd(pageNum, pageSize);
        return  AjaxResponse.success(info);
    }
    //未到岗员工
    @GetMapping("/findwdg")
    public AjaxResponse findwdg(int pageNum,int pageSize){
        PageInfo<usersssVo> info=userservice.findwdg(pageNum,pageSize);
        return  AjaxResponse.success(info);
    }

    //查询离职员工
    @GetMapping("/finduserslz")
    public AjaxResponse finduserslz(int pageNum,int pageSize){
        PageInfo<usersssVo> info=userservice.finduserslz(pageNum,pageSize);
        return  AjaxResponse.success(info);
    }
    //查询入职时间员工
    @GetMapping("/ruzhishijian")
    public AjaxResponse ruzhishijian(int pageNum, int pageSize,String ygrzsj){
        System.out.println("进来啦入职时间为"+ygrzsj);
        return  AjaxResponse.success(userservice.ruzhishijian(pageNum,pageSize,ygrzsj));
    }
    @GetMapping("/ruzhishijianhmd")
    public AjaxResponse ruzhishijianhmd(int pageNum, int pageSize,String ygrzsj){
        System.out.println("进来啦入职时间为"+ygrzsj);
        return  AjaxResponse.success(userservice.ruzhishijianhmd(pageNum,pageSize,ygrzsj));
    }
    @GetMapping("/ruzhishijianlz")
    public AjaxResponse ruzhishijianlz(int pageNum, int pageSize,String ygrzsj){
        System.out.println("进来啦入职时间为"+ygrzsj);
        return  AjaxResponse.success(userservice.ruzhishijianlz(pageNum,pageSize,ygrzsj));
    }
    @GetMapping("/ruzhishijiansx")
    public AjaxResponse ruzhishijiansx(int pageNum, int pageSize,String ygrzsj){
        System.out.println("进来啦入职时间为"+ygrzsj);
        return  AjaxResponse.success(userservice.ruzhishijiansx(pageNum,pageSize,ygrzsj));
    }

    //通过面试入职的员工
    @PostMapping("/ruzhiyg")
    public AjaxResponse ruzhiyg(@RequestBody ZpVo zpVo){
        System.out.println("入职员工成功"+zpVo);
        return AjaxResponse.success(userservice.rzyg(zpVo));
    }
    //查询在职员工部门
    @GetMapping("/bumenccxx")
    public AjaxResponse bumenccxx(int pageNum,int pageSize,String bmmc){
        System.out.println("进来了部门"+bmmc);
        return  AjaxResponse.success(userservice.bumenchauxn(pageNum,pageSize,bmmc));
    }
    @GetMapping("/bumenchauxnlz")
    public AjaxResponse bumenchauxnlz(int pageNum,int pageSize,String bmmc){

        return  AjaxResponse.success(userservice.bumenchauxnlz(pageNum,pageSize,bmmc));
    }
    @GetMapping("/bumenchauxnhmd")
    public AjaxResponse bumenchauxnhmd(int pageNum,int pageSize,String bmmc){

        return  AjaxResponse.success(userservice.bumenchauxnhmd(pageNum,pageSize,bmmc));
    }
    @GetMapping("/bumenchauxwbd")
    public AjaxResponse bumenchauxwbd(int pageNum,int pageSize,String bmmc){
        return  AjaxResponse.success(userservice.bumenchauxwbd(pageNum,pageSize,bmmc));
    }
    @GetMapping("/bumenchauxsx")
    public AjaxResponse bumenchauxsx(int pageNum,int pageSize,String bmmc){
        return  AjaxResponse.success(userservice.bumenchauxsx(pageNum,pageSize,bmmc));
    }
    @PostMapping("/zzsq")
    public AjaxResponse zzsq(@RequestBody Yuangonggzjlbiao yuangongbiao){
        return AjaxResponse.success(userservice.zzsq(yuangongbiao));
    }

}
