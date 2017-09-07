import java.util.Scanner;

/**
 * Created by moonti on 2016. 10. 18..
 */
public class PracticeString {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int k;
        for (int i=0; i<num; i++) {
            k = input.nextInt();
            String str = input.nextLine();
            repeatWord(str, k);
        }
    }

    public static void repeatWord(String str, int num) {
        StringBuffer strBuffer = new StringBuffer();
        for (int i = 0; i<str.length(); i++) {
            for (int j=0; j<num; j++) {
                strBuffer.append(str.charAt(i));
            }
        }
        String result = strBuffer.toString().trim();
        if (result.length() > 0) {

            System.out.println(result);
        }
    }

    public static int getAscii(char a) {
        return (int)a;
    }

    public static void findAlphabet(String str) {
        int a = 97;
        int[] A = new int[30];
        for (int k = 0; k<30; k++) {
            A[k] = -1;
        }
        char c;
        for (int i = 0; i<str.length(); i++) {
            c = str.charAt(i);
            if (A[getAscii(c)-a] == -1) {
                A[getAscii(c)-a] = i;
            }
        }

        for (int j = 0; j<26; j++) {
            System.out.print((A[j]) + " ");
        }
    }
}
