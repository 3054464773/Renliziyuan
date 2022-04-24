package com.trkj.renliziyuangl.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * jixiaopinfenbiao
 * @author 
 */
@Data
public class Jixiaopinfenbiao implements Serializable {
    private int jxbh;

    private int jbh;

    private int ybh;

    private Date jxsj;

    private int jxfs;

    private static final long serialVersionUID = 1L;
}