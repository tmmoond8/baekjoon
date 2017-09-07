import java.io.*;
import java.util.*;

/**
 * Created by moonti on 2016. 10. 21..
 */
public class PracticeTSP {

    static final int MAX = Integer.MAX_VALUE/2;
    static final int SIZE = 18;
    static int[][] W = new int[SIZE][SIZE];
//            {
//            {0,0,0,0,0},
//            {0,     0, 2, 9, MAX},
//            {0,     1, 0, 6, 4},
//            {0,     MAX, 7, 0, 8},
//            {0,     6, 3, MAX, 0}
//    };
    static int N;

    static HashMap<Integer, HashMap<String, Integer>> D = new HashMap<>();

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        for (int i=1; i<=N; i++) {
            for (int j = 1; j <= N; j++) {
                W[i][j] = input.nextInt();
            }
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        D.put(1, new HashMap<>());
        for (int i = 2; i<=N; i++) {
            D.put(i, new HashMap<>());
            D.get(i).put("0", W[i][1]);
            map.put(i, i);
        }
        int min = tsp(1, map);
        System.out.print(min);
    }

    public static int tsp(int v, TreeMap<Integer, Integer> map) {
        if(map.size() == 0) {
            return D.get(v).get("0");
        }
        if (D.get(v).containsKey(toString(map))) {
            return D.get(v).get(toString(map)) ;
        }
        int min = MAX;
        Integer temp;
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            TreeMap<Integer, Integer> tempMap = (TreeMap<Integer, Integer>) map.clone();
            temp = map.get(iterator.next());
            tempMap.remove(temp);
            min = Math.min(min, W[v][temp] + tsp(temp, tempMap));
        }
        D.get(v).put(map.toString(), min);
        return D.get(v).get(map.toString());
    }
    public static String toString(TreeMap<Integer, Integer> map) {
        StringBuffer sb = new StringBuffer();
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            sb.append("v"+iterator.next());
        }
        return sb.toString();
    }

    public static class IOHelper {
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
