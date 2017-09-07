import java.io.*;

/**
 * Created by moonti on 2016. 10. 20..
 */
public class path11404 {


    private static final int SIZE = 205;
    private static int N;
    private static int M;
    private static int[][] W = new int[SIZE][SIZE];
    private static int[][] D = new int[SIZE][SIZE];

    public static void main(String[] args) throws IOException {
        getInput();

        for(int k = 1; k<= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    D[i][j] = Math.min(D[i][j], D[i][k] + D[k][j]);
                }
            }
        }


        printD();

    }
    private static void getInput() throws IOException {
        N = IOHelper.getInt();
        M = IOHelper.getInt();
        int MAX = 1000000;
//        int MAX = 5;
        String[] temp;
        int x, y, value;
        for (int i = 1; i<= M; i++) {
            temp = IOHelper.getLine().split(" ");
            y = Integer.valueOf(temp[0]);
            x = Integer.valueOf(temp[1]);
            value = Integer.valueOf(temp[2]);
            if(W[y][x] != 0) {
                W[y][x] = Math.min(W[y][x], value);
                D[y][x] = W[y][x];
            } else {
                W[y][x] = value;
                D[y][x] = value;
            }
        }
        for (int j = 1; j<=N; j++) {
            for (int i = 1; i<= N; i++) {
                if (D[j][i] == 0) {
                    D[j][i] = MAX;
                }
                if (i == j) {
                    D[j][i] = 0;
                }
            }

        }
    }

    private static void printD() {
        for(int i = 1; i<=N ;i++) {
            for (int j = 1; j <=N; j++) {
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
