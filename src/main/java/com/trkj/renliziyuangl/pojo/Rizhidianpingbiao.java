package com.trkj.renliziyuangl.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * rizhidianpingbiao
 * @author 
 */
@Data
public class Rizhidianpingbiao implements Serializable {
    private int rzdpbh;

    private int gzrzbh;

    private int ybh;

    private String rzdpnr;

    private Date rzdpsj;

    private static final long serialVersionUID = 1L;
}