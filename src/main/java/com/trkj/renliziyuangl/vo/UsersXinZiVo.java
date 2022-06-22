package com.trkj.renliziyuangl.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class UsersXinZiVo {
    public int ybh;
    private String rzname;
    private int zwbh;
    private int xzjbgz;
    private int xzjlsb;
    private int szjlze;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date szjlsj;
    private int rzbh;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date ygrzsj;
    private String zwmc;
    private String bmmc;
}
