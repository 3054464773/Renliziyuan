package com.trkj.renliziyuangl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.renliziyuangl.dao.SbzjbDao;
import com.trkj.renliziyuangl.dao.ShebaojishubiaoDao;
import com.trkj.renliziyuangl.dao.XingzijilubiaoDao;
import com.trkj.renliziyuangl.pojo.Sbzjb;
import com.trkj.renliziyuangl.pojo.Shebaojishubiao;
import com.trkj.renliziyuangl.vo.SalaryVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class payrollServiceImpl implements payrollService {
    @Autowired
    private XingzijilubiaoDao dao;
    @Autowired
    private SbzjbDao sbzjbDao;
    @Autowired
    private ShebaojishubiaoDao shebaojishubiaoDao;

    @Override
    public PageInfo<SalaryVo> selectEmpInfo(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SalaryVo> list=dao.selectEmpInfo();
        System.out.println(list+"1111111111111111111111111111");

        for (int i=0;i<list.size();i++){
            //查出勤天数 计算应发工资
            SalaryVo salaryVo=dao.selectEmpYCQTS(list.get(i).getYbh());
            list.get(i).setKqCount(16);
            if(list.get(i).getKqCount()==22){
                //根据出勤天数判断是否有全勤奖励
                list.get(i).setQuanqin(200.00);
            }else {
                list.get(i).setQuanqin(0.00);
            }
            list.get(i).setYingfa((list.get(i).getXzjljbgz()/22*list.get(i).getKqCount())+list.get(i).getXzysje()+list.get(i).getQuanqin());

            //查迟到的天数，扣每天的1/3工资
            SalaryVo vo2=dao.selectEmpYCQTS2(list.get(i).getYbh());
            list.get(i).setKqCount2(vo2.getKqCount2());
            list.get(i).setChidao(list.get(i).getKqCount2()*(list.get(i).getXzjljbgz()/22/3));
            System.out.println(list.get(i).getKqCount2()+"aaaaaaaaaaaaaaaaaaaaaaaaa");

            //查早退 扣每天1/3工资
            SalaryVo vo3=dao.selectEmpYCQTS3(list.get(i).getYbh());
            list.get(i).setKqCount3(vo3.getKqCount3());
            list.get(i).setZaotui(list.get(i).getXzjljbgz()/22/3*list.get(i).getKqCount3());

            //查事假
            SalaryVo vo4=dao.AttendanceEmp(list.get(i).getYbh());
            list.get(i).setShijia(vo4.getShijia());
            list.get(i).setShijiamoney(list.get(i).getXzjljbgz()/22*list.get(i).getShijia());

            //查病假
            SalaryVo vo5=dao.AttendanceEmp2(list.get(i).getYbh());
            list.get(i).setBingjia(vo5.getBingjia());
            list.get(i).setBingjiamoney(list.get(i).getXzjljbgz()/22*list.get(i).getBingjia()*0.2);
            System.out.println("工资"+list.get(i).getXzjljbgz()/22*list.get(i).getBingjia()*0.2);

            //查社保
            if(list.get(i).getSbbh()!=0){
                QueryWrapper<Sbzjb> sbzjbQueryWrapper=new QueryWrapper<>();
                sbzjbQueryWrapper.eq("sbbh",list.get(i).getSbbh());
                List<Sbzjb> sbzjbs = sbzjbDao.selectList(sbzjbQueryWrapper);
                Double a=0.0;
                if(sbzjbs.size()!=0){
                    for (Sbzjb s : sbzjbs) {
                        QueryWrapper<Shebaojishubiao> shebaojishubiaoQueryWrapper=new QueryWrapper<>();
                        shebaojishubiaoQueryWrapper.eq("sbjsbh",s.getSbjsbh());
                        Shebaojishubiao shebaojishubiao = shebaojishubiaoDao.selectOne(shebaojishubiaoQueryWrapper);
                        log.debug("s:{}",shebaojishubiao.getSbjnbl()/100);
                        log.debug("s1:{}",(shebaojishubiao.getSbjsje()*shebaojishubiao.getSbjnbl()/100));
                        a=a+(shebaojishubiao.getSbjsje()*shebaojishubiao.getSbjnbl()/100);
                    }
                    list.get(i).setSbje(a);
                }
            }

            Double b=0.0;
            b=(list.get(i).getXzjljbgz()/22*list.get(i).getKqCount())+list.get(i).getXzysje()+list.get(i).getQuanqin()-
                    (list.get(i).getSbje()+list.get(i).getBingjiamoney()+list.get(i).getShijiamoney()+list.get(i).getChidao()+list.get(i).getZaotui());
            System.out.println(b+"BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
            if (b<5000 && b>1){
                list.get(i).setGeshui(b*0.01);
                list.get(i).setShifa(b-(b*0.01));
            }else if(b<8000 && b>5000){
                list.get(i).setGeshui(b*0.03);
                list.get(i).setShifa(b-b*0.03);
            }else if(b<15000 && b>8000){
                list.get(i).setGeshui(b*0.1);
                list.get(i).setShifa(b-b*0.1);
            }
        }
        System.out.println(list+"1111111111111111111111111111");
        PageInfo<SalaryVo> info=new PageInfo<>(list);
        return info;

    }

    @Override
    public SalaryVo selectEmpYCQTS(int ybh) {
        SalaryVo list=dao.selectEmpYCQTS(ybh);
        return list;
    }

    @Override
    public List<SalaryVo> selectEmpSocial(int ybh) {
        return dao.selectEmpSocial(ybh);
    }

    @Override
    public SalaryVo selectEmpYCQTS2(int ybh) {
        return dao.selectEmpYCQTS2(ybh);
    }

    @Override
    public SalaryVo selectEmpYCQTS3(int ybh) {
        return dao.selectEmpYCQTS3(ybh);
    }

    @Override
    public SalaryVo AttendanceEmp(int ybh) {
        return dao.AttendanceEmp(ybh);
    }

    @Override
    public SalaryVo AttendanceEmp2(int ybh) {
        return dao.AttendanceEmp2(ybh);
    }

    @Override
    public PageInfo<SalaryVo> selectEmpInfoByMonth(int pageNum, int pageSize,String szjlsj) {
        PageHelper.startPage(pageNum,pageSize);
        List<SalaryVo> list=dao.selectEmpInfoByMonth(szjlsj);

        for (int i=0;i<list.size();i++){
            SalaryVo vo=dao.selectEmpYCQTSByMonth(list.get(i).getYbh(),szjlsj);
            list.get(i).setKqCount(16);
            if(list.get(i).getKqCount()==22){
                //根据出勤天数判断是否有全勤奖励
                list.get(i).setQuanqin(200.00);
            }else {
                list.get(i).setQuanqin(0.00);
            }
            list.get(i).setYingfa((list.get(i).getXzjljbgz()/22*list.get(i).getKqCount())+list.get(i).getXzysje()+list.get(i).getQuanqin());
            //查迟到的天数，扣每天的1/3工资
            SalaryVo vo2=dao.selectEmpYCQTS2ByMonth(list.get(i).getYbh(),szjlsj);
            list.get(i).setKqCount2(vo2.getKqCount2());
            list.get(i).setChidao(list.get(i).getKqCount2()*(list.get(i).getXzjljbgz()/22/3));
            System.out.println(list.get(i).getYbh()+"aaaaaaaaaaaaaaaaaaaaaaaaa");

            //查早退 扣每天1/3工资
            SalaryVo vo3=dao.selectEmpYCQTS3ByMonth(list.get(i).getYbh(),szjlsj);
            list.get(i).setKqCount3(vo3.getKqCount3());
            list.get(i).setZaotui(list.get(i).getXzjljbgz()/22/3*list.get(i).getKqCount3());

            //查事假
            SalaryVo vo4=dao.AttendanceEmpByMonth(list.get(i).getYbh(),szjlsj);
            list.get(i).setShijia(vo4.getShijia());
            list.get(i).setShijiamoney(list.get(i).getXzjljbgz()/22*list.get(i).getShijia());

            //查病假
            SalaryVo vo5=dao.AttendanceEmp2ByMonth(list.get(i).getYbh(),szjlsj);
            list.get(i).setBingjia(vo5.getBingjia());
            list.get(i).setBingjiamoney(list.get(i).getXzjljbgz()/22*list.get(i).getBingjia()*0.2);
            System.out.println("工资"+list.get(i).getXzjljbgz()/22*list.get(i).getBingjia()*0.2);

            //查社保
            if(list.get(i).getSbbh()!=0){
                QueryWrapper<Sbzjb> sbzjbQueryWrapper=new QueryWrapper<>();
                sbzjbQueryWrapper.eq("sbbh",list.get(i).getSbbh());
                List<Sbzjb> sbzjbs = sbzjbDao.selectList(sbzjbQueryWrapper);
                Double a=0.0;
                if(sbzjbs.size()!=0){
                    for (Sbzjb s : sbzjbs) {
                        QueryWrapper<Shebaojishubiao> shebaojishubiaoQueryWrapper=new QueryWrapper<>();
                        shebaojishubiaoQueryWrapper.eq("sbjsbh",s.getSbjsbh());
                        Shebaojishubiao shebaojishubiao = shebaojishubiaoDao.selectOne(shebaojishubiaoQueryWrapper);
                        log.debug("s:{}",shebaojishubiao.getSbjnbl()/100);
                        log.debug("s1:{}",(shebaojishubiao.getSbjsje()*shebaojishubiao.getSbjnbl()/100));
                        a=a+(shebaojishubiao.getSbjsje()*shebaojishubiao.getSbjnbl()/100);
                    }
                    list.get(i).setSbje(a);
                }
            }

            Double b=0.0;
            b=(list.get(i).getXzjljbgz()/22*list.get(i).getKqCount())+list.get(i).getXzysje()+list.get(i).getQuanqin()-(list.get(i).getSbje()+list.get(i).getBingjiamoney()+list.get(i).getShijiamoney()+list.get(i).getChidao()+list.get(i).getZaotui());
            System.out.println(b+"BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
            if (b<5000 && b>1){
                list.get(i).setGeshui(b*0.01);
                list.get(i).setShifa(b-(b*0.01));
            }else if(b<8000 && b>5000){
                list.get(i).setGeshui(b*0.03);
                list.get(i).setShifa(b-b*0.03);
            }else if(b<15000 && b>8000){
                list.get(i).setGeshui(b*0.1);
                list.get(i).setShifa(b-b*0.1);
            }
        }
        PageInfo<SalaryVo> info=new PageInfo<>(list);
        return info;
    }

    @Override
    public SalaryVo selectEmpYCQTSByMonth(int ybh, String xzsj) {
        return null;
    }

    @Override
    public SalaryVo selectEmpYCQTS2ByMonth(int ybh, String xzsj) {
        return null;
    }

    @Override
    public SalaryVo selectEmpYCQTS3ByMonth(int ybh, String xzsj) {
        return null;
    }

    @Override
    public SalaryVo AttendanceEmpByMonth(int ybh, String xzsj) {
        return null;
    }

    @Override
    public SalaryVo AttendanceEmp2ByMonth(int ybh, String xzsj) {
        return null;
    }

    @Override
    public PageInfo<SalaryVo> selectEmpInfoByBmmc(int pageNum,int pageSize,String bmmc) {
        PageHelper.startPage(pageNum,pageSize);
        List<SalaryVo> list=dao.selectEmpInfoByBmmc(bmmc);
        System.out.println(list+"1111111111111111111111111111");

        for (int i=0;i<list.size();i++){
            //查出勤天数 计算应发工资
            SalaryVo salaryVo=dao.selectEmpYCQTS(list.get(i).getYbh());
            list.get(i).setKqCount(16);
            if(list.get(i).getKqCount()==22){
                //根据出勤天数判断是否有全勤奖励
                list.get(i).setQuanqin(200.00);
            }else {
                list.get(i).setQuanqin(0.00);
            }
            list.get(i).setYingfa((list.get(i).getXzjljbgz()/22*list.get(i).getKqCount())+list.get(i).getXzysje()+list.get(i).getQuanqin());

            //查迟到的天数，扣每天的1/3工资
            SalaryVo vo2=dao.selectEmpYCQTS2(list.get(i).getYbh());
            list.get(i).setKqCount2(vo2.getKqCount2());
            list.get(i).setChidao(list.get(i).getKqCount2()*(list.get(i).getXzjljbgz()/22/3));
            System.out.println(list.get(i).getKqCount2()+"aaaaaaaaaaaaaaaaaaaaaaaaa");

            //查早退 扣每天1/3工资
            SalaryVo vo3=dao.selectEmpYCQTS3(list.get(i).getYbh());
            list.get(i).setKqCount3(vo3.getKqCount3());
            list.get(i).setZaotui(list.get(i).getXzjljbgz()/22/3*list.get(i).getKqCount3());

            //查事假
            SalaryVo vo4=dao.AttendanceEmp(list.get(i).getYbh());
            list.get(i).setShijia(vo4.getShijia());
            list.get(i).setShijiamoney(list.get(i).getXzjljbgz()/22*list.get(i).getShijia());

            //查病假
            SalaryVo vo5=dao.AttendanceEmp2(list.get(i).getYbh());
            list.get(i).setBingjia(vo5.getBingjia());
            list.get(i).setBingjiamoney(list.get(i).getXzjljbgz()/22*list.get(i).getBingjia()*0.2);
            System.out.println("工资"+list.get(i).getXzjljbgz()/22*list.get(i).getBingjia()*0.2);

            //查社保
            if(list.get(i).getSbbh()!=0){
                QueryWrapper<Sbzjb> sbzjbQueryWrapper=new QueryWrapper<>();
                sbzjbQueryWrapper.eq("sbbh",list.get(i).getSbbh());
                List<Sbzjb> sbzjbs = sbzjbDao.selectList(sbzjbQueryWrapper);
                Double a=0.0;
                if(sbzjbs.size()!=0){
                    for (Sbzjb s : sbzjbs) {
                        QueryWrapper<Shebaojishubiao> shebaojishubiaoQueryWrapper=new QueryWrapper<>();
                        shebaojishubiaoQueryWrapper.eq("sbjsbh",s.getSbjsbh());
                        Shebaojishubiao shebaojishubiao = shebaojishubiaoDao.selectOne(shebaojishubiaoQueryWrapper);
                        log.debug("s:{}",shebaojishubiao.getSbjnbl()/100);
                        log.debug("s1:{}",(shebaojishubiao.getSbjsje()*shebaojishubiao.getSbjnbl()/100));
                        a=a+(shebaojishubiao.getSbjsje()*shebaojishubiao.getSbjnbl()/100);
                    }
                    list.get(i).setSbje(a);
                }
            }

            Double b=0.0;
            b=(list.get(i).getXzjljbgz()/22*list.get(i).getKqCount())+list.get(i).getXzysje()+list.get(i).getQuanqin()-
                    (list.get(i).getSbje()+list.get(i).getBingjiamoney()+list.get(i).getShijiamoney()+list.get(i).getChidao()+list.get(i).getZaotui());
            System.out.println(b+"BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
            if (b<5000 && b>1){
                list.get(i).setGeshui(b*0.01);
                list.get(i).setShifa(b-(b*0.01));
            }else if(b<8000 && b>5000){
                list.get(i).setGeshui(b*0.03);
                list.get(i).setShifa(b-b*0.03);
            }else if(b<15000 && b>8000){
                list.get(i).setGeshui(b*0.1);
                list.get(i).setShifa(b-b*0.1);
            }
        }
        System.out.println(list+"1111111111111111111111111111");
        PageInfo<SalaryVo> info=new PageInfo<>(list);
        return info;
    }

}
