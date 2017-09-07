import java.util.Scanner;

/**
 * Created by moonti on 2016. 10. 17..
 */
public class Array1 {

    public static void main(String[] args) {
        quizeOX();
    }

    public static void quizeOX() {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        String[] str = new String[1000];
        for (int i = 0; i<n; i++) {
            str[i] = input.nextLine();
            quizeOX(str[i]);
        }
    }

    public static void quizeOX(String quize) {
        int count = 0;
        int point = 0;
        for (int i=0; i<quize.length(); i++) {
            if (quize.charAt(i) == 'O') {
//                System.out.print(1);
                ++point;
                count += (point);
            } else {
                point = 0;
//                System.out.print(0);
            }
        }
        System.out.println(count);

    }

    public static void countNumber() {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        countNumber(a*b*c);
    }

    public static void countNumber(long number) {
        int[] A = new int[10];
        int k;
        while(number > 0) {
            k = (int)number%10;
            number /= 10;
            A[k]++;
        }
        for (int i = 0; i<10; i++) {
            System.out.println(A[i]);
        }

    }

    public static void countWords() {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        int count = 0;
        boolean pre = false;
        for (int i = 0; i<str.length(); i++) {
            if (str.charAt(i) == ' ') {
                if (!pre && i != 0) {
                    count++;
                }
                pre = true;
            } else {
                pre = false;
            }
        }

        if (count == 0 && str.length() == 0) {
            System.out.print(count);
        } else {
            if (pre) {
                count--;
            }
            System.out.print(count+1);
        }
    }
}
