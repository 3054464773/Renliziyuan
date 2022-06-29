package com.trkj.renliziyuangl.pojo;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * jiaoseqianduanbiao
 * @author 
 */
@Data
public class Jiaoseqianduanbiao implements Serializable {
    @TableId
    private int qdjsid;

    private int jsid;

    private int qdid;




    private static final long serialVersionUID = 1L;
}