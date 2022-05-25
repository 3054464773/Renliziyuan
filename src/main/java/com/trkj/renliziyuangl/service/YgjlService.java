package com.trkj.renliziyuangl.service;

import com.trkj.renliziyuangl.vo.Chuchaivo;
import com.trkj.renliziyuangl.vo.JixiaojiluVo;
import com.trkj.renliziyuangl.vo.KaoqinjiluVo;
import com.trkj.renliziyuangl.vo.MianshijiluVo;

import java.util.List;
public interface YgjlService {
    public List<KaoqinjiluVo> mohukaoqin(String rzname);
    public List<MianshijiluVo> mohumianshijilu(String rzname);
    public List<JixiaojiluVo> mohujixiaojilu(String rzname);
    public List<Chuchaivo> mohuchuchaijjll(String rzname);
}
