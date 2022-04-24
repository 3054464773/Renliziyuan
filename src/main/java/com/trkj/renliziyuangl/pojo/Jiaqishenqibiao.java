package com.trkj.renliziyuangl.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * jiaqishenqibiao
 * @author 
 */
@Data
public class Jiaqishenqibiao implements Serializable {
    private int jqsqbh;

    private int shjlbh;

    private int kqjqbh;

    private int shbid;

    private Date jqsqkssj;

    private Date jqsqjssj;

    private static final long serialVersionUID = 1L;
}