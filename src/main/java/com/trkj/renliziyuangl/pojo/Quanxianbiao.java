package com.trkj.renliziyuangl.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * quanxianbiao
 * @author 
 */
@Data
public class Quanxianbiao implements Serializable {
    @TableId
    private int qxbh;

    private String qxmc;

    private String qkey;

    private static final long serialVersionUID = 1L;
}