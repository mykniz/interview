import java.nio.charset.StandardCharsets;

public class CheckPalindrom {
    public static void main(String[] args) {
        checkPalindrom("Olson in Oslot");
    }

    static void checkPalindrom(String s) {

        //------------------------------------------------//
        // проще использовать StringBuilder c методом reverse :3
        //------------------------------------------------//
        // String s1 = s.replaceAll("\\W", "").toLowerCase();
        // System.out.println(s1.equals(new StringBuilder(s1).reverse().toString()) ? "yes" : "no");
        //------------------------------------------------//


        char[] buffChar = s.toLowerCase().replaceAll("[^\\w]", "").toCharArray();
        int j = buffChar.length - 1;
        boolean val = false;

        for (int i = 0; i < buffChar.length; i++) {
            if (buffChar[i] == buffChar[j]) {
                val = true;
            } else {
                val = false;
            }
            j--;
        }

        if (val == true) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
