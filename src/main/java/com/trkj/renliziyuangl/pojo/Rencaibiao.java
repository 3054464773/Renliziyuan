package com.trkj.renliziyuangl.pojo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date rsj;

    private String rsf;

    private static final long serialVersionUID = 1L;
}