//package com.trkj.renliziyuangl.service;
//
//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.trkj.renliziyuangl.exception.CustomError;
//import com.trkj.renliziyuangl.exception.CustomErrorType;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Objects;
//
//@Service
//public class Securityservice implements UserDetailsService {
//    @Autowired
//    private UserbDao dao;
//
//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//
//        LambdaQueryWrapper<Userb> qw=new LambdaQueryWrapper<>();
//        qw.eq(Userb::getUname,s);
//        Userb userb = dao.selectOne(qw);
//        if (Objects.isNull(userb)){
//            throw  new CustomError(CustomErrorType.USER_INPUT_ERROR,"用户或密码错误！");
//        }
//        List<String> qxlist = dao.qxlist(userb.getUid());
//        return new LoginUser(userb,qxlist);
//    }
//}
