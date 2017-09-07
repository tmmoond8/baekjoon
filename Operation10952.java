import java.io.*;

/**
     * 두 수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
     * 
        1 1
        2 3
        3 4
        9 8
        5 2
        0 0
     */

public class Operation10952 {

    static int[] inputArray = new int[1000000];
    public static void main(String[] args) {
        getInput();

    }

    private static void getInput() {
        try {
            int k = 0;
            String line;
            String buf[] = new String[2];
            for (int i = 0; i < 10000 ; i++) {
                line = IOHelper.getLine();
                buf = line.split(" ");
                inputArray[k++] = Integer.valueOf(buf[0]);
                inputArray[k++] = Integer.valueOf(buf[1]);
                if (inputArray[k-2] == 0 && inputArray[k-1] == 0) break;
                IOHelper.print(inputArray[k-2] + inputArray[k-1], "\n");
                // IOHelper.print(inputArray[k-2] + " " + inputArray[k-1] + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    public static class IOHelper {
        static File inputFile;
        static Reader stream; 
        static BufferedReader bf;
        static OutputStream out;

        static {
            try {
                inputFile = new File("input.txt");
                stream = new InputStreamReader(new FileInputStream(inputFile));
                bf = new BufferedReader(stream);
                out = new BufferedOutputStream(System.out);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // static {
        //     stream = new InputStreamReader(System.in);
        //     bf = new BufferedReader(stream);
        //     out = new BufferedOutputStream(System.out);
        // }
        
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