package com.trkj.renliziyuangl.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * mianshijilubiao
 * @author 
 */
@Data
public class Mianshijilubiao implements Serializable {
    private int mjbh;

    private int rid;

    private int ybh;

    private int mzbh;

    private Date mjsj;

    private int mjzt;

    private Date mjxcsj;

    private static final long serialVersionUID = 1L;
}