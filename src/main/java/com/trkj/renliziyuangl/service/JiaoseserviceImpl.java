package com.trkj.renliziyuangl.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.renliziyuangl.dao.JiaosebiaoDao;
import com.trkj.renliziyuangl.dao.UserandroleDao;
import com.trkj.renliziyuangl.dao.YuangongbiaoDao;
import com.trkj.renliziyuangl.pojo.Jiaosebiao;
import com.trkj.renliziyuangl.pojo.LoginUser;
import com.trkj.renliziyuangl.pojo.Quanxianbiao;
import com.trkj.renliziyuangl.pojo.Userandrole;
import com.trkj.renliziyuangl.untli.JwtTokenUtil;
import com.trkj.renliziyuangl.vo.Fenpeiyhjs;
import com.trkj.renliziyuangl.vo.Jiaoseandquanxianvo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JiaoseserviceImpl implements Jiaoseservice {
    @Autowired
    private JiaosebiaoDao jsdao;
    @Autowired
    private UserandroleDao urdao;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private YuangongbiaoDao dao;

    @Override
    public Map findalljiaose(int page) {
        Page<Jiaosebiao> jiaosebiaoPage = jsdao.selectPage(new Page<>(page, 8), new LambdaQueryWrapper<Jiaosebiao>().orderByDesc(Jiaosebiao::getJsbh));
        Map map=new HashMap();
        map.put("jiaoselist",jiaosebiaoPage.getRecords());
        map.put("zys",jiaosebiaoPage.getPages());
        return map;
    }

    @Override
    public Map mohufindjiaose(int ym, String jsname) {
        Page<Jiaosebiao> page=new Page<>(ym,8);
        LambdaQueryWrapper<Jiaosebiao> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Jiaosebiao::getJsmc,jsname).orderByDesc(Jiaosebiao::getJsbh);
        Page<Jiaosebiao> jiaosebiaoPage = jsdao.selectPage(page, lambdaQueryWrapper);
        Map map=new HashMap();
        map.put("jslist",jiaosebiaoPage.getRecords());
        map.put("zys",jiaosebiaoPage.getPages());
        return map;
    }

    @Override
    public boolean insertjiaose(Jiaosebiao js) {
        int insert = jsdao.insert(js);
        return insert>0?true:false;
    }

    @Override
    public boolean updatejiaose(Jiaosebiao js) {
        int jg = jsdao.updateById(js);
        return jg>0?true:false;
    }

    @Override
    public boolean deletejiaose(int id) {
        int i = jsdao.deleteById(id);
        return i>0?true:false;
    }
    //查询所角色有员工
    @Override
    public  List<Fenpeiyhjs> findallygjs() {
        List<Fenpeiyhjs> findallygjs = jsdao.findallygjs();
        return findallygjs;
    }
    //删除员工角色

    @Override
    public int deleteygjs(HttpServletRequest request, int yhid, int jsid) {
        LambdaQueryWrapper<Userandrole> qw=new LambdaQueryWrapper<>();
        qw.eq(Userandrole::getYbh,yhid).eq(Userandrole::getJsbh,jsid);
        int delete = urdao.delete(qw);
        String token = request.getHeader(jwtTokenUtil.getHeader());
        String userIdFromToken = jwtTokenUtil.getUserIdFromToken(token);
        if(userIdFromToken.equals(yhid+"")){
            LoginUser loginUser= (LoginUser) redisTemplate.opsForValue().get("user" + userIdFromToken);
            List<String> qxlist = dao.chaxunquanxina(Integer.parseInt(userIdFromToken));
            loginUser.setQuanxian(qxlist);
            redisTemplate.opsForValue().set("user"+userIdFromToken,loginUser);
        }

        return delete;
    }

    @Override
    public List<Jiaoseandquanxianvo> findalljs(int[] jsid) {
        List<Jiaoseandquanxianvo> findalljs = jsdao.findalljs(jsid);
        return findalljs;
    }
    //新增员工角色
    @Override
    public int insertygjs(HttpServletRequest request,Jiaoseandquanxianvo jvo) {
        int[] jsbhs = jvo.getJsbhs();
        for (int jsbh : jsbhs) {
            Userandrole u=new Userandrole();
            u.setYbh(jvo.getYbh());
            u.setJsbh(jsbh);
            urdao.insert(u);
        }
        String token = request.getHeader(jwtTokenUtil.getHeader());
        String userIdFromToken = jwtTokenUtil.getUserIdFromToken(token);
        if(userIdFromToken.equals(jvo.getYbh()+"")){
            LoginUser loginUser= (LoginUser) redisTemplate.opsForValue().get("user" + userIdFromToken);
            List<String> qxlist = dao.chaxunquanxina(Integer.parseInt(userIdFromToken));
            loginUser.setQuanxian(qxlist);
            redisTemplate.opsForValue().set("user"+userIdFromToken,loginUser);
        }
        return 1;
    }

    @Override
    public List<Fenpeiyhjs> mohufindallygjs(String cxtj) {
        if (StringUtils.isEmpty(cxtj)){
            return findallygjs();
        }
        return jsdao.mohufindallygjs("%"+cxtj+"%");
    }
}
