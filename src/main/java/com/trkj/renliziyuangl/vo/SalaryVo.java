package com.trkj.renliziyuangl.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class SalaryVo {

    private int ybh;
    private int xzjlbh;
    private String rzname;
    private String bmmc;
    private String zwmc;
    private Double xzjljbgz;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date szjlsj;
    private String xzysmc;
    private Double xzysje;
    private int kqCount;
    private int kqCount2;
    private int kqCount3;
    private Double yingfa;
    private Double chidao;
    private Double zaotui;
    private Double sbjsje;
    private Double sbjnbl;
    private Double sbje;
    private int sbbh;
    private int shijia;
    private Double shijiamoney;
    private int bingjia;
    private Double bingjiamoney;
    private Double geshui;
    private Double shifa;
    private Double quanqin;
    private String xzsj;
}
