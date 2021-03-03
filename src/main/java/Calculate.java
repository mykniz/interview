import javax.script.ScriptException;

public class Calculate {
    public static void main(String[] args) throws ScriptException {
        System.out.println(calculate("2+2*(3+4)"));

    }

    static int calculate(String mathString) {

        class Pre {
            int pre(char c) {
                if (c == '*' || c == '/') {
                    return 3;
                } else if (c == '+' || c == '-') {
                    return 2;
                }
                return 0;
            }
        }


        float num1 = 0;
        float num2 = 0;
        float result = 0;
        boolean flag = true;

        while (flag) {
            int temppri = 0;
            int index = 0;
            for (int i = 0; i < mathString.length(); i++) {
                int pre = new Pre().pre(mathString.charAt(i));
                if ((mathString.charAt(i) >= '0' && mathString.charAt(i) <= '9') || (mathString.charAt(i) == '-' && i == 0)) {
                    continue;
                }
                if (pre > temppri) {
                    index = i;
                    temppri = pre;
                }
            }
            String temp = "", temp1 = "", temp2 = "";
            for (int k = index - 1; k >= 0 && ((mathString.charAt(k) >= '0' && mathString.charAt(k) <= '9') || (mathString.charAt(k) == '-' && k == 0)); k--) {
                temp += mathString.charAt(k);
            }
            for (int k = temp.length(); k > -0; k--) {
                temp1 += mathString.charAt(k);
            }
            for (int k = index + 1; k <= mathString.length() && ((mathString.charAt(k) >= '0' && mathString.charAt(k) <= '9') || (mathString.charAt(k) == '-' && k == 0)); k++) {
                temp2 += mathString.charAt(k);
            }
            try {
                num1 = Float.parseFloat(temp1);
                num2 = Float.parseFloat(temp2);
            } catch (Exception e) {

            }
            switch (mathString.charAt(index)) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0)
                        break;
                    result = num1 / num2;
                    break;
            }
        }

        return 0;
    }
}
