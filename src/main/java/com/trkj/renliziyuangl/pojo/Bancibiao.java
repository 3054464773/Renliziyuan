package com.trkj.renliziyuangl.pojo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * bancibiao
 * @author 
 */
@Data
public class Bancibiao implements Serializable {
    @TableId
    private int bcbh;

    private String bcmc;

    @JsonFormat(pattern = "HH:mm")
    private Date bckssj;

    @JsonFormat(pattern = "HH:mm")
    private Date bcjssj;

    private int bcissc;

    private static final long serialVersionUID = 1L;
}