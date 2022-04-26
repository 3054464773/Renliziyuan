package com.trkj.renliziyuangl.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.trkj.renliziyuangl.dao.YuangongbiaoDao;
import com.trkj.renliziyuangl.exception.CustomError;
import com.trkj.renliziyuangl.exception.CustomErrorType;
import com.trkj.renliziyuangl.pojo.LoginUser;
import com.trkj.renliziyuangl.pojo.Yuangongbiao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class Securityservice implements UserDetailsService {
    @Autowired
    private YuangongbiaoDao dao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        LambdaQueryWrapper<Yuangongbiao> qw=new LambdaQueryWrapper<>();
        qw.eq(Yuangongbiao::getYzh,s);
        Yuangongbiao yhb = dao.selectOne(qw);
        if (Objects.isNull(yhb)){
            throw  new CustomError(CustomErrorType.USER_INPUT_ERROR,"用户或密码错误！");
        }
        //查看角色
//        List<String> qxlist = dao.qxlist(userb.getUid());
        List<String> qxlist=new ArrayList<>();
        qxlist.add("a");
        return new LoginUser(yhb,qxlist);
    }
}
