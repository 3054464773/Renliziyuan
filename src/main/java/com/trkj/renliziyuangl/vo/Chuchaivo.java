package com.trkj.renliziyuangl.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
@Data
public class Chuchaivo {
    @TableId
    private  int ybh;
    private String rzname;
    private  int rzbh;
    private String rzsex;
    private String ccfd;
    private String cmdd;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date ckssj;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date cyjsj;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date csjsj;
    private int czt;
    private String cccnr;
}
