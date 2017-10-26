package com.xxq2dream.designpatternsexamples.factory_pattern.iohandle;

/**
 * 普通文件存储
 *
 * @author xxq
 * @date 2017/10/26
 */
public class FileHandler extends AbstractIoHandler {

    @Override
    public void add(String id, String name){
        //业务处理
    }

    @Override
    public void remove(String id) {
        //业务处理
    }

    @Override
    public void update(String id, String name) {
        //业务处理
    }

    @Override
    public String query(String id) {
        return "";
    }
}
