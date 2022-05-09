package com.trkj.renliziyuangl.service;

import com.trkj.renliziyuangl.dao.UsersssDao;
import com.trkj.renliziyuangl.vo.usersssVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class usersVolmpl implements UsersVoService {
    @Autowired
    private UsersssDao userssssdao;

    @Override
    public List<usersssVo> mohuchaxunygg(String rzname) {
        List<usersssVo> usersssVo=userssssdao.mohuchaxunygg(rzname);
        System.out.println("2222222222222Service");
        return usersssVo;
    }
    @Override
    public List<usersssVo> mohuchaxunyghmd(String rzname) {
        List<usersssVo> usersssVo=userssssdao.mohuchaxunyghmd(rzname);
        System.out.println("2222222222222Service");
        return usersssVo;
    }

}

