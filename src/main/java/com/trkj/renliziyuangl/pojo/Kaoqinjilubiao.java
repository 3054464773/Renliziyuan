package com.trkj.renliziyuangl.pojo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * kaoqinjilubiao
 * @author 
 */
@Data
public class Kaoqinjilubiao implements Serializable {
    private int kqjlbh;

    private int ybh;

    @JsonFormat(pattern = "HH:mm")
    private Date kqsbdksj;

    private int kqsbzt;

    @JsonFormat(pattern = "HH:mm")
    private Date kqxbdksj;

    private int kqxbzt;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date xzsj;

    private String rzname;

    private String bmmc;

    private static final long serialVersionUID = 1L;
}