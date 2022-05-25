package com.trkj.renliziyuangl.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class grade2Vo {
    private int jxbh;
    private int jdbh;
    private int jbh;
    private int ybh;
    private String jmc;
    private String jnr;
    private String rzname;
    private String bmmc;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date jxsj;
    private int jxfs;
    private String jdjb;
    private int jdfs;
}
