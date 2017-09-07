import java.io.*;
import java.util.ArrayDeque;

/**
 * Created by moonti on 2016. 10. 20..
 */
public class NumberTriagle {

    static int N;
    static final int SIZE = 502;

    static boolean[][] check = new boolean[SIZE][SIZE];
    static int[][] table = new int[SIZE][SIZE];
    static int[] maxTable = new int[SIZE];
    static int sumOfMax = 0;
    static int max = 0;
    static int[][] D = new int[SIZE][SIZE];

    public static void main(String[] args) throws IOException {
        getInput();
        int max = 0;
        for(int i = 1; i<=N ; i++)  {
            max = Math.max(max, minNT(N, i));
        }
        System.out.print(max);

    }

    public static int minNT(int y, int x) {
        if (y < 1 || x < 1 || x > y) return 0;
        if (check[y][x]) {
            return D[y][x];
        }
        D[y][x] = Math.max(minNT(y-1, x), minNT(y-1, x-1)) + table[y][x];
        check[y][x] = true;
        return D[y][x];
    }

    public static void process1() {
        Node p, n;
        int count = 0;
        ArrayDeque<Node> stack = new ArrayDeque<>();
        p = new Node(1, table[1][1], sumOfMax - maxTable[1], 1);
        stack.push(p);
        while(!stack.isEmpty()) {
            p = stack.pop();
            if (p.level == N) {
                max = Math.max(p.price, max);
                count++;
                continue;
            }
            if (max >= p.price + p.promise) {
                continue;
            }

            n = new Node(p.level+1, p.price + table[p.level+1][p.x+1],
                    p.promise - maxTable[p.level+1], p.x+1);
            stack.push(n);
            n = new Node(p.level+1, p.price + table[p.level+1][p.x],
                    p.promise - maxTable[p.level+1], p.x);
            stack.push(n);
        }
        System.out.println(max);
        System.out.println(count);
    }

    public static void getInput() throws IOException {
        N = IOHelper.getInt();
        String[] inputTable;
        for (int i=1; i<=N; i++) {
            int lowMax = -1;
            inputTable = IOHelper.getLine().split(" ");
            for (int j = 0; j<inputTable.length; j++) {
                table[i][j+1] = Integer.valueOf(inputTable[j]);
                lowMax = Math.max(lowMax, table[i][j+1]);
            }
            maxTable[i] = lowMax;
            sumOfMax += lowMax;
        }
    }



    private static class Node {
        int level;
        int x;
        int price;
        int promise;
        public Node(int level, int price, int promise, int x) {
            this.level = level;
            this.price = price;
            this.promise = promise;
            this.x = x;
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
