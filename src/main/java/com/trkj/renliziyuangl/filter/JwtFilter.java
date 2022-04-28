package com.trkj.renliziyuangl.filter;


import com.trkj.renliziyuangl.exception.CustomError;
import com.trkj.renliziyuangl.exception.CustomErrorType;
import com.trkj.renliziyuangl.pojo.LoginUser;
import com.trkj.renliziyuangl.untli.JwtTokenUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Component
public class JwtFilter extends OncePerRequestFilter {
    @Resource
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        /** Token 验证 */
        String token = request.getHeader(jwtTokenUtil.getHeader());
        System.out.println("token"+token);
        if("null".equals(token)||jwtTokenUtil.isTokenExpired(token)){
           filterChain.doFilter(request,response);
           return;
        }

        String userIdFromToken = jwtTokenUtil.getUserIdFromToken(token);
        if (StringUtils.isEmpty(userIdFromToken)){
            throw  new CustomError(CustomErrorType.SYSTEM_ERROR,"身份异常！");
        }
        LoginUser loginUser= (LoginUser) redisTemplate.opsForValue().get("user" + userIdFromToken);
        if (Objects.isNull(loginUser)){
            throw  new CustomError(CustomErrorType.SYSTEM_ERROR,"请重新登录！");
        }
        UsernamePasswordAuthenticationToken upat=new UsernamePasswordAuthenticationToken(loginUser,null,loginUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(upat);
        filterChain.doFilter(request,response);
    }
}
