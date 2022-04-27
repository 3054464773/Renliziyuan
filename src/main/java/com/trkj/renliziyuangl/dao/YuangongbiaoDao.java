package com.trkj.renliziyuangl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.renliziyuangl.pojo.Yuangongbiao;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface YuangongbiaoDao extends BaseMapper<Yuangongbiao> {
        //通过员工表员工id找到员工子表姓名
        String byidfindYgname(int yid);
}