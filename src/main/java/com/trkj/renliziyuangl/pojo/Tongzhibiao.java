package com.trkj.renliziyuangl.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * tongzhibiao
 * @author 
 */
@Data
public class Tongzhibiao implements Serializable {
    private int tzbh;

    private int ybh;

    private int bmbh;

    private String tznr;

    private Date tzsj;

    private int tzyds;

    private static final long serialVersionUID = 1L;
}