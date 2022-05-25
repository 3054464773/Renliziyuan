package com.trkj.renliziyuangl.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * kaoqinjiaqilxbiao
 * @author 
 */
@Data
public class Kaoqinjiaqilxbiao implements Serializable {
    @TableId
    private int kqjqbh;

    private int kqjqlx;

    private String kqjqmc;

    private int issc;

    private static final long serialVersionUID = 1L;
}