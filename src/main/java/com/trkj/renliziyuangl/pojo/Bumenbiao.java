package com.trkj.renliziyuangl.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * bumenbiao
 * @author 
 */
@Data
public class Bumenbiao implements Serializable {
    private int bmbh;

    private String bmmc;

    private String bmjs;

    private Date bmsj;

    private static final long serialVersionUID = 1L;
}