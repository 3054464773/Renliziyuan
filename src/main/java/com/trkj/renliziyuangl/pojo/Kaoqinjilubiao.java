package com.trkj.renliziyuangl.pojo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * kaoqinjilubiao
 * @author 
 */
@Data
public class Kaoqinjilubiao implements Serializable {
    @TableId(value = "kqjlbh",type = IdType.AUTO)
    private int kqjlbh;

    private int ybh;

    @JsonFormat(pattern = "HH:mm")
    private Date kqsbdksj;

    private int kqsbzt;

    @JsonFormat(pattern = "HH:mm")
    private Date kqxbdksj;

    private int kqxbzt;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date xzsj;

    private String rzname;

    private String bmmc;

    private static final long serialVersionUID = 1L;
}