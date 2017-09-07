import java.io.*;
import java.util.*;

/**
 * Created by moonti on 2016. 10. 18..
 */
public class practiceSort {

    private static final int SIZE = 1000005;
    private static int[] array = new int[SIZE];
    private static int N;


    public static void main(String[] args) throws IOException {
        InputStreamReader stream = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(stream);

        OutputStream out = new BufferedOutputStream( System.out );


        try {
            N = Integer.parseInt(bf.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean[] negative = new boolean[SIZE];
        boolean[] positive = new boolean[SIZE];
        int num;
        for(int i= 0; i<N; i++) {

                num = Integer.parseInt(bf.readLine());
                if (num > 0) {
                    positive[num] = true;
                } else {
                    negative[num*(-1)] = true;
                }

        }

        for (int j = N; j>=0; j--) {
            if (negative[j]) {
                out.write((j*(-1) + "\n").getBytes());
            }
        }

        for (int j = 0; j<=N; j++) {
            if (positive[j]) {

                out.write((j + "\n").getBytes());
            }
        }
        out.flush();
    }

    public static void merge(List<Integer> U, List<Integer> left, List<Integer> right) {
        int l = 0;
        int r= 0;
        while(l <left.size() || r < right.size() ) {
            if (l >=left.size()) {
                U.add(right.get(r));
                r++;
            } else if (r >= right.size()) {
                U.add(left.get(l));
                l++;
            } else if (right.get(r) < left.get(l)) {
                U.add(right.get(r));
                r++;
            } else {
                U.add(left.get(l));
                l++;
            }
        }
    }
    public static void mergeSort(List<Integer> list) {
        if (list.size() == 1) {
            return;
        }
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        int n = list.size();
        for (int i = 0; i<n ;i++) {
            if (i<n/2) {
                leftList.add(list.get(i));
            } else {
                rightList.add(list.get(i));
            }
        }
        mergeSort(leftList);
        mergeSort(rightList);
        list.clear();
        merge(list, leftList, rightList);
    }

    public static int partition(int start, int end) {
        int pivot = array[start];
        int lowIndex = start;
        for (int i = start+1; i<=end; i++) {
            if (pivot <= array[i]) {
                // 순서를 바꿀 필요 없지/
            } else {
                change(i, ++lowIndex);
            }
        }
        change(start, lowIndex);
        return lowIndex;
    }
    public static void quicksort(int start, int end) {
        if (start < 0 || end >= N || start >= end) return;
        int pivotPosition = partition(start, end);
        quicksort(start, pivotPosition-1);
        quicksort(pivotPosition+1, end);
    }



    public static void insertSort() {
        LinkedList<Integer> list = new LinkedList<>();
        int j,i;
        for(i = 0; i<N; i++) {
            for(j= 0; j<list.size(); j++) {
                if (array[i] < list.get(j)) {
                    break;
                }
            }
            list.add(j, array[i]);
        }

        for (int k =0; k<list.size(); k++) {
            System.out.println(list.get(k));
        }
    }
    public static void selectSort() {
        for (int i = 1; i<N; i++) {
            for (int j = i; j>0; j--) {
                if (array[j-1] > array[j]) {
                    change(j-1, j);
                } else {
                    break;
                }
            }
        }
    }

    public static void bubbleSort() {

        for(int i=1; i<N; i++) {
            for (int j=1; j<N; j++) {
                if (array[j-1] > array[j]) {
                    change(j-1, j);
                }
            }
        }
    }



    public static void change(int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
