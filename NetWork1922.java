import java.io.*;

/**
 * Created by moonti on 2016. 10. 21..
 */
public class NetWork1922 {

    static int N;
    static int M;
    static final int  SIZE = 1005;
    static int[][] W = new int[SIZE][SIZE];
    static boolean[] check = new boolean[SIZE];
    static int[] candidate = new int[SIZE];
    static final int MAX = Integer.MAX_VALUE/2;
    static int step = 0;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        getInput();
        check[1] = true;
        step++;
        prim(1);
        System.out.println(count);
    }

    private static void prim(int v) {
        if (step == N) return;
//        System.out.println(v);
        int min = MAX;
        int cadidateIdx = 0 ;
        int i;
        for (i=1; i<=N; i++) {
            if(check[i]) continue;
            if(W[v][i] != 0) {
                if (candidate[i] > W[v][i]) {
                    candidate[i] = W[v][i];
                }
            }
            if (min > candidate[i]) {
                min = candidate[i];
                cadidateIdx = i;
            }
        }
        count += min;
        check[cadidateIdx] = true;
        step++;
        prim(cadidateIdx);

    }

    public static void getInput() throws IOException {
        N = IOHelper.getInt();
        M = IOHelper.getInt();
        String[] temp;
        int x, y, value;
        for (int i = 1; i<=M; i++) {
            temp = IOHelper.getLine().split(" ");
            for (int j = 0; j<temp.length; j++) {
                y = Integer.valueOf(temp[0]);
                x = Integer.valueOf(temp[1]);
                value = Integer.valueOf(temp[2]);
                W[y][x] = value;
                W[x][y] = value;
            }
        }
        for (int i = 1; i<= N; i++) {
            candidate[i] = MAX;
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
