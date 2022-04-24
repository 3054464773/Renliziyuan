package com.trkj.renliziyuangl.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * chuchaibiao
 * @author 
 */
@Data
public class Chuchaibiao implements Serializable {
    private int cbh;

    private int shbid;

    private int shjlbh;

    private String ccfd;

    private String cmdd;

    private Date ckssj;

    private Date cyjsj;

    private Date csjsj;

    private int czt;

    private String cccnr;

    private static final long serialVersionUID = 1L;
}