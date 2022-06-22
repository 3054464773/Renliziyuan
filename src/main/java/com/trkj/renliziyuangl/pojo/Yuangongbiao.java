package com.trkj.renliziyuangl.pojo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
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

    private int ygzt;
    @Size(max = 6,min = 3)
    private String yzh;
    @Size(max = 10,min =6)
    private String ymm;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date ygrzsj;
    private static final long serialVersionUID = 1L;
}