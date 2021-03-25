import java.util.ArrayList;
import java.util.List;

public class BigNumberTask {

    public static void main(String[] args) {

        String bigA = "1000000000000000000000000000000000000000000000000000000001";
        String bigB = "-1000000000000000000000000000000000000000000000000000000000";

        BigNumber bigNumberA = new MyBigNumber(bigA);
        BigNumber bigNumberB = new MyBigNumber(bigB);

        System.out.println(bigNumberA.compareTo(bigNumberB));

        System.out.println(bigNumberA.add(bigNumberB));

    }
}


interface BigNumber extends Comparable {
    BigNumber add(BigNumber bigNumber);

    BigNumber sub(BigNumber bigNumber);
}


class MyBigNumber implements BigNumber {

    private final String number;

    public MyBigNumber(String number) {
        this.number = number;
    }

    @Override
    public BigNumber add(BigNumber bigNumber) {

        String stringA = number;
        String stringB = bigNumber.toString();

        String res = "";
        int c = 0;

        if ((stringA.charAt(0) != '-') && (stringB.charAt(0) != '-')) {

            if (stringB.length() > stringA.length()) {
                String temp = stringA;
                stringA = stringB;
                stringB = temp;
            }

            String strA = new StringBuilder(stringA).reverse().toString();
            String strB = new StringBuilder(stringB).reverse().toString();
            int lengthA = stringA.length();
            int lengthB = stringB.length();

            for (int i = 0; i < lengthB; i++) {
                int sum = ((int) (strA.charAt(i) - '0') + (int) (strB.charAt(i) - '0') + c);
                res += (char) (sum % 10 + '0');
                c = sum / 10;
            }

            for (int i = lengthB; i < lengthA; i++) {
                int sum = ((int) (strA.charAt(i) - '0') + c);
                res += (char) (sum % 10 + '0');
                c = sum / 10;
            }
            if (c > 0) {
                res += (char) (c + '0');
            }

            res = new StringBuilder(res).reverse().toString();
            //  System.out.println("the sum of " + stringA + " and " + stringB + " is " + res);
            return new MyBigNumber(res);
        }

        if ((stringA.charAt(0) == '-') && (stringB.charAt(0) == '-')) {

            String strA = new StringBuilder(stringA).reverse().substring(0, stringA.length() - 1);
            String strB = new StringBuilder(stringB).reverse().substring(0, stringB.length() - 1);
            int lengthA = stringA.length() - 1;
            int lengthB = stringB.length() - 1;


            if (stringB.length() > stringA.length()) {
                String temp = stringA;
                stringA = stringB;
                stringB = temp;
            }

            for (int i = 0; i < lengthB; i++) {
                int sum = ((int) (strA.charAt(i) - '0') + (int) (strB.charAt(i) - '0') + c);
                res += (char) (sum % 10 + '0');
                c = sum / 10;
            }

            for (int i = lengthB; i < lengthA; i++) {
                int sum = ((int) (strA.charAt(i) - '0') + c);
                res += (char) (sum % 10 + '0');
                c = sum / 10;
            }
            if (c > 0) {
                res += (char) (c + '0');
            }

            res = res + '-';
            res = new StringBuilder(res).reverse().toString();
            //  System.out.println("the sum of " + stringA + " and " + stringB + " is " + res);
            return new MyBigNumber(res);

        }

        if ((stringA.charAt(0) != '-') && (stringB.charAt(0) == '-')) {
            String stringModuleB = stringB.substring(1);
            BigNumber newB = new MyBigNumber(stringModuleB);
            return this.sub(newB);
        }

        if ((stringA.charAt(0) == '-') && (stringB.charAt(0) != '-')) {
            String stringModuleA = stringA.substring(1);
            BigNumber newA = new MyBigNumber(stringModuleA);
            return newA.sub(bigNumber);

        } else return null;
    }

    @Override
    public BigNumber sub(BigNumber bigNumber) {
        // enter your code
        String stringA = number;
        String stringB = bigNumber.toString();

        if ((stringA.charAt(0) != '-') && (stringB.charAt(0) != '-')) {
            if (this.compareTo(bigNumber) == 1) {
                String str = "";
                int lengthA = stringA.length();
                int lengthB = stringB.length();
                String strA = new StringBuilder(stringA).reverse().toString();
                String strB = new StringBuilder(stringB).reverse().toString();
                int c = 0;
                for (int i = 0; i < lengthB; i++) {
                    int sub = ((int) (strA.charAt(i) - '0') - (int) (strB.charAt(i) - '0') - c);
                    if (sub < 0) {
                        sub = sub + 10;
                        c = 1;
                    } else
                        c = 0;
                    str += (char) (sub + '0');
                }

                for (int i = lengthB; i < lengthA; i++) {
                    int sub = ((int) (strA.charAt(i) - '0') - c);
                    if (sub < 0) {
                        sub = sub + 10;
                        c = 1;
                    } else
                        c = 0;

                    str += (char) (sub + '0');
                }
                str = new StringBuilder(str).reverse().toString();
                //         System.out.println("the sub of " + stringA + " and " + stringB + " is " + str);
                return new MyBigNumber(str);
            }

            if (this.compareTo(bigNumber) == -1) {
                String t = stringA;
                stringA = stringB;
                stringB = t;

                String str = "";
                int lengthA = stringA.length();
                int lengthB = stringB.length();
                String strA = new StringBuilder(stringA).reverse().toString();
                String strB = new StringBuilder(stringB).reverse().toString();
                int c = 0;
                for (int i = 0; i < lengthB; i++) {
                    int sub = ((int) (strA.charAt(i) - '0') - (int) (strB.charAt(i) - '0') - c);
                    if (sub < 0) {
                        sub = sub + 10;
                        c = 1;
                    } else
                        c = 0;
                    str += (char) (sub + '0');
                }

                for (int i = lengthB; i < lengthA; i++) {
                    int sub = ((int) (strA.charAt(i) - '0') - c);
                    if (sub < 0) {
                        sub = sub + 10;
                        c = 1;
                    } else
                        c = 0;

                    str += (char) (sub + '0');
                }

                str = str + '-';
                str = new StringBuilder(str).reverse().toString();
                //         System.out.println("the sub of " + stringB + " and " + stringA + " is " + str);
                return new MyBigNumber(str);
            }
            if (this.compareTo(bigNumber) == 0) {
                //   System.out.println("the sub of " + stringA + " and " + stringB + " is " + new MyBigNumber("0").toString());
                return new MyBigNumber("0");
            }

        }

        if ((stringA.charAt(0) == '-') && (stringB.charAt(0) == '-')) {
            String stringModuleA = stringA.substring(1);
            String stringModuleB = stringB.substring(1);

//            BigNumber moduleA = new MyBigNumber(stringModuleA);
//            BigNumber moduleB = new MyBigNumber(stringModuleB);
//            BigNumber res = moduleB.sub(moduleA);
//            return res;

            String str = "";
            if (stringModuleA.compareTo(stringModuleB) == 0) {
                //   System.out.println("the sub of " + stringA + " and " + stringB + " is " + new MyBigNumber("0").toString());
                return new MyBigNumber("0");
            }
            int lengthA = stringModuleA.length();
            int lengthB = stringModuleB.length();
            String strA = new StringBuilder(stringModuleA).reverse().toString();
            String strB = new StringBuilder(stringModuleB).reverse().toString();
            int c = 0;
            for (int i = 0; i < lengthB; i++) {
                int sub = ((int) (strA.charAt(i) - '0') - (int) (strB.charAt(i) - '0') - c);
                if (sub < 0) {
                    sub = sub + 10;
                    c = 1;
                } else
                    c = 0;
                str += (char) (sub + '0');
            }

            for (int i = lengthB; i < lengthA; i++) {
                int sub = ((int) (strA.charAt(i) - '0') - c);
                if (sub < 0) {
                    sub = sub + 10;
                    c = 1;
                } else
                    c = 0;

                str += (char) (sub + '0');
            }

            str = str + '-';
            str = new StringBuilder(str).reverse().toString();
            //     System.out.println("the sub of " + stringA + " and " + stringB + " is " + str);
            return new MyBigNumber(str);


        }


        if ((stringA.charAt(0) != '-') && (stringB.charAt(0) == '-')) {
            String stringModuleB = stringB.substring(1);
            BigNumber newB = new MyBigNumber(stringModuleB);
            return this.add(newB);
        }

        if ((stringA.charAt(0) == '-') && (stringB.charAt(0) != '-')) {
            String negativeStringB = new StringBuilder(stringB).reverse().append('-').reverse().toString();
            //   System.out.println(negativeStringB);
            BigNumber newB = new MyBigNumber(negativeStringB);
            //   System.out.println("the sub of " + stringA + " and " + stringB + " is " + this.add(bigNumber).toString());

            return this.add(newB);
        }
        return null;
    }

    @Override
    public int compareTo(Object o) {
        // enter your code

        if (o instanceof BigNumber) {
            String stringA = number;
            BigNumber bigNumber = (BigNumber) o;
            String stringB = bigNumber.toString();


            if ((stringA.charAt(0) != '-') && (stringB.charAt(0) != '-')) {

                List<Integer> check = new ArrayList<>();
                List<Integer> check2 = new ArrayList<>();

                if (stringA.length() > stringB.length()) {
                    return 1;
                }
                if (stringA.length() < stringB.length()) {
                    return -1;
                }

                for (int i = 0; i < stringA.length(); i++) {
                    if (stringA.charAt(i) > stringB.charAt(i))
                        check.add(1);
                    else if (stringA.charAt(i) < stringB.charAt(i))
                        check.add(-1);
                    else check.add(0);
                }


                for (int x : check) {
                    if (x != 0) {
                        check2.add(x);
                    }
                }

                if (check.stream().allMatch(c -> c == 0)) {
                    return 0;
                }

                if (check2.stream().findFirst().get() == 1) {
                    return 1;
                }

                if (check2.stream().findFirst().get() == -1) {
                    return -1;
                }

            }

            if ((stringA.charAt(0) != '-') && (stringB.charAt(0) == '-')) {
                return 1;
            }

            if ((stringA.charAt(0) == '-') && (stringB.charAt(0) != '-')) {
                return -1;
            }

            if ((stringA.charAt(0) == '-') && (stringB.charAt(0) == '-')) {

                String stringModuleA = stringA.substring(1);
                String stringModuleB = stringB.substring(1);

                if (stringModuleA.length() > stringModuleB.length()) {
                    return -1;
                }
                if (stringModuleA.length() < stringModuleB.length()) {
                    return 1;
                }

                List<Integer> check = new ArrayList<>();
                List<Integer> check2 = new ArrayList<>();


                for (int i = 0; i < stringModuleA.length(); i++) {
                    if (stringModuleA.charAt(i) > stringModuleB.charAt(i))
                        check.add(1);
                    else if (stringModuleA.charAt(i) < stringModuleB.charAt(i))
                        check.add(-1);
                    else check.add(0);
                }

                for (int x : check) {
                    if (x != 0) {
                        check2.add(x);
                    }
                }

                if (check.stream().allMatch(c -> c == 0)) {
                    return 0;
                }

                if (check2.stream().findFirst().get() == 1) {
                    return -1;
                }

                if (check2.stream().findFirst().get() == -1) {
                    return 1;
                }

            }
        }

        return 0;
    }

    @Override
    public String toString() {
        return number;
    }
}

