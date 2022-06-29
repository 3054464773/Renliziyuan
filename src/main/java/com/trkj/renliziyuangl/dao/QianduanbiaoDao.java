package com.trkj.renliziyuangl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.renliziyuangl.pojo.Qianduanbiao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QianduanbiaoDao extends BaseMapper<Qianduanbiao> {
    IPage<Qianduanbiao> findallqd(String qdfjid,Page page, String cxtj);
    List<JiaosebiaoDao> findalljsqds(String cxtj);
    List<Qianduanbiao> findfujiqd();
    List<Qianduanbiao>  chaxunwfpcd(int [] qdlist);
}