package com.wmd.adapter.baserecyadapter;

/**
 * 时间：2017/11/23/17：44
 * 作者：MingDe_Wu
 * 网站：https://github.com/Edwardwmd
 * 作用：
 * 声明：版权归作者所有
 */

public class ContBean {

    private int image;

    public ContBean(int image, String textName) {
        this.image = image;
        this.textName = textName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTextName() {
        return textName;
    }

    public void setTextName(String textName) {
        this.textName = textName;
    }

    private String textName;
}
