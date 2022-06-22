package com.trkj.renliziyuangl.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.renliziyuangl.dao.ShenhejiluzibiaoDao;
import com.trkj.renliziyuangl.pojo.LoginUser;
import com.trkj.renliziyuangl.pojo.Shenhejiluzibiao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ShenhejiluziServiceImpl implements ShenhejiluziService {
    @Autowired
    private ShenhejiluzibiaoDao shdao;

    @Override
    public Map findshenhegz(int ym) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();

        List<String> quanxian = loginUser.getQuanxian();

        String js="";
        shdao.findshenhegz(new Page(ym,6),js);
        return null;
    }
}
