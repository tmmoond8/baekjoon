import java.util.Scanner;

/**
 * Created by moonti on 2016. 10. 17..
 */
public class PrintN {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.print(sum(n));
    }

    public static void whatDate(int month, int day) {
        int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int dayCount = 0;
        for(int i=1; i<month; i++) {
            dayCount += months[i];
        }
        dayCount += day;
//        System.out.println(dayCount);

        printDate(dayCount);
    }

    public static int sum(int n) {
        return n*(n+1)/2;
    }
    public static void printDate(int a) {
        switch(a%7) {
            case 0 :
                System.out.print("SUN");
                break;
            case 1 :
                System.out.print("MON");
                break;
            case 2 :
                System.out.print("TUE");
                break;
            case 3 :
                System.out.print("WED");
                break;
            case 4 :
                System.out.print("THU");
                break;
            case 5 :
                System.out.print("FRI");
                break;
            case 6 :
                System.out.print("SAT");
                break;
        }
    }

    public static void printStar4(int a) {
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j<=a; j++) {
                if (j >= i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }


    public static void printStar3(int a) {
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j<=a; j++) {
                if (j <= a-i+1) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    public static void printStar2(int a) {
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j<=a; j++) {
                if (j <= a-i) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    public static void printStar(int a) {
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void gugudan(int a) {
        for (int i=1 ; i<=9 ; i++) {
            System.out.format("%d * %d = %d\n", a, i, a*i);
        }
    }
    public static void printN(int n) {
        for(int i=1; i<=n; i++) {
            System.out.println(i);
        }
    }

    public static void printNReverse(int n) {
        for(int i=1; i<=n; i++) {
            System.out.println(n-i + 1);
        }
    }
}
