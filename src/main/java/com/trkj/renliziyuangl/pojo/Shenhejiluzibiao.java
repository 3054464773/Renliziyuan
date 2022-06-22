package com.trkj.renliziyuangl.pojo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * shenhejiluzibiao
 * @author 
 */
@Data
public class Shenhejiluzibiao implements Serializable {
    @TableId
    private int shjlzbbh;

    private int shsxid;

    private int ybh;

    private int shjlbh;

    private int shjlzzt;

    private Date shjlzsj;

    private String shjlzbz;

    private static final long serialVersionUID = 1L;
}