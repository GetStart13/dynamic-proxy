package dynamic.proxy.jdk;

/**
 * 学生接口，能跑，能吃，能写作文。
 * 默认修饰符，通过 jdk 动态代理生成实现类
 */
interface Student {

    void eat();

    void run();

    void write();
}
