package com.trkj.renliziyuangl.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class zwVo {
    @TableId
    private int zwbh;

    private int bmbh;

    private String zwjs;

    private String zwmc;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date zwsj;

    private int zwbh2;

    private Double xzjbgz;
}
