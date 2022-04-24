package com.trkj.renliziyuangl.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * xinzizhongjianbiao
 * @author 
 */
@Data
public class Xinzizhongjianbiao implements Serializable {
    private int xzzjbh;

    private int ybh;

    private int xzysbh;

    private int xzzjsl;

    private Date xzsj;

    private static final long serialVersionUID = 1L;
}