package com.trkj.renliziyuangl.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.Size;

/**
 * quanxianbiao
 * @author 
 */
@Data
public class Quanxianbiao implements Serializable {
    @TableId
    private int qxbh;
    @Size(max =20,min = 4)
    private String qxmc;
    @Size(max =20,min = 4)
    private String qkey;

    private static final long serialVersionUID = 1L;
}