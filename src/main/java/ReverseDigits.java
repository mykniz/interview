public class ReverseDigits {
    public static void main(String[] args) {
        System.out.println(reverse(12345));
    }

    public static int reverse(int n) {

        int rev = 0;
        while (n != 0) {
            int digit = n % 10;
            rev = rev * 10 + digit;
            n /= 10;
        }
        return rev;
    }
}
