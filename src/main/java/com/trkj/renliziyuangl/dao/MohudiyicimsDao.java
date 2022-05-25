package com.trkj.renliziyuangl.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.renliziyuangl.vo.ZpVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MohudiyicimsDao  extends BaseMapper<ZpVo> {
    public List<ZpVo> mohudiyici(String rzname);
}
