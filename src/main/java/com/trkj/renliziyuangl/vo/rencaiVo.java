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

    private int rzsfz;

    private int rzphone;

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

}