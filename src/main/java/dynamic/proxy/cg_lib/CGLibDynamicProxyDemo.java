package dynamic.proxy.cg_lib;

/**
 * 由于 JDK 8 中有关反射相关的功能自从 JDK 9 开始就已经被限制了，为了兼容原先的版本，需要在运行项目时添加 VM options
 * `--add-opens java.base/java.lang=ALL-UNNAMED`
 * 选项来开启这种默认不被允许的行为。
 * <br> CGLib 代理必须能够被继承生成子类，通过生成子类的方法实现代理
 */
public class CGLibDynamicProxyDemo {
    public static void main(String[] args) {
        // 创建目标对象
        ProxiedObject target = new ProxiedObject();
        // 通过目标对象获取代理对象
        ProxiedObject proxyInstance = (ProxiedObject) new ProxyFactory(target).getProxyInstance();
        // 执行代理对象的方法，触发 intercept 方法，从而实现对目标对象的调用
        String wasProxiedMethod = proxyInstance.genericMethod();
        System.out.println(wasProxiedMethod);
    }
}

