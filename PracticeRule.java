import java.util.Scanner;

/**
 * Created by moonti on 2016. 10. 18..
 */
public class PracticeRule {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        findFraction(n);
    }

    public static int beesHouseDistance(long n) {
        if (n == 1) return 1;
        n -= 1;
        for (int i = 1; i < 100000; i++) {
            n -= 6*i;
            if (n <= 0) {
                return i+1;
            }
        }
        return -1;
    }
    public static void findFraction(int n) {
        int start = (int)Math.sqrt(n);
        int i = start;
        int sum;
        while(true) {
            sum = i*(i+1)/2;
            if (sum >= n) {
                sum = (i-1)*i/2;
                break;
            }
            i++;
        }
        if (i%2 ==0) {
            //짝 수 왼쪽 아래로
            int k = n - sum;
            System.out.format("%d/%d", k, i-k+1);
        } else {
            //홀수 오른쪽 위로.
            int k = n - sum;
            System.out.format("%d/%d", i-k+1, k);
        }
    }

}
