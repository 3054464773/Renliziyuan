package com.trkj.renliziyuangl.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.apache.ibatis.annotations.Insert;

/**
 * shenghebiao
 * @author 
 */
@Data
public class Shenghebiao implements Serializable {
    @TableId(value = "shbid",type = IdType.AUTO)
    private int shbid;

    private int jsbh;

    private String shbmc;

    private int shzt;
    @TableField(exist = false)

    private String jsmc;

    private static final long serialVersionUID = 1L;
}