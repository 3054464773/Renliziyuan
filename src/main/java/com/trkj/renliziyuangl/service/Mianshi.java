package com.trkj.renliziyuangl.service;

import com.trkj.renliziyuangl.pojo.Mianshijilubiao;
import com.trkj.renliziyuangl.vo.ZpVo;
import com.trkj.renliziyuangl.vo.rencaiVo;

public interface Mianshi  {
    public int  msjl(int  mjbh);
    public int  msjlmg(ZpVo zpVo);
    public int yymsjl(rencaiVo rencaiVo);
    //入职修改当次面试状态
    public int xiugaimszt(int mjbh);

}
