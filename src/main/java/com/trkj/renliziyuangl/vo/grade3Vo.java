package com.trkj.renliziyuangl.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class grade3Vo {
    private int jxbh;
    private int jdbh;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date jxsj;
    private int jxfs;
    private String jdjb;
    private int jdfs;
}
