package com.trkj.renliziyuangl.vo;

import lombok.Data;

import java.util.List;

@Data
public class Jiaoseandquanxianvo {
    private int jsbh;
    private String jsmc;
    private List<String> qxmc;
    private int ybh;
    private int[] jsbhs;
}
