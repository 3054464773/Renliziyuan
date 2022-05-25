package com.trkj.renliziyuangl.pojo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * tongzhibiao
 * @author 
 */
@Data
public class Tongzhibiao implements Serializable {
    @TableId
    private int tzbh;

    private int ybh;

    private int bmbh;

    private String tznr;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date tzsj;

    private int tzyds;

    private String tzbt;

    private String rzname;

    private String bmmc;

    private static final long serialVersionUID = 1L;
}