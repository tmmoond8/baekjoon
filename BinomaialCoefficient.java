import java.io.*;
import java.math.BigDecimal;

/**
 * Created by moonti on 2016. 10. 20..
 */
public class BinomaialCoefficient {

    public static void main(String[] args) throws IOException {
        String[] cmds = IOHelper.getLine().split(" ");
        Factorial factorial = new Factorial();


//        factorial.set(Integer.valueOf(cmds[0]));
//        System.out.println(factorial.binomaialCoefficient(Integer.valueOf(cmds[0]),Integer.valueOf(cmds[1])));
//        factorial.binomailCoefficientSet(Integer.valueOf(cmds[0]));
//        System.out.println(factorial.binomaialCoefficient2(Integer.valueOf(cmds[0]), Integer.valueOf(cmds[1])));
    }

    public static class Factorial {
        public static final int SIZE = 400001;
        BigDecimal[] factorial = new BigDecimal[10007];
        long[][] binomaialCoefficient = new long[SIZE][SIZE];
        private static final int MOD = 100000007;
        public void set(int num) {
            factorial[1] = new BigDecimal(1);
            factorial[0] = new BigDecimal(1);
            for (int i=2; i<=num; i++) {
                factorial[i] = factorial[i-1].multiply(new BigDecimal(i));
            }
        }
//        public long f(int num) {
//            return factorial[num];
//        }
        public void binomailCoefficientSet(int n) {
            for (int i = 1; i<n; i++) {
                binomaialCoefficient[i][0] = 1;
                binomaialCoefficient[i][1] = i;
                binomaialCoefficient[i][i] = 1;
            }
        }
        public long binomaialCoefficient2(int n, int k) {
            if(binomaialCoefficient[n][k] == 0) {
                // 값이 없음
                binomaialCoefficient[n][k] = (binomaialCoefficient[n-1][k]+binomaialCoefficient[n-1][k-1])%MOD;
            }
            return binomaialCoefficient[n][k];
        }

        public String binomaialCoefficient(int n, int k) {
            BigDecimal result;

            result = (factorial[n].divide(factorial[k])).divide(factorial[n-k]);
            result = result.remainder(new BigDecimal(MOD));
            return result.toString();
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
