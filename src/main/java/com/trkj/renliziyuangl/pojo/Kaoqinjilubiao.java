package com.trkj.renliziyuangl.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * kaoqinjilubiao
 * @author 
 */
@Data
public class Kaoqinjilubiao implements Serializable {
    private int kqjlbh;

    private int ybh;

    private Date kqsbdksj;

    private int kqsbzt;

    private Date kqxbdksj;

    private int kqxbzt;

    private Date xzsj;

    private static final long serialVersionUID = 1L;
}