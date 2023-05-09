package dynamic.proxy.cg_lib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * <p> 2023/5/9 </p>
 * 代理工厂
 * <br> 1、获取代理对象
 * <br> 2、执行代理方法
 *
 * @author Fqq
 */
public class ProxyFactory implements MethodInterceptor {

    // 目标对象
    private final Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * 获取 target 对象的代理对象
     *
     * @return 代理对象
     */
    public Object getProxyInstance() {

        // 创建一个工具类
        Enhancer enhancer = new Enhancer();
        // 设置父类
        enhancer.setSuperclass(target.getClass());
        // 设置回调函数
        enhancer.setCallback(this);
        // 创建子类对象，即代理对象
        return enhancer.create();
    }

    /**
     * 重写 intercept 方法，会调用目标对象的方法
     *
     * @param proxyTargetObject
     * @param method
     * @param args
     * @param methodProxy
     * @return
     */
    @Override
    public Object intercept(Object proxyTargetObject, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

        System.out.println(">>>>>> Cglib 代理开始 >>>>>>");

        System.out.println("代理对象: " + proxyTargetObject.getClass().getSuperclass());
        System.out.println("执行的方法: " + method.getName());

        Object returnVal = method.invoke(target, args);

        System.out.println(">>>>>> Cglib 代理结束 >>>>>>");
        return returnVal.toString() + " - 被改变了返回值";
    }
}
