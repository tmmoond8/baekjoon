/**
 * Created by moonti on 2016. 10. 22..
 */
public class AAA01 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] inputs = {"a", "b", "c", "d", "e", "f", "g", "h"};
        solution.solution(inputs);
    }

    public static class Solution{

        static final int SIZE = 10000;
        static private String[] arr1 = new String[SIZE];
        static private String[] arr2 = new String[SIZE];
        static private String[] arr3 = new String[SIZE];
        static int array1Front = 0;
        static int array1Last = 0;
        static int array2Front = 0;
        static int array2Last = 0;
        static int array3Front = 0;
        static int array3Last = 0;
        static int count = 0;

        public String[] solution(String[] inputs) {
            for (int i = 0; i<inputs.length; i++) {
                push(i, inputs[i]);
            }
            int i = 0;
            String[] result = new String[SIZE];
            while(true) {

                if (!isEmpty(0)) {
                    result[i++] = "[arr1," + dequeue(0) + "]";
                } else {
                    break;
                }
                if (!isEmpty(1)) {
                    result[i++] = "[arr2," + dequeue(1) + "]";
                } else {
                    break;
                }
                if (!isEmpty(2)) {
                    result[i++] = "[arr3," + dequeue(2) + "]";
                } else {
                    break;
                }
            }
            return result;
        }

        public void enqueue(String str) {
            switch(count%3) {
                case 0:
                    arr1[array1Last++] = str;
                    break;
                case 1:
                    arr1[array1Last++] = str;
                    break;
                case 2:
                    arr1[array1Last++] = str;
                    break;
                default:
                    break;
            }
        }

        public String dequeue(int idx) {
            String result = "";
            if (idx == 0) {
                if (isEmpty(idx)) {
                    return null;
                } else {
                    result = arr1[array1Front];
                    arr1[array1Front++] = "";
                    return result;
                }
            } else if (idx == 1) {
                if (isEmpty(idx)) {
                    return null;
                } else {
                    result = arr2[array2Front];
                    arr1[array2Front++] = "";
                    return result;
                }
            } else if (idx == 2) {
                if (isEmpty(idx)) {
                    return null;
                } else {
                    result = arr3[array3Front];
                    arr1[array3Front++] = "";
                    return result;
                }
            }
            return null;
        }

        public void push(int idx, String str) {
            if (idx%3 == 0) {
                arr1[array1Last++] = str;
            } else if (idx%3 == 1) {
                arr2[array2Last++] = str;
            } else if (idx%3 == 2) {
                arr3[array3Last++] = str;
            }
        }

        public boolean isEmpty(int idx) {
            if (idx%3 == 0) {
                if (array1Last - array1Front == 0) {
                    return true;
                } else {
                    return false;
                }
            } else if (idx%3 == 1) {
                if (array2Last - array2Front == 0) {
                    return true;
                } else {
                    return false;
                }
            } else if (idx%3 == 2) {
                if (array3Last - array3Front == 0) {
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }



    }

}
