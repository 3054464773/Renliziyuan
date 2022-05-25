package com.trkj.renliziyuangl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.renliziyuangl.vo.KaoqinjiluVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface Mohukaoq extends BaseMapper<KaoqinjiluVo> {
    public List<KaoqinjiluVo> mohukaoqin(String rzname);
}
