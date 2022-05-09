package com.trkj.renliziyuangl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.renliziyuangl.vo.usersssVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UsersssDao extends BaseMapper<usersssVo> {
  public List<usersssVo> mohuchaxunygg(String rzname);
  public List<usersssVo> mohuchaxunyghmd(String rzname);

}
