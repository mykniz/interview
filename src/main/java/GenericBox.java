public class GenericBox {
    public static void main(String[] args) {

        GenericBox genericBox = new GenericBox();
        System.out.println(genericBox.boxingValue(1.22));

    }

    Box<Integer> boxingValue(double value) {
        // enter your code
        Box<? super Integer> box = new Box<>(value);
        Integer v = (Integer) box.getValue();
        Box<Integer> box2 = new Box<>(v);
        return box2;
    }

}



class Box<T> {
    private final T value;

    Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}