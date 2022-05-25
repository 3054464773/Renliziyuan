package com.trkj.renliziyuangl.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * shebaofananbiao
 * @author 
 */
@Data
public class Shebaofananbiao implements Serializable {
    @TableId(value = "sbbh",type = IdType.AUTO)
    private int sbbh;

    private int shjlbh;

    private int shbid;

    private String sbmc;

    private int sbzt;

    private static final long serialVersionUID = 1L;
}