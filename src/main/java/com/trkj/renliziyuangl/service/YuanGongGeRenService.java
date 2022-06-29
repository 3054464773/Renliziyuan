package com.trkj.renliziyuangl.service;

import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.pojo.*;
import com.trkj.renliziyuangl.vo.RizhiVo;
import com.trkj.renliziyuangl.vo.YgPhoneVo;
import com.trkj.renliziyuangl.vo.canbaoryVo;

import java.util.List;

public interface YuanGongGeRenService {
    //查询员工通讯录
    PageInfo<YgPhoneVo> ygphone(int pageNum, int pageSize);

    //根据部门查询员工通讯录
    List selectygphonebybm(int bmbh);

    //根据员工姓名模糊查询员工通讯录
    List mohucxygphonebyname(String rzname);

    //发表日志
    int fbrizhi(Gongzuorizhibiao gzrzb);

    //查询我的日志
    PageInfo<RizhiVo> selectMeRizhi(int pageNum, int pageSize);

    //查询已点评的日志
    PageInfo<RizhiVo> selectydprz(int pageNum, int pageSize);

    //根据员工id查询员工个人考勤记录
    List selectkqjlbyid();

    //根据员工id查询员工个人绩效记录
    List selectjixiaobyid();

    //根据员工编号查询员工薪资记录
    List selectxinzibyid();

    //根据员工编号查询员工出差记录
    List selectchuchaibyid();

    //查询通知
    List selecttongzhi();

    //查询公告
    List selectgonggao();

    //根据员工id查询个人资料
    canbaoryVo selectgrzl();

    //修改员工个人资料
    int xggerenziliao(Rencaizibiao rcb);

    //根据员工编号查询员工班次状况
    Bancibiao selectbanci();

    //根据员工id查询当天是否有考勤记录
    Kaoqinjilubiao cxkqjlbydate();

    //员工打卡操作
    Kaoqinjilubiao ygdk();

    //申请出差
    int shenqingchuchai(Chuchaibiao ccb);

    //查询员工的状态(判断员工是否能申请转正)
    canbaoryVo cxygzt();

    //查询所有考勤假期类型
    List cxkqjqlx(Kaoqinjiaqilxbiao kqjqlxb);

    //申请排休
    int shenqingpaixiu(Jiaqishenqibiao jqsqb);

    //申请转正
    int shenqingzhuanzheng(Yuangonggzjlbiao yggzjlb);

    //申请离职
    int shenqinglizhi(Yuangonggzjlbiao yggzjlb);

}
