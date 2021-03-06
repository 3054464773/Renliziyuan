package com.trkj.renliziyuangl.vo;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * rencaizibiao
 * @author
 */
@Data
public class ZpVo {
    @TableId
    private int rzbh;

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

    private  int rzt;
    private int zwbh;
    private int mbh;
    private String mzwt;
    private int ybh;
    private String mmc;
    private int rid;
    private int mzbh;
    private int mjbh;
    private String zwmc;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date mjsj;
    private String bmmc;
    private  String gryx;
    private String byxy;
    private String zymc;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date rxsj;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date byssj;
    private String yijixk;
    private String xxxz;
    private int mscs;


}