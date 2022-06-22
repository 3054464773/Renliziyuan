package com.trkj.renliziyuangl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.renliziyuangl.vo.zpjhVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ZpjhVoDao extends BaseMapper<zpjhVo> {
     List<zpjhVo> bumenzpjh(String bmmc);
     List<zpjhVo> mohuzpjh(String zmc);
     List<zpjhVo> zhaoppxxp();
}
