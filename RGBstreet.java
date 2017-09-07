import java.io.*;
import java.util.ArrayDeque;

/**
 * Created by moonti on 2016. 10. 20..
 */
public class RGBstreet {

    private static final int SIZE = 1001;
    private static int[][] RGB_Table = new int[SIZE][3];
    private static int N;
    private static int[] MIN = new int[SIZE];
    private static int minIdearSum = 0;
    private static int minSum = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        getInput();
        Node n, p;
        ArrayDeque<Node> stack = new ArrayDeque<>();
        n = new Node(0, 0, minIdearSum, -1);
        stack.push(n);
        while(!stack.isEmpty()) {
            p = stack.pop();
            if (p.level == N) {
                minSum = Math.min(minSum, p.price);
                continue;
            }
            if (minSum <= p.price + p.promise) {
                continue;
            }
            for (int i = 0; i<3; i++) {
                if (p.color != i) {
                    n = new Node(p.level + 1, p.price + RGB_Table[p.level + 1][i] , p.promise - MIN[p.level+1], i);
                    stack.push(n);
                }
            }
        }
        System.out.print(minSum);
    }
    public static void getInput() throws IOException {
        N = IOHelper.getInt();
        int min=Integer.MAX_VALUE;
        for (int i = 1; i<=N; i++ ) {
            min = SIZE;
            String[] line = IOHelper.getLine().split(" ");
            for(int j = 0; j<3; j++) {
                RGB_Table[i][j] = Integer.valueOf(line[j]);
                min = Math.min(RGB_Table[i][j], min);
            }
            MIN[i] = min;
            minIdearSum += min;
        }
    }

    private static class Node {
        int price;
        int level;
        int promise;
        int color;
        public Node (int level, int price, int promise, int color) {
            this.level = level;
            this.price = price;
            this.promise = promise;
            this.color = color;
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
