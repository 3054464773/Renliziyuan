package com.trkj.renliziyuangl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.renliziyuangl.pojo.Zhaopingjihuabiao;
import com.trkj.renliziyuangl.vo.zpjhVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ZhaopingjihuabiaoDao extends BaseMapper<Zhaopingjihuabiao> {
    //查询所有以及分页
    public List<zpjhVo> findszpjh();
   //添加
    public int tianjiazpjh(Zhaopingjihuabiao zhaopingjihuabiao);
    //根据id查询
    public Zhaopingjihuabiao findZpjhById(int zbh);
    //修改
    public int updateZpjh(Zhaopingjihuabiao zhaopingjihuabiao);

}