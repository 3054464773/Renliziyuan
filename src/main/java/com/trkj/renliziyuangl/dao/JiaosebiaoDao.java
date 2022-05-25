package com.trkj.renliziyuangl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.renliziyuangl.pojo.Jiaosebiao;
import com.trkj.renliziyuangl.vo.Fenpeiyhjs;
import com.trkj.renliziyuangl.vo.Jiaoseandquanxianvo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JiaosebiaoDao extends BaseMapper<Jiaosebiao> {
        List<Fenpeiyhjs> findallygjs();
        List<Jiaoseandquanxianvo> findalljs(int [] jsid);
        List<Fenpeiyhjs> mohufindallygjs(String cxtj);
}