package com.trkj.renliziyuangl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.renliziyuangl.vo.Chuchaivo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Chuchaijilu extends BaseMapper<Chuchaivo> {
    public List<Chuchaivo> mohuchuchaijjll(String rzname);
}
