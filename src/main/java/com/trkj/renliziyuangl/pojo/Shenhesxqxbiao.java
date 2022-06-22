package com.trkj.renliziyuangl.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * shenhesxqxbiao
 * @author 
 */
@Data
public class Shenhesxqxbiao implements Serializable {
    @TableId
    private int shsxid;

    private int shbid;

    private int jsbh;
    @TableField(exist = false)
    private String jsmc;

    @TableField(exist = false)
    private int[] jsbhh;

    private static final long serialVersionUID = 1L;
}