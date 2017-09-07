import java.io.*;

/**
 * Created by moonti on 2016. 10. 20..
 */
public class Path11403 {

    static private final int SIZE = 105;
    private static int N;
    private static int[][] W = new int[SIZE][SIZE];
    private static int[][] D = new int[SIZE][SIZE];

    public static void main(String[] args) throws IOException {
        getInput();
        process();
        printD();
    }
    public static void getInput() throws IOException {
        N = IOHelper.getInt();
        String[] temp;
        for(int i = 1; i<= N; i++) {
            temp = IOHelper.getLine().split(" ");
            for (int j = 0; j<temp.length; j++) {
                W[i][j+1] = Integer.valueOf(temp[j]);
                if (W[i][j+1] == 1) {
                    D[i][j+1] = 1;
                }
            }
        }
    }

    private static void printD() {
        for (int i=1 ; i<=N; i++) {
            for (int j=1; j<= N; j++) {
                System.out.print(D[i][j]+" ");
            }
            System.out.println();
        }
    }
    private static void process() {

        for (int k = 1; k<=N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j<= N; j++) {
                    if (D[i][j] == 1) {
                        continue;
                    }
                    if (D[i][k] == 1 && D[k][j] == 1) {
                        D[i][j] = 1;
                    }
                }
            }
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
