import java.util.Scanner;

/**
 * Created by moonti on 2016. 10. 17..
 */
public class PracticeFunction {

    public static void main(String[] args) {
        int count = 0;
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int i = 1; i<=n; i++) {
            if (isHanNumber(i)) {
                count++;
            }
        }
        System.out.print(count);
    }
    public static boolean isHanNumber(int a) {
        int num1, num2, tolerance = -22;
        while(a > 9) {
            num1 = a%10;
            a /= 10;
            num2 = a%10;
            if (tolerance != -22) {
                if (tolerance != num1 - num2) {
                    return false;
                }
            } else {
                tolerance = num1 - num2;
            }
        }
        return true;
    }

    public static void selfNumber() {
        final int SIZE = 30005;
        boolean[] A = new boolean[SIZE];
        int i = 1;
        while(true) {
            A[f(i)] = true;
            i++;
            if (i>10000) {
                break;
            }
        }
        for (i=1; i<=10000; i++) {
            if (A[i] == false) {
                System.out.println(i);
            }
        }
    }
    public static int f(int number) {
        int result = number;
        while(number > 0) {
            result += (number%10 );
            number /= 10;
        }
        return result;
    }

}
