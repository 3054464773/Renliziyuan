package com.trkj.renliziyuangl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.renliziyuangl.pojo.Yuangongbiao;
import com.trkj.renliziyuangl.vo.UsersXinZiVo;
import com.trkj.renliziyuangl.vo.usersssVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface YuangongbiaoDao extends BaseMapper<Yuangongbiao> {
        //通过员工表员工id找到员工子表姓名
        String byidfindYgname(int yid);
        //修改
        public int updateUser(Yuangongbiao user);
        //查询所有以及分页
        public List<Yuangongbiao> findusers();
        //根据id查找
        public Yuangongbiao findUserById(int ybh);
        //添加
        public int insersUsers(Yuangongbiao user);
       //员工多表详细信息
        public List<usersssVo> finduserssss();
        //员工多表薪资信息
        public  List<UsersXinZiVo> findxinzi();
        //员工黑名单
      public  List<usersssVo> findusershmd();
      //员工未到岗
      public  List<usersssVo> findwdg();
      //修改员工状态
    public int xiugairuzhi(int ybh);
    //员工离职
    public List<usersssVo> finduserslz();

}