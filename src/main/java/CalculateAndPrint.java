import java.nio.charset.StandardCharsets;

public class CalculateAndPrint {
    public static void main(String[] args) {

        calculateAndPrint(1211);

    }

    static void calculateAndPrint(int n) {

        //--------------------------------------//
        // короткое решение
        // System.out.println((n/100)%2==0?(n+=100):(n*=2));
        //--------------------------------------//

        char[] c = String.valueOf(n % 1000).toCharArray();
        for (int i = 0; i < 1; i++) {
            if (c[0] % 2 == 0) {
                System.out.println(n + 100);
            } else {
                System.out.println(n * 2);
            }

        }
    }
}
