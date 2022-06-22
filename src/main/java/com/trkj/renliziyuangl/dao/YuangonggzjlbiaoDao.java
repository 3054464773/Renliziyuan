package com.trkj.renliziyuangl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.renliziyuangl.pojo.Bancibiao;
import com.trkj.renliziyuangl.pojo.Kaoqinjilubiao;
import com.trkj.renliziyuangl.pojo.Rencaizibiao;
import com.trkj.renliziyuangl.pojo.Yuangonggzjlbiao;
import com.trkj.renliziyuangl.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface YuangonggzjlbiaoDao extends BaseMapper<Yuangonggzjlbiao> {
    //查询员工通讯录
    List selectygphone(YgPhoneVo ygphone);

    //查询我的日志
    List<RizhiVo> cxmerizhi(int ybh);

    //查询已点评日志
    List<RizhiVo> cxyidianpingrz(int ybh);

    //根据员工id查询考勤记录
    List cxkaoqinjlByid(int ybh);

    //根据员工编号查询员工绩效记录
    List<gradeVo> cxjixiaoByid(int ybh);

    //根据员工编号查询员工薪资记录
    List cxxinziByid(int ybh);

    //根据员工编号查询员工出差记录
    List cxchuchaiByid(int ybh);

    //查询通知
    List cxtongzhi();

    //查询公告
    List cxgonggao();

    //根据员工id查询个人资料信息
    canbaoryVo cxyuangonggerenziliao(int ybh);

    //修改员工个人资料
    int updategrzl(Rencaizibiao rczb);

    //根据员工编号查询员工班次情况
    Bancibiao cxbancibyid(int ybh);

    //根据员工id查询当天是否有考勤记录
    Kaoqinjilubiao cxkqjlByIdandDate(@Param("ybh") int ybh);
}