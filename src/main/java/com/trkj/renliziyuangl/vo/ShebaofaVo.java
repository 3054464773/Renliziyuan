package com.trkj.renliziyuangl.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import java.util.List;

@Data
public class ShebaofaVo {
    @TableId
    private int sbbh;
    private String sbmc;
    private int sbzt;
    private int sbjsbh;
    private int sbjsje;
    private String sbname;
    private int sbjnbl;
    private List qbsj;
    @TableField(exist = false)
    int [] sbjslistss; //接受修改社保方案的值
}
