package com.trkj.renliziyuangl.service;

import com.trkj.renliziyuangl.dao.BancibiaoDao;
import com.trkj.renliziyuangl.pojo.Bancibiao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class shebaosystemServiceImpl implements shebaosystemService {
    @Autowired
    private BancibiaoDao bcdao;
    @Override
    public List findBancb(int pageNum, int pageSize) {

        List<Bancibiao> bancibiaos = bcdao.selectList(null);
        return bancibiaos;
    }
}
