package com.trkj.renliziyuangl.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * gonggaobiao
 * @author 
 */
@Data
public class Gonggaobiao implements Serializable {
    private int ggbh;

    private int ybh;

    private String ggnr;

    private Date ggsj;

    private int ggyds;

    private static final long serialVersionUID = 1L;
}