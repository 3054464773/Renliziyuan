package com.trkj.renliziyuangl.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
@Data
public class MianshijiluVo {
    @TableId
   private  int ybh;
    private String rzname;
    private String rzsex;
    private  int rzbh;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date mjsj;
    private int mjzt;
    private int rid;
}
