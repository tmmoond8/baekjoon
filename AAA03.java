/**
 * Created by moonti on 2016. 10. 22..
 */
public class AAA03 {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
//        System.out.print(solution.process("oncn"));
//        System.out.print(solution.solve("aaaabaa"));
    }

    private static class Solution {

        static int pelind;

        public int process(String str) {
            int size =str.length();
            pelind = str.length()/2;
            boolean flag;
            int i;
            char a, b;
            while(pelind <= size) {
                flag = true;
                i = 0;
                while (flag) {
                    i++;
                    if (pelind+i >= size) {
                        return 1;
                    }
                    a = str.charAt(pelind-i);
                    b = str.charAt(pelind+i);
                    if (a== b) {
                        flag = true;
                        if (pelind + i+1 == size) {
                            return i + 1;
                        }
                        continue;
                    } else {
                        flag = false;
                        break;
                    }

                }
                pelind++;
            }
            return 1;
        }

        public int solve(String str) {
           int com = process(str);
            return str.length() + str.length() - com*2 + 1;
        }
    }


    private static class Solution2 {

        static int n;
        static final int SIZE = 10;
        int[][] D = new int[SIZE][SIZE];


        public void solve(String str) {
            n = str.length();
            for (int i=1; i<=n; i++) {
                for (int j=1; j<=n; j++) {
                    if (str.charAt(i-1) == str.charAt(n-j)) {
                        D[i][j] = D[i-1][j-1] + 1;
                    } else {
                        D[i][j] = Math.max(D[i][j-1], D[i-1][j]);
                    }
                }
            }

            System.out.print(n - D[n][n]);
        }


    }

}
