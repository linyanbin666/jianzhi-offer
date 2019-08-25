package com.horizon.chapter2;

/**
 * 单例模式的实现：
 *  1. 懒汉方式
 *      1). 双重检锁线程安全实现
 *      2). 静态内部类实现
 *  2. 饿汉方式
 *  3. 枚举类
 */
public class Singleton {

    // 私有构造
    private Singleton() {}

    // 静态工厂
    public static Singleton getInstance() {
        return Holder.instance;
    }

    // 静态内部类
    private static class Holder {
        // 静态变量
        private static Singleton instance = new Singleton();
    }

}
