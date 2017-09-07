import java.io.*;
import java.util.Scanner;

/**
 * Created by moonti on 2016. 10. 21..
 */
public class PracticeTSP2 {

    static final int SIZE = 20;
    static final int FLAG_SIZE = 1<<20;
    static int N;
    static int[][] W = new int[SIZE][SIZE];
    static int[][] D = new int[SIZE][FLAG_SIZE];

    public static void main(String[] args) {
        getInput();
    }
    private static void getInput() {

        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        for (int i=1; i<=N; i++) {
            for (int j = 1; j <= N; j++) {
                W[i][j] = input.nextInt();
            }
        }
        int flag = (1<<N) -2;
        int min = tsp(1, flag);
        System.out.print(min);
    }

    private static int tsp(int v, int flag) {
        if (flag == 0) {
            return W[v][1];
        }
        if (D[v][flag] != 0) {
            return D[v][flag];
        }
        int min = Integer.MAX_VALUE/2;
        for (int i=2; i<=N; i++) {
            if ( (flag & (1 <<(i-1))) > 0) {
                min  = Math.min(min, W[v][i] + tsp(i, flag - (1 <<(i-1)) ));
            }
        }
        D[v][flag] = min;

        return min;
    }

}
