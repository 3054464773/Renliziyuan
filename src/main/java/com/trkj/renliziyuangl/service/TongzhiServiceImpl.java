package com.trkj.renliziyuangl.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.renliziyuangl.dao.BumenbiaoDao;
import com.trkj.renliziyuangl.dao.TongzhibiaoDao;
import com.trkj.renliziyuangl.pojo.Bumenbiao;
import com.trkj.renliziyuangl.pojo.LoginUser;
import com.trkj.renliziyuangl.pojo.Tongzhibiao;
import com.trkj.renliziyuangl.untli.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TongzhiServiceImpl implements TongzhiService {
    @Autowired
    private TongzhibiaoDao tzdao;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private BumenbiaoDao bmdao;

    @Override
    public int insertTongzhi(Tongzhibiao tz, HttpServletRequest request) {
        String token = request.getHeader(jwtTokenUtil.getHeader());
        String userIdFromToken = jwtTokenUtil.getUserIdFromToken(token);
        int bmid = tzdao.inygidfindbmid(Integer.parseInt(userIdFromToken));
        tz.setBmbh(bmid);
        tz.setTzsj(new Date());
        tz.setTzyds(0);
        tz.setYbh(Integer.parseInt(userIdFromToken));
        int insert = tzdao.insert(tz);
        return insert;
    }

    @Override
    public Map findallbmandtzjilu(HttpServletRequest request,int dqy,String sstj) {
        Map map=new HashMap();
        String token = request.getHeader(jwtTokenUtil.getHeader());
        String userIdFromToken = jwtTokenUtil.getUserIdFromToken(token);
        LoginUser loginUser= (LoginUser) redisTemplate.opsForValue().get("user" + userIdFromToken);
        List<String> quanxian = loginUser.getQuanxian();
        System.out.println(quanxian+"aaaaaaaaaaaaaa");
        IPage<Tongzhibiao> inygidfindtz=null;
        boolean is=true;
        for (String s : quanxian) {
            if ("/suoyou".equals(s)){
                inygidfindtz = tzdao.inygidfindtz(new Page<Tongzhibiao>(dqy, 6), Integer.parseInt(userIdFromToken),1,"%"+sstj+"%");
                List<Bumenbiao> bumenbiaos = bmdao.selectList(null);
                map.put("bmlist",bumenbiaos);
                map.put("isbmcx",true);
                is=false;
                break;
            }
        }
        if(is){
            inygidfindtz = tzdao.inygidfindtz(new Page<Tongzhibiao>(dqy, 6), Integer.parseInt(userIdFromToken),0,"%"+sstj+"%");
            map.put("isbmcx",false);
        }
        map.put("tzlist",inygidfindtz.getRecords());
        map.put("zts",inygidfindtz.getPages());

        return map;
    }
}
