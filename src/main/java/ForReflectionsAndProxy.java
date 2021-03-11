import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ForReflectionsAndProxy {
    public static void main(String[] args) throws Exception {

//--------------------------------------task 2-----------------------------------------//
//        NewClass newClass = new NewClass();
//        String privet = "sayPrivet";
//        String calc = "calc";
//        Class[] params = {int.class, String.class};
//        Class[] params2 = {};
//        int[] params3 = {3};
//        int x = 3;
//        String text = "text";
//        callMethodByName(newClass, calc, x);
//        callMethodByName(newClass, privet, text);

//--------------------------------------task 2-----------------------------------------//

//        WeightAnnotationClass weightAnnotationClass = new WeightAnnotationClass();
//        callMethodByWeight(weightAnnotationClass);

//--------------------------------------task 3-----------------------------------------//

        Base baseOne = new BaseClass();

        Base baseTwo = createProxy(baseOne);
        baseTwo.method1();
        baseTwo.method2();

    }

    <T> void printAllClassFields(Class<T> aClass) {
        Field[] fields = aClass.getDeclaredFields();
        Arrays.stream(fields).sorted().forEach(System.out::println);
    }

    static void callMethodByName(Object object, String methodName, Object... params) throws Exception {
        Method[] methods = object.getClass().getMethods();
        for (Method m : methods
        ) {
            if (m.getName().equals(methodName)) {
                m.invoke(object, params);
            }
        }
    }

    static void callMethodByWeight(Object object) throws Exception {
        Method[] methods = object.getClass().getDeclaredMethods();
        List<Method> list = Arrays.stream(methods)
                .filter(m -> m.isAnnotationPresent(Weight.class))
                .sorted(Comparator.comparing(m -> m.getAnnotation(Weight.class).value()))
                .collect(Collectors.toList());

        for (Method m : list
        ) {
            m.invoke(object);
        }
    }

    static Base createProxy(Base object) throws Exception {
        Method[] methods = object.getClass().getDeclaredMethods();
        class MyHandler implements InvocationHandler {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                for (Method m : methods) {
                    if (method.getName().equals(m.getName()) && m.isAnnotationPresent(Logging.class)) {
                        System.out.println("Before call " + method.getName());
                        method.invoke(object);
                        System.out.println("After call " + method.getName());
                    } else if (method.getName().equals(m.getName())) {
                        method.invoke(object);
                    }
                }
                return null;
            }
        }

        MyHandler myHandler = new MyHandler();

        return (Base) Proxy.newProxyInstance(
                object.getClass().getClassLoader(),
                new Class[]{Base.class},
                myHandler);
    }
}


//******************************************************//
//******************************************************//
//******************************************************//


class A {
    final int age;
    final String name;

    public A(int age, String name) {
        this.age = age;
        this.name = name;
    }
}

//******************************************************//

class NewClass {
    public void sayHello() {
        System.out.println("Hello world!!!");
    }

    public void calc(int x) {
        System.out.println("Calculation to " + x);
    }

    public void sayPrivet(String s) {
        System.out.println("Privet " + s);
    }
}

//******************************************************//

class WeightAnnotationClass {
    @Weight(10)
    void method1() {
        System.out.println("method1");
    }

    @Weight(3)
    void method2() {
        System.out.println("method2");
    }

    @Weight(21)
    void method3() {
        System.out.println("method3");
    }
}

//******************************************************//

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Weight {
    int value();
}

//******************************************************//

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Logging {
}

//******************************************************//

class BaseClass implements Base {
    @Logging
    public void method1() {
        System.out.println("A method1");
    }

    public void method2() {
        System.out.println("A method2");
    }
}
//******************************************************//

interface Base {
    void method1();

    void method2();
}