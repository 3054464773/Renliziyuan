package com.trkj.renliziyuangl.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class canbaoryVo {
    private int ybh;
    private int sbbh;
    private int ygzt;
    private String rzname;
    private String rzsex;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date rzcsrq;
    private int rzage;
    private String rzxl;
    private String rzsfz;
    private String rzphone;
    private String rzdz;
    private String rzgzjl;
    private String rzhyzk;
    private String rzmz;
    private String rzzzmm;
    private String sbmc;
    private String bmmc;
}
