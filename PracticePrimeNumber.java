import java.util.Scanner;

/**
 * Created by moonti on 2016. 10. 18..
 */
public class PracticePrimeNumber {
    private static final int SIZE = 1000005;
    static int[] primeNumber = new int[SIZE];


    public static void main(String[] args) {
        setPrimeNumber();
//        prime2();
        prime3();
    }

    public static void prime3() {
        Scanner input = new Scanner(System.in);
        int M = input.nextInt();
        int N = input.nextInt();
        for (int i = M; i <= N; i++) {
            if (primeNumber[i] < 3) {
                System.out.println(i);
            }
        }
    }

    public static void prime2() {
        Scanner input = new Scanner(System.in);
        int M = input.nextInt();
        int N = input.nextInt();
        int sum = -1;
        int minPrime = -1;
        for (int i = M; i<=N; i++) {
            if (primeNumber[i] < 3) {
                if (minPrime == -1) {
                    sum = 0;
                    minPrime = i;
                }
                sum += i;
            }
        }
        if (sum == -1) {
            System.out.println(sum);
        } else {

            System.out.println(sum);
            System.out.println(minPrime);
        }
    }

    public static void countPrimeNumber() {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int num;
        int count = 0;
        for (int i=0; i<N; i++) {
            num = input.nextInt();
            if (primeNumber[num] < 3) {
                count++;
            }
        }
        System.out.print(count);
    }

    public static void setPrimeNumber() {
        for(int i=1; i<SIZE; i++) {
            for (int j=1; j*i<SIZE; j++) {
                primeNumber[i*j] ++;
            }
        }
        primeNumber[0] = 100;
        primeNumber[1] = 100;

//        for(int i=2; i<SIZE; i++) 2
//            if (primeNumber[i] < 3) {
//                System.out.print(i + " ");
//            }
//        }
    }
}
