package com.trkj.renliziyuangl.vo;

import com.trkj.renliziyuangl.pojo.Jiaosebiao;
import lombok.Data;

import java.util.List;

@Data
public class Fenpeiyhjs {
    private int ybh;
    private String rzname;
    private String zwmc;
    private List<Jiaosebiao> jslist;
}
