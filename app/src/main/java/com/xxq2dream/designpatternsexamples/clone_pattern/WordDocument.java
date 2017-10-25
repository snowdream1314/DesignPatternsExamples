package com.xxq2dream.designpatternsexamples.clone_pattern;

import java.util.ArrayList;

/**
 * Description : 原型模式用例
 * <p>
 * Author      : Created by xxq on 2017/10/25.
 */


public class WordDocument implements Cloneable {
    //文本
    private String text;

    //图片
    private ArrayList<String> images = new ArrayList<String>();

    public WordDocument() {
        System.out.println("---WordDocument 构造函数---");
    }

    @Override
    protected WordDocument clone() {
        try {
            WordDocument document = (WordDocument) super.clone();
            document.text = this.text;
//            document.images = this.images;
            document.images = (ArrayList<String>) this.images.clone();
            return document;

        }catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void addImage(String img) {
        images.add(img);
    }

    /**
     * 打印文档内容
     */
    public void showDocument() {
        System.out.println("---Word content start---");
        System.out.println("Text : " + text);
        System.out.println("images list : ");
        for (String name : images) {
            System.out.println("image name : " + name);
        }
        System.out.println("---Word content end---");
    }

}
