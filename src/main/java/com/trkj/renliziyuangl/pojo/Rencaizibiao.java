package com.trkj.renliziyuangl.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * rencaizibiao
 * @author 
 */
@Data
public class Rencaizibiao implements Serializable {
    private int rzbh;

    private String rzname;

    private String rzsex;

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

    private static final long serialVersionUID = 1L;
}