import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

public class FactoryT {
    public static void main(String[] args) throws Exception {

        F2 factory = new F2();
        factory.generateInstance();

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        System.out.println(arrayList);

        arrayList.remove(0);
        System.out.println(arrayList);
    }
}

abstract class Factory<T> {
    public Factory() {
    }

    public T generateInstance() throws Exception {

        Type type = ((ParameterizedType)this.getClass().
                getGenericSuperclass()).getActualTypeArguments()[0];

        System.out.println(((ParameterizedType)this.getClass().
                getGenericSuperclass()).getActualTypeArguments()[0]);


        return null;

    }
}

class F2 extends Factory<String> {

}