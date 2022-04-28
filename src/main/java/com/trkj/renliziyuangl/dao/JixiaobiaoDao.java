package com.trkj.renliziyuangl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.renliziyuangl.pojo.Jixiaobiao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JixiaobiaoDao extends BaseMapper<Jixiaobiao>{
    public List<Jixiaobiao> findJixiao();//查询全部绩效名称
    public int insert(Jixiaobiao entity);
    public int update(Jixiaobiao entity);
    public Jixiaobiao findJixiaoById(int jbh);
    public int deleteJixiao(int jbh);

}
