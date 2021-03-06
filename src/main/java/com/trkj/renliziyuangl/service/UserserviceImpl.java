package com.trkj.renliziyuangl.service;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.dao.ShenhejilubiaoDao;
import com.trkj.renliziyuangl.dao.YuangongbiaoDao;
import com.trkj.renliziyuangl.dao.YuangonggzjlbiaoDao;
import com.trkj.renliziyuangl.pojo.LoginUser;
import com.trkj.renliziyuangl.pojo.Shenhejilubiao;
import com.trkj.renliziyuangl.pojo.Yuangongbiao;
import com.trkj.renliziyuangl.pojo.Yuangonggzjlbiao;
import com.trkj.renliziyuangl.vo.UsersXinZiVo;
import com.trkj.renliziyuangl.vo.ZpVo;
import com.trkj.renliziyuangl.vo.usersssVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserserviceImpl implements Userservice {
    @Autowired
    private YuangongbiaoDao userDao;
    @Autowired
    private YuangonggzjlbiaoDao yyy;
    @Autowired
    private ShenhejilubiaoDao shenhejilubiaoDao;
//根据id查找
    @Override
    public Yuangongbiao findUserById(int ybh) {
        Yuangongbiao userentity = userDao.findUserById(ybh);
        return userentity;
    }
//分页以及查询所有
    @Override
    public PageInfo<Yuangongbiao> findusers(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Yuangongbiao> list = userDao.findusers();
        PageInfo<Yuangongbiao> pageInfo = new PageInfo<>(list);
        System.out.println(pageInfo);
        return pageInfo;
    }

//修改
    @Override
    public Yuangongbiao updateUser(Yuangongbiao userVo) {
        int count=userDao.updateUser(userVo);

        return userVo;
    }

//根据id删除
@Transactional
    @Override
    public int deleteById(int ybh) {
        return   userDao.deleteById(ybh);
    }
//添加
@Transactional
    @Override
    public Yuangongbiao insersUsers(Yuangongbiao userVo) {
        userDao.insersUsers(userVo);

        return userVo;
    }

    @Override
    public PageInfo<usersssVo> finduserssss(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<usersssVo> list = userDao.finduserssss();
        PageInfo<usersssVo> pageInfo = new PageInfo<>(list);
        System.out.println(pageInfo);
        return pageInfo;
    }
    @Override
    public PageInfo<usersssVo> findusersx(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<usersssVo> list = userDao.findusersx();
        PageInfo<usersssVo> pageInfo = new PageInfo<>(list);
        System.out.println(pageInfo);
        return pageInfo;
    }

    //多表查询以及分页
    @Override
    public List<UsersXinZiVo> findxinzi(int ybh) {

        List<UsersXinZiVo> list=userDao.findxinzi(ybh);

        return list;
    }
    //多表查询以及分页
    @Override
    public PageInfo<usersssVo> findusershmd(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<usersssVo> list=userDao.findusershmd();
        PageInfo<usersssVo> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }
//多表查询以及分页
    @Override
    public PageInfo<usersssVo> findwdg(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<usersssVo> list=userDao.findwdg();
        PageInfo<usersssVo> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<usersssVo> finduserslz(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<usersssVo> list=userDao.finduserslz();
        PageInfo<usersssVo> pageInfo=new PageInfo<>(list);
        return  pageInfo;
    }
//查询员工入职时间
    @Override
    public PageInfo<usersssVo> ruzhishijian(int pageNum, int pageSize,String ygrzsj) {
        if(ygrzsj==null){
            PageHelper.startPage(pageNum,pageSize);
            List<usersssVo> list = userDao.finduserssss();
            PageInfo<usersssVo> pageInfo = new PageInfo<>(list);
            System.out.println(pageInfo);
            return pageInfo;
        }else {
            PageHelper.startPage(pageNum,pageSize);
            List<usersssVo> list=userDao.ruzhishijian(ygrzsj);
            PageInfo info=new PageInfo<>(list);
            return info;
        }

    }

    @Override
    public PageInfo<usersssVo> ruzhishijianhmd(int pageNum, int pageSize, String ygrzsj) {
        if(ygrzsj==null){
            PageHelper.startPage(pageNum,pageSize);
            List<usersssVo> list=userDao.findusershmd();
            PageInfo<usersssVo> pageInfo=new PageInfo<>(list);
            return pageInfo;
        }else {
            PageHelper.startPage(pageNum,pageSize);
            List<usersssVo> list=userDao.ruzhishijianhmd(ygrzsj);
            PageInfo info=new PageInfo<>(list);
            return info;
        }

    }

    @Override
    public PageInfo<usersssVo> ruzhishijianlz(int pageNum, int pageSize, String ygrzsj) {
        if(ygrzsj==null){
            PageHelper.startPage(pageNum,pageSize);
            List<usersssVo> list=userDao.finduserslz();
            PageInfo<usersssVo> pageInfo=new PageInfo<>(list);
            return  pageInfo;
        }else {
        PageHelper.startPage(pageNum,pageSize);
        List<usersssVo> list=userDao.ruzhishijianlz(ygrzsj);
        PageInfo info=new PageInfo<>(list);
        return info;
        }
    }
    @Override
    public PageInfo<usersssVo> ruzhishijiansx(int pageNum, int pageSize, String ygrzsj) {
        if(ygrzsj==null){
            PageHelper.startPage(pageNum,pageSize);
            List<usersssVo> list = userDao.findusersx();
            PageInfo<usersssVo> pageInfo = new PageInfo<>(list);
            System.out.println(pageInfo);
            return pageInfo;
        }else {
            PageHelper.startPage(pageNum, pageSize);
            List<usersssVo> list = userDao.ruzhishijiansx(ygrzsj);
            PageInfo info = new PageInfo<>(list);
            return info;
        }
    }

    //修改员工入职状态
    @Transactional
    @Override
    public int xiugairuzhi(int ybh) {
        UpdateWrapper<Yuangongbiao> yg=new UpdateWrapper<>();
        yg.eq("ybh",ybh);
        yg.set("ygrzsj",new Date());
        int aaa=userDao.update(null,yg);
        System.out.println("55555555"+ybh);
    return   userDao.xiugairuzhi(ybh);
    }
//通过面试入职的员工
@Transactional
    @Override
    public int rzyg(ZpVo zpVo) {
        Yuangongbiao a=new Yuangongbiao();
        a.setRzbh(zpVo.getRzbh());
        a.setZwbh(zpVo.getZwbh());
        a.setYgrzsj(new Date());
        a.setBcbh(1);
        String str= String.valueOf(zpVo.getRzsfz());
        System.out.println("账号没为空"+str);
        a.setBcbh(1);
        a.setYzh(str.substring(str.length()-3));
        a.setYmm("$2a$10$Tt7JJkXbioCxvmIt0.VrT.WVYW40LlYKZ6PSBz3/BC.FvLXCApah2");
        a.setYgzt(1);
        a.setYgrzsj(new Date());
        int count=userDao.insert(a);
        return 1;
    }

    @Override
    public PageInfo<usersssVo> bumenchauxn(int pageNum,int pageSize,String bmmc){
        PageHelper.startPage(pageNum,pageSize);
        List<usersssVo> list=userDao.bumenchauxn("%"+bmmc+"%");
        PageInfo info=new PageInfo<>(list);
        return info;
    }

    @Override
    public PageInfo<usersssVo> bumenchauxnhmd(int pageNum,int pageSize,String bmmc) {
        PageHelper.startPage(pageNum,pageSize);
        List<usersssVo> list=userDao.bumenchauxnhmd("%"+bmmc+"%");
        PageInfo info=new PageInfo<>(list);
        return info;
    }

    @Override
    public PageInfo<usersssVo> bumenchauxnlz(int pageNum,int pageSize,String bmmc) {
        PageHelper.startPage(pageNum,pageSize);
        List<usersssVo> list=userDao.bumenchauxnlz("%"+bmmc+"%");
        PageInfo info=new PageInfo<>(list);
        return info;
    }

    @Override
    public PageInfo<usersssVo> bumenchauxwbd(int pageNum,int pageSize,String bmmc) {
        PageHelper.startPage(pageNum,pageSize);
        List<usersssVo> list=userDao.bumenchauxwbd("%"+bmmc+"%");
        PageInfo info=new PageInfo<>(list);
        return info;
    }
    @Override
    public PageInfo<usersssVo> bumenchauxsx(int pageNum,int pageSize,String bmmc) {
        PageHelper.startPage(pageNum,pageSize);
        List<usersssVo> list=userDao.bumenchauxsx("%"+bmmc+"%");
        PageInfo info=new PageInfo<>(list);
        return info;
    }
//员工转正申请
    @Override
    public int zzsq(Yuangonggzjlbiao yuangonggzjlbiao) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Yuangongbiao yhb = loginUser.getYhb();
        Shenhejilubiao l=new Shenhejilubiao();
        l.setShjlbh(yuangonggzjlbiao.getShjlbh());
        l.setShjlsj(new Date());
        l.setShjlzt(3);
        l.setShbid(yuangonggzjlbiao.getShbid());
        l.setYbh(yhb.getYbh());
        int p=shenhejilubiaoDao.insert(l);
        Yuangonggzjlbiao a=new Yuangonggzjlbiao();
        a.setShbid(yuangonggzjlbiao.getShbid());
        a.setShjlbh(l.getShjlbh());
        a.setYbh(yuangonggzjlbiao.getYbh());
        a.setYggzzt(2);
        a.setYggzsj(new Date());
         int ccc=yyy.insert(a);
        return ccc;

    }


}