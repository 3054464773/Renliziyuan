package com.trkj.renliziyuangl.service;

import com.trkj.renliziyuangl.dao.BancibiaoDao;
import com.trkj.renliziyuangl.dao.ShebaofananbiaoDao;
import com.trkj.renliziyuangl.pojo.Bancibiao;
import com.trkj.renliziyuangl.pojo.Shebaofananbiao;
import com.trkj.renliziyuangl.pojo.Shebaojishubiao;
import com.trkj.renliziyuangl.vo.canbaoryVo;
import com.trkj.renliziyuangl.vo.shebaofaVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class shebaosystemServiceImpl implements shebaosystemService {
    @Autowired
    private BancibiaoDao bcdao;
    @Autowired
    private ShebaofananbiaoDao sbfadao;
    @Override
    public List findBancb(int pageNum, int pageSize) {
        List<Bancibiao> bancibiaos = bcdao.selectList(null);
        return bancibiaos;
    }

    /*查询社保方案*/
    @Override
    public List cxsbfa(Shebaofananbiao sbfa) {
        List cxshebaofangan = sbfadao.cxshebaofangan(sbfa);
        return cxshebaofangan;
    }

    /*查询所有社保方案(具体)*/
    @Override
    public List<shebaofaVo> selectsbfa(int sbbh) {
        return  sbfadao.selectsbfa(sbbh);
    }

    /*根据方案id或名称模糊查询社保方案信息*/
    @Override
    public List<Shebaofananbiao> cxsbidorname(String sbmc) {
        return sbfadao.cxfaByIdAndName(sbmc);
    }

    /*查询社保基数表信息*/
    @Override
    public List selectsbjsxx(Shebaojishubiao sbjsb) {
        return sbfadao.selectsbjsxx(sbjsb);
    }

    /*新增社保方案*/
    @Override
    public List insertsbfa(shebaofaVo sbvo) {
        return sbfadao.insertfaxx(sbvo);
    }

    /*删除社保方案*/
    @Override
    public int deletesbfa(int sbbh) {
        return sbfadao.deletesbfaxx(sbbh);
    }

    /*查询参保人员信息*/
    @Override
    public List cxcbry(canbaoryVo cbryvo) {
        return sbfadao.cxcanbaorenyuan(cbryvo);
    }


}
