package com.trkj.renliziyuangl.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * yuangongbiao
 * @author 
 */
@Data
public class Yuangongbiao implements Serializable {
    @TableId
    private int ybh;

    private int bcbh;

    private int rzbh;

    private int zwbh;

    private int sbbh;

    private int ygzt;

    private String yzh;

    private String ymm;

    private static final long serialVersionUID = 1L;
}