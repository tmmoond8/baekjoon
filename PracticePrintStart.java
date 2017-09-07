/**
 * Created by moonti on 2016. 10. 23..
 */
public class PracticePrintStart {
    public static void main (String[] arg) {
        printStar();
    }

    public static void printStar() {
        int N = 11;
        int width = 3;

        for (int i = 1; i<=N; i++) {


            if (i <= N/2+1) {
                for (int j = 1; j<= (N-(i*2-1))/2; j++) {
                    System.out.print(".");
                }

                for (int j = 1; j<= i*2-1; j++) {
                    if (j<=width || i*2-1 - j < width) {
                        System.out.print("*");
                    } else {
                        System.out.print(".");
                    }

                }
                for (int j = 1; j<= (N-(i*2-1))/2; j++) {
                    System.out.print(".");
                }
            } else {
                for (int j = 1; j<= (N-((N-i)*2))/2; j++) {
                    System.out.print(".");
                }

                for (int j = 1; j<= (N-i)*2+1; j++) {
                    if (j<=width || (N-i)*2+1 - j < width) {
                        System.out.print("*");
                    } else {
                        System.out.print(".");
                    }

                }
                for (int j = 1; j<= (N-((N-i)*2))/2; j++) {
                    System.out.print(".");
                }
            }





            System.out.println();
        }
    }

}
