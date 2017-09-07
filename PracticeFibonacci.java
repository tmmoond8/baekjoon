import java.io.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by moonti on 2016. 10. 20..
 */
public class PracticeFibonacci {

    public static void main(String[] args) throws IOException {
        int[] array = new int[50];
        int m = Integer.valueOf(IOHelper.getLine());
        for (int i=0; i<m; i++) {
            array[i] = Integer.valueOf(IOHelper.getLine());
        }
        for (int i=0; i<m; i++) {
            Fibo fibo = new Fibo();
            fibo.run(array[i]);
        }
//        BigFivo fivo = new BigFivo();
//        fivo.run(n);
    }

    public static class BigFivo {
        final int mod = 1000000;
        int period = mod/10*15;
        long[] array = new long[period];

        public void run(long n) throws IOException {
            array[0] = 0l;
            array[1] = 1l;
            if (n%period == 0) {
                IOHelper.print(0);
                return;
            }
            int i = 2;
            long last = n%period;
            while(i <= last) {
                array[i] = array[i-1] + array[i-2];
                array[i] = array[i]%mod;
//                IOHelper.write(array[i]);
                i++;
            }
//            IOHelper.print();
            IOHelper.print(array[i-1]);
        }

    }

    public static class Fibo {

        static HashMap<Integer, Long> cache = new HashMap<>();
        static int zeroCount = 0;
        static int oneCount = 0;

        public void run(int n) throws IOException {
//            cache.put(0, 0l);
//            cache.put(1, 1l);
//            cache.put(2, 1l);
            fivo2(n);
            System.out.format("%d %d\n", zeroCount, oneCount);
            zeroCount = 0;
            oneCount = 0;
        }
        public long fivo(int n) {
            if (cache.containsKey(n)) {
                return cache.get(n);
            } else {
                cache.put(n , fivo(n-1) + fivo(n-2));
                return cache.get(n);
            }
        }
        public int fivo2(int n) {
            if (n == 0) {
                zeroCount++;
                return 0;
            } else if ( n == 1) {
                oneCount++;
                return 1;
            } else {
                return fivo2(n-1) + fivo2(n-2);
            }
        }
    }

    private static class IOHelper {
        //        static IOHelper  sIOHelper = new IOHelper();
        static InputStreamReader stream = new InputStreamReader(System.in);
        static BufferedReader bf = new BufferedReader(stream);
        static OutputStream out = new BufferedOutputStream(System.out);

        public static String getLine() throws IOException {
            return bf.readLine();
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
