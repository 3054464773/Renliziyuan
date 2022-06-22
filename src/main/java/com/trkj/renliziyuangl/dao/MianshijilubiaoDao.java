package com.trkj.renliziyuangl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.renliziyuangl.pojo.Mianshijilubiao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MianshijilubiaoDao extends BaseMapper<Mianshijilubiao> {
    public List<Mianshijilubiao> mianshisy();
    public int xiugaimszt(int mjbh);

}