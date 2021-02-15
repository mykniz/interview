public class Fibonacci {
    public static void main(String[] args) {

        printFibonacci(2^64);

    }

    static void printFibonacci(long n) {

//------------------------------------------------//
//        красивое решение:
//------------------------------------------------//
//        long x = 0, y = 1;
//        for (long i = 0; i < n; ++i) {
//            long t = y;
//            y = x + y;
//            x = t;
//        }
//        System.out.println(x);
//------------------------------------------------//


        long f_0 = 0;
        long f_1 = 1;
        long f_n = 0;

        if (n == 0) {
            System.out.println(f_0);
        }
        else if (n == 1) {
            System.out.println(f_1);
        }
        else {
            for (long i = 0; i < n - 1; i++) {
               f_n = f_0 + f_1;
               f_0 = f_1;
               f_1 = f_n;
            }
            System.out.println(f_n);
        }

    }
}
