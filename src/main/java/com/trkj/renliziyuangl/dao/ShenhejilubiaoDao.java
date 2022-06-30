package com.trkj.renliziyuangl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.renliziyuangl.pojo.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShenhejilubiaoDao extends BaseMapper<Shenhejilubiao> {

    List<Zhaopingjihuabiao> findzpjh();

    int shzpjh(int pdtj, int shjlbh);

    List<Yuangonggzjlbiao> findyggzjl();

    int shygzz(int pdtj, int shjlbh);

    int xiugaiygzt(int ygid, int ygzt);

    List<Jiaqishenqibiao> findqj();

    int shygqj(int pdtj, int shjlbh);

    List<Chuchaibiao> findygcc();
}