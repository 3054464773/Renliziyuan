package com.trkj.renliziyuangl.pojo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * yuangonggzjlbiao
 * @author 
 */
@Data
public class Yuangonggzjlbiao implements Serializable {
    private int yggzbh;

    private int shbid;

    private int shjlbh;

    private int ybh;

    private int yggzzt;

    private Date yggzsj;

    @TableField(exist = false)
    private String rzname;

    private static final long serialVersionUID = 1L;
}