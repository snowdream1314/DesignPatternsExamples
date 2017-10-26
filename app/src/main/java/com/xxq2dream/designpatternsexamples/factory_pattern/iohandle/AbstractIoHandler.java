package com.xxq2dream.designpatternsexamples.factory_pattern.iohandle;

/**
 * 封装增删改查操作
 *
 * @author xxq
 * @date 2017/10/26
 */
public abstract class AbstractIoHandler {

    /**
     * 添加个人信息
     *
     * @param id 身份证号码
     * @param name 姓名
     */
    public abstract void add(String id, String name);

    /**
     * 根据ID删除一条信息
     *
     * @param id 身份证
     */
    public abstract void remove(String id);

    /**
     * 更新个人信息
     *
     * @param id 身份证
     * @param name 姓名
     */
    public abstract void update(String id, String name);

    /**
     * 查询ID对应的信息
     *
     * @param id 身份证
     * @return 人名
     */
    public abstract String query(String id);

}


