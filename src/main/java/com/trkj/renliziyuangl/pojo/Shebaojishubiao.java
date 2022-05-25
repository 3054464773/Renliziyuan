package com.trkj.renliziyuangl.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * shebaojishubiao
 * @author 
 */
@Data
public class Shebaojishubiao implements Serializable {
    @TableId
    private int sbjsbh;

    private int shjlbh;

    private int shbid;

    private int sbjsje;

    private String sbname;

    private int sbjnbl;

    private static final long serialVersionUID = 1L;
}