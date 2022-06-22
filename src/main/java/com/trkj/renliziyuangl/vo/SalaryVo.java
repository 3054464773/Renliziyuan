package com.trkj.renliziyuangl.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class SalaryVo {

    private int ybh;
    private int xzjlbh;
    private String rzname;
    private String bmmc;
    private int xzjljbgz;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date szjlsj;
    private String xzysmc;
    private int xzysje;
}
