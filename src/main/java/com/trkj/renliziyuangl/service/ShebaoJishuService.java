package com.trkj.renliziyuangl.service;

import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.pojo.Shebaojishubiao;
import java.util.List;

public interface ShebaoJishuService {
    //查询社保基数信息
    public PageInfo<Shebaojishubiao> cxshebaojishu(int pageNum, int PageSize);

    //根据id查询基数信息
    Shebaojishubiao findjsByid(int sbjsbh);

    //根据基数名称模糊查询社保基数信息
    List<Shebaojishubiao> cxjsbyname(String sbname);

    //添加社保基数信息
    Shebaojishubiao insertjsxx(Shebaojishubiao sbjsb);

    //修改基数信息
    public int updatejsxx(Shebaojishubiao sbjsb);

    //删除社保基数信息
    int deletejsxx(int sbjsbh);
}
