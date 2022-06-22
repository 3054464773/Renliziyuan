package com.trkj.renliziyuangl.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
@Data
public class usersssVo {
    private int ybh;
    private String rzname;
    private String rzsex;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date rzcsrq;
    private String rzxl;
    private int ygzt;
    private String rzgzjl;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date rsj;
    private String rzhyzk;
    private String rzzzmm;
    private int rzbh;
    private String bmmc;
    private String zwmc;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date ygrzsj;
}
