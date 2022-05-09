package com.trkj.renliziyuangl.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.Size;

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

    private String ygzt;
    @Size(max = 6,min = 3)
    private String yzh;
    @Size(max = 10,min =6)
    private String ymm;

    private static final long serialVersionUID = 1L;
}