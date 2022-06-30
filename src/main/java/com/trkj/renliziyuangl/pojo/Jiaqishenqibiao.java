package com.trkj.renliziyuangl.pojo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * jiaqishenqibiao
 * @author 
 */
@Data
public class Jiaqishenqibiao implements Serializable {
    private int jqsqbh;

    private int shjlbh;

    private int kqjqbh;

    private int shbid;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date jqsqkssj;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date jqsqjssj;
    @TableField(exist = false)
    private String rzname;
    @TableField(exist = false)
    private String kqjqmc;
    private static final long serialVersionUID = 1L;
}