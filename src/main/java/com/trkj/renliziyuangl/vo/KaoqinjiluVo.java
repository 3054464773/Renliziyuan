package com.trkj.renliziyuangl.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;


import java.sql.Timestamp;
import java.util.Date;
@Data
public class KaoqinjiluVo {
    private  int ybh;
    private String rzname;
    private String rzsex;
private  int rzbh;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Timestamp kqsbdksj;
    private int kqsbzt;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Timestamp kqxbdksj;
    private int kqxbzt;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date xzsj;
}
