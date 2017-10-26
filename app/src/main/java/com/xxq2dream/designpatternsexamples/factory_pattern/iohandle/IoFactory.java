package com.xxq2dream.designpatternsexamples.factory_pattern.iohandle;

/**
 * 持久化存储的工厂
 *
 * @author xxq
 * @date 2017/10/26
 */
public class IoFactory {

    /**
     * 获取IoHandler
     *
     * @param clz AbstractIoHandler类型的类
     * @return AbstractIoHandler对象
     */
    public static <T extends AbstractIoHandler> T getIoHandler(Class<T> clz) {
        AbstractIoHandler handler = null;
        try {
            handler = (AbstractIoHandler) Class.forName(clz.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (T) handler;
    }
}
