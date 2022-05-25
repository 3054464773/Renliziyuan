package com.trkj.renliziyuangl.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * mianshiguizhanzibiao
 * @author 
 */
@Data
public class Mianshiguizhanzibiao implements Serializable {
    @TableId(value = "mzbh",type = IdType.AUTO)
    private int mzbh;

    private int mbh;

    private int ybh;

    private String mzwt;

    private static final long serialVersionUID = 1L;
}