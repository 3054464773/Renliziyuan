package com.trkj.renliziyuangl.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class MianshigzVo {
    @TableId
    private int mbh;
    private int ybh;
    private int zwbh;
    private String mmc;
    private int ybh1;
    private String mzwt;
}
