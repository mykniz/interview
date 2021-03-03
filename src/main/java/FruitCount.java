import java.util.Arrays;


public class FruitCount {

    public static void main(String[] args) {
        Apple apple = new AppleClass();
        Banana banana = new BananaClass();
        Object[] objects = {apple, apple, apple, banana, banana};
        checkFruitCount(objects);

    }

    static void checkFruitCount(Object[] objects) {
        // enter your code
        long a = Arrays.stream(objects)
                .filter(o -> o instanceof Apple).count();

        long b = Arrays.stream(objects)
                .filter(o -> o instanceof Banana).count();

        System.out.println("banana=" + b + ", apple=" + a);
    }
}

interface Apple {

}

class AppleClass implements Apple {

}


interface Banana {

}

class BananaClass implements Banana {

}