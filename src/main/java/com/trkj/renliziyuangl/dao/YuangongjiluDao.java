package com.trkj.renliziyuangl.dao;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.renliziyuangl.vo.JixiaojiluVo;
import com.trkj.renliziyuangl.vo.KaoqinjiluVo;
import com.trkj.renliziyuangl.vo.MianshijiluVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface YuangongjiluDao extends BaseMapper<JixiaojiluVo> {

    public List<JixiaojiluVo> mohujixiaojilu(String rzname);

}
