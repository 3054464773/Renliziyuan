package com.trkj.renliziyuangl.service;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.trkj.renliziyuangl.dao.JiaoseqianduanbiaoDao;
import com.trkj.renliziyuangl.dao.QianduanbiaoDao;
import com.trkj.renliziyuangl.dao.UserandroleDao;
import com.trkj.renliziyuangl.dao.YuangongbiaoDao;
import com.trkj.renliziyuangl.exception.CustomError;
import com.trkj.renliziyuangl.exception.CustomErrorType;
import com.trkj.renliziyuangl.pojo.*;
import com.trkj.renliziyuangl.untli.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LoginserviceImpl implements Loginservice {
    @Autowired
    YuangongbiaoDao ygdao;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private UserandroleDao urdao;
    @Autowired
    private JiaoseqianduanbiaoDao jsdao;
    @Autowired
    private QianduanbiaoDao qddao;
    //用户登录
    @Override
    public Map login(Yuangongbiao ygb) {
        UsernamePasswordAuthenticationToken upat=new UsernamePasswordAuthenticationToken(ygb.getYzh(),ygb.getYmm());
        Authentication authenticate = authenticationManager.authenticate(upat);
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        Yuangongbiao yhb = loginUser.getYhb();
        String token = jwtTokenUtil.generateToken(yhb.getYzh(), yhb.getYbh() + "");
        redisTemplate.opsForValue().set("user"+yhb.getYbh(),loginUser);
        String name = ygdao.byidfindYgname(yhb.getYbh());
        Map map=new HashMap();
        map.put("token",token);
        map.put("yname",name);
        //查看动态菜单路由
        List<Qianduanbiao> byyhfindqd = this.byyhfindqd(yhb.getYbh());
        System.out.println(byyhfindqd.size()+"集合大小");
        System.out.println(byyhfindqd.toString());
        map.put("dtly",JSON.toJSONString(byyhfindqd));
        return map;
    }
    //用户退出
    @Override
    public void logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Yuangongbiao yhb = loginUser.getYhb();
        int ybh = yhb.getYbh();
        redisTemplate.delete("user"+ybh);
    }

    @Override
    public List<Qianduanbiao> byyhfindqd(int yhid) {
        LambdaQueryWrapper<Userandrole> qw=new LambdaQueryWrapper<>();
        qw.eq(Userandrole::getYbh,yhid);
        //拿到员工对应的角色
        List<Userandrole> userandroles = urdao.selectList(qw);
        Set<Integer> set=new HashSet();
        for (Userandrole userandrole : userandroles) {
            LambdaQueryWrapper<Jiaoseqianduanbiao> qw2=new LambdaQueryWrapper();
            qw2.eq(Jiaoseqianduanbiao::getJsid,userandrole.getJsbh());
            List<Jiaoseqianduanbiao> jiaoseqianduanbiaos = jsdao.selectList(qw2);
            for (Jiaoseqianduanbiao jiaoseqianduanbiao : jiaoseqianduanbiaos) {
                set.add(jiaoseqianduanbiao.getQdid());
            }
        }
        Set<Qianduanbiao> set2 =new HashSet<>();
        for (int o : set) {
            Qianduanbiao qianduanbiao = qddao.selectById(o);
            LambdaQueryWrapper<Qianduanbiao> qw3=new LambdaQueryWrapper<>();
            qw3.eq(Qianduanbiao::getQdbid,qianduanbiao.getQdfjid());
            Qianduanbiao qianduanbiao1 = qddao.selectOne(qw3);
            set2.add(qianduanbiao);
            set2.add(qianduanbiao1);
        }
        List<Qianduanbiao> list=new ArrayList<>();
        for (Qianduanbiao qianduanbiao : set2) {
            list.add(qianduanbiao);

        }
        return list;
    }
}
