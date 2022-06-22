package com.trkj.renliziyuangl.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * nashuibiao
 * @author 
 */
@Data
public class Nashuibiao implements Serializable {
    @TableId
    private int nsbbh;

    private int shbid;

    private int shjlbh;

    private int nszdjne;

    private int nszgjne;

    private int nsjnbl;

    private static final long serialVersionUID = 1L;
}