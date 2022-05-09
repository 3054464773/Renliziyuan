package com.trkj.renliziyuangl.pojo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * bumenbiao
 * @author 
 */
@Data
public class Bumenbiao implements Serializable {
    @TableId
    private int bmbh;

    private String bmmc;

    private String bmjs;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date bmsj;

    private static final long serialVersionUID = 1L;
}