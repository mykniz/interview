import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyExample {
    public static void main(String[] args) {

        MyInvocationHandler handler = new MyInvocationHandler();

        MyInterface o = (MyInterface) Proxy.newProxyInstance(
                MyInvocationHandler.class.getClassLoader(),
                new Class[]{MyInterface.class}, handler);

        o.doSomething();

    }

}


class MyInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("the invoked method: " + method);
        return null;
    }

}

interface MyInterface {
    void doSomething ();
}