package com.trkj.renliziyuangl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.renliziyuangl.vo.JixiaojiluVo;
import com.trkj.renliziyuangl.vo.MianshijiluVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Mianjilu extends BaseMapper<MianshijiluVo> {
//模糊查询面试记录
    public List<MianshijiluVo> mohumianshijilu(String rzname);
}
