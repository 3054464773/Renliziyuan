package com.trkj.renliziyuangl.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.Date;

@Data
public class gradeVo {

    private int jbh;
    private int ybh;
    private int jxbh;
    private String jmc;
    private String jnr;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date jxsj;
    private int jxfs;
    private String rzname;
    private String jdjb;
    private int jdfs;
}
