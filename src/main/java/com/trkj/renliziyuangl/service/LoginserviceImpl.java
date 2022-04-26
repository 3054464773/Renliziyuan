package com.trkj.renliziyuangl.service;

import com.alibaba.fastjson.JSON;
import com.trkj.renliziyuangl.dao.YuangongbiaoDao;
import com.trkj.renliziyuangl.exception.CustomError;
import com.trkj.renliziyuangl.exception.CustomErrorType;
import com.trkj.renliziyuangl.pojo.LoginUser;
import com.trkj.renliziyuangl.pojo.Yuangongbiao;
import com.trkj.renliziyuangl.untli.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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
//        map.put("dtly", JSON.toJSONString(zlist));
        return map;
    }
}
