import java.io.*;
/**
 * 어떤 자연수 p와 q가 있을 때, 만일 p를 q로 나누었을 때 나머지가 0이면 q는 p의 약수이다. 

6을 예로 들면

6 ÷ 1 = 6 … 0
6 ÷ 2 = 3 … 0
6 ÷ 3 = 2 … 0
6 ÷ 4 = 1 … 2
6 ÷ 5 = 1 … 1
6 ÷ 6 = 1 … 0
그래서 6의 약수는 1, 2, 3, 6, 총 네 개이다.

두 개의 자연수 N과 K가 주어졌을 때, N의 약수들 중 K번째로 작은 수를 출력하는 프로그램을 작성하시오.
 */
public class PrimNumber2501 {

    public static void main(String[] args) {
        try {
            String[] input = IOHelper.getLine().split(" ");
            int N = Integer.valueOf(input[0]);
            int K = Integer.valueOf(input[1]);
            IOHelper.print(solve(N, K));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int solve(int n, int k) {
        int count = 0;
        for (int i = 1; i < 10000000; i++) {
            if (n % i == 0 ) {
                count++;
                if (count == k) {
                    return i;
                }
            }
        }
        return 0;
    }

    public static class IOHelper {
        static File inputFile;
        static Reader stream; 
        static BufferedReader bf;
        static OutputStream out;

        // static {
        //     try {
        //         inputFile = new File("input.txt");
        //         stream = new InputStreamReader(new FileInputStream(inputFile));
        //         bf = new BufferedReader(stream);
        //         out = new BufferedOutputStream(System.out);
        //     } catch (IOException e) {
        //         e.printStackTrace();
        //     }
        // }
        static {
            stream = new InputStreamReader(System.in);
            bf = new BufferedReader(stream);
            out = new BufferedOutputStream(System.out);
        }
        
        public static String getLine() throws IOException {
            return bf.readLine();
        }

        public static int getInt() throws IOException{
            String str = getLine();
            return Integer.valueOf(str);
        }
        public static void write(int n) throws IOException {
            write(String.valueOf(n));
        }
        public static void write(long l) throws IOException{
            out.write((l + "\n").getBytes());
        }
        public static void write(String str) throws IOException {
            out.write((str).getBytes());
        }

        public static void write(int n, String postFix) throws IOException {
            write(String.valueOf(n) + postFix);
        }
        public static void write(long l, String postFix) throws IOException{
            out.write((l + postFix).getBytes());
        }
        public static void write(String str, String postFix) throws IOException {
            out.write((str + postFix).getBytes());
        }

        public static void print() throws IOException{
            out.flush();
        }

        public static void print(String str) throws IOException {
            write(str);
            print();
        }
        public static void print(String str, String postFix) throws IOException {
            write(str + postFix);
            print();
        }
        public static void print(int n, String postFix) throws IOException {
            write(n + postFix);
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