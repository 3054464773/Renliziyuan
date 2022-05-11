package com.trkj.renliziyuangl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.renliziyuangl.vo.UsersXinZiVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserXzDao extends BaseMapper<UsersXinZiVo> {
    public List<UsersXinZiVo> findxinzimohu(String rzname);
}
