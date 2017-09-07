import java.io.*;

/**
 * Created by moonti on 2016. 10. 20..
 */
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