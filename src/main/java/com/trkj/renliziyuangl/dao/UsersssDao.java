package com.trkj.renliziyuangl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.renliziyuangl.vo.usersssVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UsersssDao extends BaseMapper<usersssVo> {
  public List<usersssVo> mohuchaxunygg(@Param("rzname")String rzname, @Param("rzsex")String rzsex);
  public List<usersssVo> mohuchaxunyghmd(@Param("rzname")String rzname, @Param("rzsex")String rzsex);
  public List<usersssVo> mohuchaxunyglz(@Param("rzname")String rzname, @Param("rzsex")String rzsex);
  public List<usersssVo> mohuchaxunygwbd(@Param("rzname")String rzname, @Param("rzsex")String rzsex);
  public List<usersssVo> mohuchaxunygsx(@Param("rzname")String rzname, @Param("rzsex")String rzsex);

}
