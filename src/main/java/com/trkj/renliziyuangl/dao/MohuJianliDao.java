package com.trkj.renliziyuangl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.renliziyuangl.vo.rencaiVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MohuJianliDao extends BaseMapper<rencaiVo> {
    public List<rencaiVo> mohujianli(String rzname);
}
