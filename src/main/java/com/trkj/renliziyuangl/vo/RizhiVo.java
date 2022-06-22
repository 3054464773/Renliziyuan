package com.trkj.renliziyuangl.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.Date;

@Data
public class RizhiVo {
    private int gzrzbh;
    private String rzname;
    private String gzrznr;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date gzrzsj;
    private String rzdpnr;
    private int ybh;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date rzdpsj;
}
