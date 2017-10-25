package com.xxq2dream.designpatternsexamples.clone_pattern;

import org.junit.Test;

/**
 * Description :
 * <p>
 * Author      : Created by xxq on 2017/10/25.
 */

public class WordDocumentTest {
    @Test
    public void showDocument() throws Exception {
        WordDocument doc1 = new WordDocument();
        doc1.setText("这是一篇文档");
        doc1.addImage("图片1");
        doc1.addImage("图片2");
        doc1.addImage("图片3");
        doc1.showDocument();

        WordDocument doc2 = doc1.clone();
        doc2.showDocument();

        doc2.setText("这是修改过的文档");
        doc2.addImage("图片4");
        doc2.showDocument();

        doc1.showDocument();
    }


}