package com.trkj.renliziyuangl.pojo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * mianshijilubiao
 * @author 
 */
@Data
public class Mianshijilubiao implements Serializable {
    @TableId(value = "mjbh",type = IdType.AUTO)
    private int mjbh;

    private int rid;

    private int ybh;

    private int mzbh;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date mjsj;

    private int mjzt;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date mjxcsj;
    private String mspj;

    private static final long serialVersionUID = 1L;
}