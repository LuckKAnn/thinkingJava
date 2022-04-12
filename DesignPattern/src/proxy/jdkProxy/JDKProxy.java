package proxy.jdkProxy;

import javax.security.auth.Subject;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @FileName: JDKProxy
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/3/10 10:16
 */
public class JDKProxy implements InvocationHandler {

     Object object;

    public Object bind(Object ob){
        this.object = ob;
     return  Proxy.newProxyInstance(ob.getClass().getClassLoader(),ob.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("pre execute");
        Object invoke = method.invoke(object, args);
        System.out.println("after execute");
        return invoke;
    }

    public static void main(String[] args) {
        JDKProxy jdkProxy = new JDKProxy();
        SubJect subJect = new SubjectImpl();
        SubJect sss =(SubJect) jdkProxy.bind(subJect);
        sss.doSomething();

    }
}
