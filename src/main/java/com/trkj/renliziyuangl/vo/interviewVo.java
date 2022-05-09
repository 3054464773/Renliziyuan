package com.trkj.renliziyuangl.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
@Data
public class interviewVo {
    private int rid;
    private String rzname;
    private int rzbh;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date rsj;
    private int rzt;
}
