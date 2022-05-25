package com.trkj.renliziyuangl.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * mianshiguizhanbiao
 * @author 
 */
@Data
public class Mianshiguizhanbiao implements Serializable {
    @TableId(value = "mbh",type = IdType.AUTO)
    private int mbh;

    private int ybh;

    private int zwbh;

    private String mmc;

    private static final long serialVersionUID = 1L;
}