package com.trkj.renliziyuangl.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * zhiweibiao
 * @author 
 */
@Data
public class Zhiweibiao implements Serializable {
    private int zwbh;

    private int bmbh;

    private int zwjs;

    private int zwmc;

    private Date zwsj;

    private static final long serialVersionUID = 1L;
}