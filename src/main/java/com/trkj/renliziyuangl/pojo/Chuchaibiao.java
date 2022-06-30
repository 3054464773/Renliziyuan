package com.trkj.renliziyuangl.pojo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * chuchaibiao
 * @author 
 */
@Data
public class Chuchaibiao implements Serializable {
    private int cbh;

    private int shbid;

    private int shjlbh;

    private String ccfd;

    private String cmdd;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date ckssj;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date cyjsj;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date csjsj;

    private int czt;

    private String cccnr;
    @TableField(exist = false)
    private int shjlzt;

    @TableField(exist = false)
    private String rzname;

    private static final long serialVersionUID = 1L;
}