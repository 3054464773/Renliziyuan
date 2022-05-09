package com.trkj.renliziyuangl.pojo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * zhiweibiao
 * @author 
 */
@Data
public class Zhiweibiao implements Serializable {
    @TableId
    private int zwbh;

    private int bmbh;

    private String zwjs;

    private String zwmc;

    private Date zwsj;

    private static final long serialVersionUID = 1L;
}