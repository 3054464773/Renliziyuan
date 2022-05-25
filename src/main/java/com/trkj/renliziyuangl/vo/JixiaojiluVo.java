package com.trkj.renliziyuangl.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class JixiaojiluVo {
    @TableId
    private  int ybh;
    private String rzname;
    private  int rzbh;
    private String rzsex;

    private String jnr;
    private String jmc;
}
