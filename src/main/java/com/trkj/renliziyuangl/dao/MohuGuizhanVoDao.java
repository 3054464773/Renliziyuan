package com.trkj.renliziyuangl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.renliziyuangl.vo.GuizhanVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MohuGuizhanVoDao extends BaseMapper<GuizhanVo> {
    public List<GuizhanVo> mohuchaxunguiz(String mmc);
    List<GuizhanVo> bumenguiz(String bmmc);

}
