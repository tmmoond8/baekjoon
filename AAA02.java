/**
 * Created by moonti on 2016. 10. 22..
 */
public class AAA02 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] coinTypes = {5, 7};
        solution.solution(coinTypes, 22);
    }

    private static class Solution {
        static final int SIZE = 10005;
        static int[] sCoinTypes;
        static int count = 0;

        public int solution(int[] coinTypes, int money) {
            sCoinTypes = coinTypes.clone();
            process(22);
            System.out.print(count);

            return 0;
        }
        public void process(int money) {
            if (money == 0) {
                count++;
            }
            if (money < 0) {
                return;
            }
            for (int i =0; i<sCoinTypes.length; i++) {
                process(money - sCoinTypes[i]);
            }
        }
    }

}
