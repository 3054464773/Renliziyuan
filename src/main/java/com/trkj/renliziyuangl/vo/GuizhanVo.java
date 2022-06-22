package com.trkj.renliziyuangl.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class GuizhanVo {
    @TableId(value = "mbh",type = IdType.AUTO)
    private int mbh;

    private int ybh;

    private int zwbh;

    private String mmc;

    private String zwmc;
    private String bmmc;
}
