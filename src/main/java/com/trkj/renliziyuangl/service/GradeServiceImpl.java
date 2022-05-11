package com.trkj.renliziyuangl.service;

import com.trkj.renliziyuangl.dao.JixiaopinfenbiaoDao;
import com.trkj.renliziyuangl.vo.empVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    private JixiaopinfenbiaoDao dao;

    //查询员工列表
    @Override
    public List<empVo> findAllEmp() {
        return dao.findAllEmp();
    }

    //根据名称模糊查询
    @Override
    public List<empVo> findAllEmpByName(String rzname) {
        return dao.findAllEmpByName(rzname);
    }
}
