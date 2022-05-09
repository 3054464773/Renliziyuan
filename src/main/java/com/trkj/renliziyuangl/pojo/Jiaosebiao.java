package com.trkj.renliziyuangl.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.Size;

/**
 * jiaosebiao
 * @author 
 */
@Data
public class Jiaosebiao implements Serializable {
    @TableId
    private int jsbh;
    @Size(max =20,min = 4)
    private String jsmc;
    @Size(max =20,min = 4)
    private String jkey;

    private static final long serialVersionUID = 1L;
}