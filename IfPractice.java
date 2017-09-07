import java.util.Scanner;

/**
 * Created by moonti on 2016. 10. 17..
 */
public class IfPractice {


    public static void main(String[] args) {

    }

    public static void lowNumber() {
        final int SIZE = 10005;
        Scanner input = new Scanner(System.in);
        int[] A = new int[SIZE];
        int n = input.nextInt();
        int pivot = input.nextInt();
        for (int i = 0;  i< n; i++) {
            A[i] = input.nextInt();
            if (A[i] < pivot) {
                System.out.print(A[i] + " ");
            }
        }
    }

    public static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }
    public static int min(int a, int b) {
        if (a > b) {
            return b;
        } else {
            return a;
        }
    }
    public static int middleNumber(int a, int b, int c) {
        if (a> b) {
          if (b > c) {
              return b;
          } else {
              if (a > c) {
                  return c;
              } else {
                  return a;
              }
          }
        } else {
            if (a > c) {
                return a;
            } else {
                if (b > c) {
                    return c;
                } else {
                    return b;
                }
            }
        }
    }

    public static void printCredit(int point) {
        char credit = 'A';
        if (point >= 90 && point <= 100) {

        } else if(point >= 80 && point <= 89) {
            credit = 'B';
        } else if(point >= 70 && point <= 79) {
            credit = 'C';
        } else if (point >= 60 && point <= 69) {
            credit = 'D';
        } else {
            credit = 'F';
        }
        System.out.print(credit);
    }
}
