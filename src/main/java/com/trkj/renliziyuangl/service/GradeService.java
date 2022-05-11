package com.trkj.renliziyuangl.service;

import com.trkj.renliziyuangl.vo.empVo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface GradeService {
    List<empVo> findAllEmp();//查询员工列表
    List<empVo> findAllEmpByName(String rzname);
}
