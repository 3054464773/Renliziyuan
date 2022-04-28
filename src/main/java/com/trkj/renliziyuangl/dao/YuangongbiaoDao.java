package com.trkj.renliziyuangl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.pojo.Yuangongbiao;
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
}