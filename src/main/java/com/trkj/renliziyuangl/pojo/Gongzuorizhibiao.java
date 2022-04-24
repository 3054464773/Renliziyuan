package com.trkj.renliziyuangl.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * gongzuorizhibiao
 * @author 
 */
@Data
public class Gongzuorizhibiao implements Serializable {
    private int gzrzbh;

    private int ybh;

    private String gzrznr;

    private Date gzrzsj;

    private static final long serialVersionUID = 1L;
}