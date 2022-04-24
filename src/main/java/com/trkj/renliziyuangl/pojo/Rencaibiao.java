package com.trkj.renliziyuangl.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * rencaibiao
 * @author 
 */
@Data
public class Rencaibiao implements Serializable {
    private int rid;

    private int ybh;

    private int zwbh;

    private int rzbh;

    private int rzt;

    private Date rsj;

    private String rsf;

    private static final long serialVersionUID = 1L;
}