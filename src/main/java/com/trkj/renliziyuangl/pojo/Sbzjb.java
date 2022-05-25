package com.trkj.renliziyuangl.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * sbzjb
 * @author 
 */
@Data
public class Sbzjb implements Serializable {
    @TableId
    private int sbbh;

    private int sbjsbh;

    private static final long serialVersionUID = 1L;
}