package dynamic.proxy.cg_lib;

/**
 * <p> 2023/5/9 </p>
 * 被代理对象
 *
 * @author Fqq
 */
public class ProxiedObject {
    public String genericMethod() {
        String msg = "我是常规方法";
        System.out.println("常规方法被执行，msg：" + msg);
        return msg;
    }
}
