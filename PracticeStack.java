import java.math.BigDecimal;
import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by moonti on 2016. 10. 18..
 */
public class PracticeStack {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String sample1 = input.nextLine();
        String postFix = inFix2PostFix(sample1.replaceAll(" ", ""));
        if (postFix == null) {
            System.out.println("ROCK");
            return ;
        }
        BigDecimal result = calulator(postFix);
        if (result.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("ROCK");
        } else {
            System.out.println(result);
        }
    }

    public static BigDecimal calulator(String str) {
        Stack<BigDecimal> stack = new Stack<>();
        char c;
        int tempInt = 0;
        BigDecimal a, b, temp, num = new BigDecimal(0);
        String stringTemp;
        boolean startFlag = false;
        for (int i = 0; i<str.length(); i++) {
            c = str.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                startFlag = true;
                if(num.compareTo(BigDecimal.ZERO) != 0) {
                    stack.push(num);
                }
                num = new BigDecimal(0);
                if (stack.empty()) {
                    return new BigDecimal(-1);
                }
                a = stack.pop();
                if (stack.empty()) {
                    return new BigDecimal(-1);
                }
                b = stack.pop();
                temp = cal(c, a, b);
                if (temp.compareTo(BigDecimal.ZERO) < 0) {
                    return new BigDecimal(-1);
                } else {
                    stack.push(temp);
                }
            } else if (c == ' ') {
                startFlag = true;
                if(num.compareTo(BigDecimal.ZERO) != 0) {
                    stack.push(num);
                }
                num = new BigDecimal(0);
            } else {
                num =num.multiply(BigDecimal.TEN);
                tempInt = Integer.valueOf(c+"");
                num = num.add(new BigDecimal(tempInt));
            }
        }
        if (stack.empty()) {
            return new BigDecimal(-1);
        } else {
            return stack.pop();
        }
    }
    public static BigDecimal cal(char c, BigDecimal a, BigDecimal b) {
        if (c == '+') {
            return a.add(b);
        } else if (c == '-') {
            return b.subtract(a);
        } else if (c == '*') {
            return b.multiply(a);
        } else if (c == '/') {
           return b.divide(a);
        } else {
            return new BigDecimal(-1);
        }
    }

    public static String inFix2PostFix(String str) {
        Stack<Character> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        char c;
        char temp;
        boolean sig = false;
        boolean numStart = true;
        for (int i=0; i<str.length(); i++) {
            c = str.charAt(i);
            if (c == '(') {
                numStart = true;
                if (sig) {
                    return null;
                }
                stack.push(c);
            } else if (c== '*' || c == '/') {
                numStart = true;
                if (!stack.empty()) {
                    temp = stack.peek();
                    if ( temp != '(' && priorValue(temp) >= priorValue(c)) {
                        sb.append(stack.pop());
                    }
                }
                stack.push(c);
            } else if (c== '-' || c == '+') {
                numStart = true;
                if (!stack.empty()) {
                    temp = stack.peek();
                    if ( temp != '(' && priorValue(temp) >= priorValue(c)) {
                        sb.append(stack.pop());
                    }
                }
                stack.push(c);
            } else if (c == ')') {
                numStart = true;
                sig = true;
                while(!stack.empty()) {
                    temp = stack.pop();
                    if (temp == '(') {
                        sig = false;
                        break;
                    } else {
                        sb.append(temp);
                    }
                }
            }
            else {
                if(numStart) {
                    sb.append(" ");
                    numStart = false;
                }
                sb.append(c);
            }
        }
        while(!stack.empty()) {
            sb.append(stack.pop());
        }
        if (sig) {
            return null;
        }
        return sb.toString();
    }

    public static int priorValue(char c) {
        if (c == '(') {
            return 10;
        } else if (c == '*' || c == '/') {
            return 5;
        } else if (c == '+' || c == '-') {
            return 1;
        }
        return -1;
    }

//    public static void commander(MyStack stack, String cmd) {
//        String[] cmdArray = cmd.split(" ");
//
//        if (cmdArray[0].compareToIgnoreCase("push") == 0) {
//            stack.push(Integer.valueOf(cmdArray[1]));
//        } else if (cmdArray[0].compareToIgnoreCase("top") == 0) {
//            System.out.println(stack.top());
//        } else if (cmdArray[0].compareToIgnoreCase("size") == 0) {
//            System.out.println(stack.size());
//        } else if (cmdArray[0].compareToIgnoreCase("empty") == 0) {
//            System.out.println(stack.empty());
//        } else if (cmdArray[0].compareToIgnoreCase("pop") == 0) {
//            System.out.println(stack.pop());
//        }
//    }


//    public static class MyStack {
//        int top = -1;
//        int[] stack = new int[10005];
//
//        public void push(int a) {
//            top++;
//            stack[top] = a;
//        }
//        public int size() {
//            return top + 1;
//        }
//        public int empty() {
//            if (top == -1) {
//                return 1;
//            } else {
//                return 0;
//            }
//        }
//
//        public int top() {
//            if (top == -1) {
//                return -1;
//            } else {
//                int result = stack[top];
//                return result;
//            }
//
//        }
//        public int pop() {
//            if (top == -1) {
//                return -1;
//            } else {
//                int result = stack[top];
//                stack[top] = 0;
//                top--;
//                return result;
//            }
//
//        }
//    }


    public static void baseTest() {
        String sample1 = "a - b";
        String sample2 = "a + b / c";
        String sample3 = "a * b + c";
        String sample4 = "(a + b) - c";
        String sample5 = "a + c - h/b*r";
        String postFix1 = inFix2PostFix(sample1.replaceAll(" ", ""));
        String postFix2 = inFix2PostFix(sample2.replaceAll(" ", ""));
        String postFix3 = inFix2PostFix(sample3.replaceAll(" ", ""));
        String postFix4 = inFix2PostFix(sample4.replaceAll(" ", ""));
        String postFix5 = inFix2PostFix(sample5.replaceAll(" ", ""));
        if (!" a b-".equals(postFix1)) {
            System.out.println(" a b-");
        }
        if (!" a b c/+".equals(postFix2)) {
            System.out.println(" a b c/+");
        }
        if (!" a b* c+".equals(postFix3)) {
            System.out.println(" a b* c+");
        }
        if (!" a b+ c-".equals(postFix4)) {
            System.out.println(" a b+ c-");
        }
        if (!" a c+ h b/ r*-".equals(postFix5)) {
            System.out.println(" a c+ h b/ r*-");
        }

    }
}
