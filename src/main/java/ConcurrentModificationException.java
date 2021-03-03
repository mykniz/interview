import java.util.ArrayList;
import java.util.List;

public class ConcurrentModificationException {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        System.out.println(list);

        new ConcurrentModificationException().genConcurrentModificationException(list);


    }

    void genConcurrentModificationException(List<Integer> integers) {

        for (Integer integer : integers) {
            integers.remove(integer);
        }

        System.out.println(integers);
    }

}
