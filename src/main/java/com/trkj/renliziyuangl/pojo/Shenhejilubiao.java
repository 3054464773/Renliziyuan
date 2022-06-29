package com.trkj.renliziyuangl.pojo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * shenhejilubiao
 * @author 
 */
@Data
public class Shenhejilubiao implements Serializable {
    @TableId(value = "shjlbh",type = IdType.AUTO)
    private int shjlbh;

    private int ybh;

    private int shjlzt;

    private Date shjlsj;

    private static final long serialVersionUID = 1L;
}