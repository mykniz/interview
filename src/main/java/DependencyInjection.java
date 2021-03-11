
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DependencyInjection {
    public static void main(String[] args) throws Exception {
        List<Object> objects = new ArrayList<>();
        List<Object> otherObjects = new ArrayList<>();
        List<Object> diffObjects = new ArrayList<>();

        objects.add(new Z());
        objects.add(new B());
        objects.add(new C());
        otherObjects.add(new C());

        dependencyInjection(List.of(new B()));
        // dependencyInjection(otherObjects);
    }

    static void dependencyInjection(List<Object> objects) throws Exception {
        //enter your code
        int check = 0;
        for (Object o : objects) {
            System.out.println("Info for object " + o.getClass().getName() + ":" + "\n");
            for (Field f : o.getClass().getDeclaredFields()) {
                for (Method m : o.getClass().getDeclaredMethods()) {
                    System.out.println("Name for method " + m.getName());
                    System.out.println("Param types are " + Arrays.toString(m.getParameterTypes()));
                    //&& m.getName().matches("set.")
                    for (Class c : m.getParameterTypes()) {
                        if (f.isAnnotationPresent(Autowired.class)) {
                            check++;
                            System.out.println("Name for annotated field is " + f.getName());
                            System.out.println("Type of field is " + f.getType() + "\n---------");
                        }
                    }
                }
            }
        }

        if (check == 0) {
            throw new CandidateNotFindException();
        }
    }
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Autowired {
}

class CandidateNotFindException extends RuntimeException {
}

class Z {
    @Autowired
    B b;

    C c;

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public C getC() {
        return c;
    }

    public void setC(C c) {
        this.c = c;
    }
}

class B {
    @Autowired
    C c;

    public C getC() {
        return c;
    }

    public void setC(C c) {
        this.c = c;
    }
}

class C {

}