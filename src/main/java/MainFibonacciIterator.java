import java.util.Iterator;

public class MainFibonacciIterator {
    public static void main(String[] args) {
        FibonacciIterable fibonacciIterable = new FibonacciIterable(43);
        Iterator<Integer> iterator = fibonacciIterable.iterator();
        while (iterator.hasNext()) {
            Integer f = (Integer) iterator.next();
            System.out.println(f);
        }
    }
}

class FibonacciIterator implements Iterator<Integer> {
    Integer n;
    Integer fib1 = 0;
    Integer fib2 = 1;
    Integer current = 0;
    Integer count = 0;

    public FibonacciIterator(Integer n) {
        this.n = n;
    }

    @Override
    public boolean hasNext() {
        // enter your code
        if (current == Integer.MAX_VALUE) {
            return false;
        }
        return count < n;
    }

    @Override
    public Integer next() {
        // enter your code
        current = fib1;
        fib1 = fib2;
        fib2 = fib1 + current;
        count++;

        return current;
    }

}

class FibonacciIterable implements Iterable<Integer> {

    Integer n;

    public FibonacciIterable() {
    }

    public FibonacciIterable(Integer n) {
        this.n = n;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator(n);
    }
}

