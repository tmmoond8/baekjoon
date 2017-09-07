
import java.io.*;

/**
 * Created by moonti on 2016. 10. 20..
 */
public class Path2606 {

    static private final int SIZE = 204;
    static private int N, M;
    static int[][] W = new int[SIZE][SIZE];
    static int[][] D = new int[SIZE][SIZE];

    public static void main(String[] args) throws IOException {
        getInput();
        int count = 0;
        for (int k = 1; k<= N; k++) {
            for(int i = 1; i<= N; i++) {
                for (int j = 1; j<=N; j++) {
                    if (D[i][j] == 1) {
                        continue;
                    }
                    if (D[i][k] == 1 && D[k][j] == 1) {
                        D[i][j] = 1;
                    }
                }
            }
        }
        for (int i = 2; i<= N; i++) {
            if (D[1][i] == 1) {
                count++;
            }
        }
        System.out.print(count);
    }
    private static void getInput() throws IOException {
        N = IOHelper.getInt();
        M = IOHelper.getInt();
        String[] temp;
        int x, y;
        for (int i=1; i<=M; i++) {
            temp = IOHelper.getLine().split(" ");
            y = Integer.valueOf(temp[0]);
            x = Integer.valueOf(temp[1]);
            W[y][x] = 1;
            D[y][x] = 1;
            W[x][y] = 1;
            D[x][y] = 1;
        }
    }
    private static void printD() {
        for(int i= 1; i<=N; i++) {
            for (int j = 1; j<=N; j++) {
                System.out.print(D[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static class IOHelper {
        static InputStreamReader stream = new InputStreamReader(System.in);
        static BufferedReader bf = new BufferedReader(stream);
        static OutputStream out = new BufferedOutputStream(System.out);

        public static String getLine() throws IOException {
            return bf.readLine();
        }
        public static int getInt() throws IOException {
            String str = getLine();
            return Integer.valueOf(str);
        }
        public static void write(int n) throws IOException {
            write(String.valueOf(n));
        }
        public static void write(long l) throws IOException {
            out.write((l + "\n").getBytes());
        }
        public static void write(String str) throws IOException {
            out.write((str + "\n").getBytes());
        }
        public static void print() throws IOException {
            out.flush();
        }
        public static void print(String str) throws IOException {
            write(str);
            print();
        }
        public static void print(int n) throws IOException {
            write(n);
            print();
        }
        public static void print(long n) throws IOException {
            write(n);
            print();
        }
    }
}
