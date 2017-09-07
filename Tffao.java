import java.util.Scanner;

/**
 * Created by moonti on 2016. 10. 17..
 */
public class Tffao {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a, b, c;
        int temp1;
        a = input.nextInt();
        b = input.nextInt();
        c = input.nextInt();
        System.out.println( reminder(add(a, b), c));
        temp1 = add(reminder(a,c), reminder(b,c));
        System.out.println(reminder(temp1, c));
        System.out.println(reminder(multiply(a,b), c));
        temp1 = multiply(reminder(a,c), reminder(b,c));
        System.out.println(reminder(temp1, c));
    }
    public static int substract(int a, int b) {
        return a - b;
    }
    public static int add(int a, int b) {
        return a + b;
    }
    public static int multiply(int a, int b) {
        return a*b;
    }
    public static double dividerDouble(double a, double b) {
        return a/b;
    }
    public static int divider(int a, int b) {
        return a/b;
    }
    public static int reminder(int a, int b) {
        return a%b;
    }
}
