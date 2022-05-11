package com.trkj.renliziyuangl.service;

import com.trkj.renliziyuangl.dao.UserXzDao;
import com.trkj.renliziyuangl.vo.UsersXinZiVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsersXzservicelmpl implements UsersXzService{
    @Autowired
    private UserXzDao userXzDao;
    @Override
    public List<UsersXinZiVo> findxinzimohu(String rzname) {
        List<UsersXinZiVo> usersXinZiVos=userXzDao.findxinzimohu(rzname);
        return usersXinZiVos;
    }
}
