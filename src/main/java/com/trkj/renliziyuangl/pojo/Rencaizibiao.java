package com.trkj.renliziyuangl.pojo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * rencaizibiao
 * @author 
 */
@Data
public class Rencaizibiao<Longblob> implements Serializable {
@TableId(value = "rzbh",type = IdType.AUTO)
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
      private  String gryx;
      private String byxy;
      private String zymc;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date rxsj;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date byssj;
    private String yijixk;
    private String xxxz;

    private static final long serialVersionUID = 1L;
}