package com.trkj.renliziyuangl.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.renliziyuangl.dao.QuanxianbiaoDao;
import com.trkj.renliziyuangl.dao.YuangongbiaoDao;
import com.trkj.renliziyuangl.pojo.LoginUser;
import com.trkj.renliziyuangl.pojo.Quanxianbiao;
import com.trkj.renliziyuangl.untli.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuanxianserviceImpl implements Quanxianservice {
    @Autowired
    private QuanxianbiaoDao qxdao;
    @Autowired
    private YuangongbiaoDao dao;
    @Autowired
    private RedisTemplate redisTemplate;
    //查询所以权限
    @Override
    public Map findallquanxian(int ym) {
//        List<Quanxianbiao> quanxianbiaos = qxdao.selectList(null);
        Page<Quanxianbiao> page=new Page<>(ym,8);
        LambdaQueryWrapper<Quanxianbiao> qw=new LambdaQueryWrapper<>();
        qw.orderByDesc(Quanxianbiao::getQxbh);
        Page<Quanxianbiao> page1 = qxdao.selectPage(page, qw);
        List<Quanxianbiao> records = page1.getRecords();
        Map map=new HashMap();
        map.put("qxlist",records);
        map.put("zys",page1.getPages());
        return map;
    }
    //通过权限名称模糊查询
    @Override
    public Map mohufindquanxian(int ym,String qxname) {
        Page<Quanxianbiao> page=new Page<>(ym,8);
        LambdaQueryWrapper<Quanxianbiao> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Quanxianbiao::getQxmc,qxname).orderByDesc(Quanxianbiao::getQxbh);
        Page<Quanxianbiao> page1 = qxdao.selectPage(page, lambdaQueryWrapper);
        Map map=new HashMap();
        map.put("qxlist",page1.getRecords());
        map.put("zys",page1.getPages());
        return map;
    }
    //添加权限
    @Override
    public boolean insertquanxian(Quanxianbiao qx) {
        int insert = qxdao.insert(qx);
        return insert>0?true:false;
    }
    //修改权限

    @Override
    public boolean updatequanxian(Quanxianbiao qx) {
        int jg = qxdao.updateById(qx);
        return jg>0?true:false;
    }
    //删除权限

    @Override
    public boolean deletequanxian(int id) {
        int i = qxdao.deleteById(id);
        return i>0?true:false;
    }
    //通过角色id查询已拥有和为拥有权限

    @Override
    public Map injiaoseidfindqxs(int jsid) {
        Map map=new HashMap();
        List<Quanxianbiao> injsidfindqxs = qxdao.injsidfindqxs(jsid);
        //存储已拥有
        map.put("yyy",injsidfindqxs);
        List<Quanxianbiao> quanxianbiaos = qxdao.selectList(null);
        for (Quanxianbiao injsidfindqx : injsidfindqxs) {
            quanxianbiaos.remove(injsidfindqx);
        }
        //存储为拥有的权限
        map.put("wyy",quanxianbiaos);
        return map;
    }
    //给角色分配权限
    @Override
    public Boolean insertjiaoseqx(int jsid, int[] qxid) {
        for (int i : qxid) {
            qxdao.insertjiaoseqx(jsid,i);
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        List<String> qxlist = dao.chaxunquanxina(loginUser.getYhb().getYbh());
        loginUser.setQuanxian(qxlist);
        List<GrantedAuthority> qx=new ArrayList<>();
        for (String s : qxlist) {
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(s);
            qx.add(simpleGrantedAuthority);
        }
        loginUser.setQxlist(qx);
        redisTemplate.opsForValue().set("user" +loginUser.getYhb().getYbh(),loginUser);
//        UsernamePasswordAuthenticationToken upat=new UsernamePasswordAuthenticationToken(loginUser,null,loginUser.getAuthorities());
//        SecurityContextHolder.getContext().setAuthentication(upat);

        return true;
    }
    //给角色移除权限
    @Override
    public Boolean deletejiaoseqx(int jsid, int[] qxid) {
        for (int i : qxid) {

            qxdao.deletejiaoseqx(jsid,i);
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        List<String> qxlist = dao.chaxunquanxina(loginUser.getYhb().getYbh());
        loginUser.setQuanxian(qxlist);
        List<GrantedAuthority> qx=new ArrayList<>();
        for (String s : qxlist) {
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(s);
            qx.add(simpleGrantedAuthority);
        }
        loginUser.setQxlist(qx);
        redisTemplate.opsForValue().set("user" +loginUser.getYhb().getYbh(),loginUser);
//        UsernamePasswordAuthenticationToken upat=new UsernamePasswordAuthenticationToken(loginUser,null,loginUser.getAuthorities());
//        SecurityContextHolder.getContext().setAuthentication(upat);


        return true;
    }
}
