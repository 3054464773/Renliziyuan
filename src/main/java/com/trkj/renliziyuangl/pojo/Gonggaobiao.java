package com.trkj.renliziyuangl.pojo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * gonggaobiao
 * @author 
 */
@Data
public class Gonggaobiao implements Serializable {
    @TableId
    private int ggbh;

    private int ybh;

    private String ggnr;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date ggsj;

    private int ggyds;

    private String ggbt;

    private String rzname;

    private String bmmc;

    private static final long serialVersionUID = 1L;
}