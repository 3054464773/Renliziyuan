package com.trkj.renliziyuangl.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * qianduanbiao
 * @author 
 */
@Data
public class Qianduanbiao implements Serializable {
    @TableId
    private int qdbid;

    private String qdlydz;

    private String qdlymc;

    private String qdzjmc;

    private String qdcdmc;

    private int qdfjid;

    private static final long serialVersionUID = 1L;
}