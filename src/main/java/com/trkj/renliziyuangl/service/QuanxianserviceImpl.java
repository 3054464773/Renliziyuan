package com.trkj.renliziyuangl.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.renliziyuangl.dao.QuanxianbiaoDao;
import com.trkj.renliziyuangl.pojo.Quanxianbiao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuanxianserviceImpl implements Quanxianservice {
    @Autowired
    private QuanxianbiaoDao qxdao;
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
        return true;
    }
    //给角色移除权限
    @Override
    public Boolean deletejiaoseqx(int jsid, int[] qxid) {
        for (int i : qxid) {

            qxdao.deletejiaoseqx(jsid,i);
        }
        return true;
    }
}
