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
public class rencaiVo<Longblob> {
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
      private  int img;
      private  int rzt;
      private Date rsj;
      private String rsf;
      private int rid;
      private int zwbh;
      private int ybh;
      private String zwmc;
      private String bmmc;
    private  String gryx;
    private String byxy;
    private String zymc;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date rxsj;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date byssj;
    private String xxxz;
    private static final long serialVersionUID = 1L;

}