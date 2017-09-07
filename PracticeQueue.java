import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by moonti on 2016. 10. 19..
 */
public class PracticeQueue {

    public static void main(String[] args) {
        Printer1966 printer1966 = new Printer1966();
        printer1966.run();
    }

    public static class Printer1966 {

        static final int SIZE = 105;
        static int N;
        int[] arrayCount = new int[SIZE];
        int[] arraySearch = new int[SIZE];
        List<LinkedBlockingDeque<Work>> queueList = new LinkedList<>();
        List<ArrayList<Integer>> priotyList = new LinkedList<>();
        LinkedBlockingDeque<Work> queue;
        ArrayList<Integer> prioty;


        Work work;
        public void getInput() {
            Scanner input = new Scanner(System.in);
            N = input.nextInt();
            for (int i=1; i<=N; i++) {
                arrayCount[i] = input.nextInt();
                arraySearch[i] = input.nextInt();
                queue = new LinkedBlockingDeque<>();
                prioty = new ArrayList<>();
                for (int j = 0; j<arrayCount[i]; j++) {
                    work = new Work();
                    work.index = j;
                    work.prioty = input.nextInt();
                    queue.addLast(work);
                    prioty.add(work.prioty);
                }
                Collections.sort(prioty);
                priotyList.add(prioty);
                queueList.add(queue);
            }
        }
        private class Work {
            int index;
            int prioty;
        }

        public void run() {
            getInput();
            for (int i=0; i<N; i++) {
                queue = queueList.get(i);
                System.out.println(process(i, arraySearch[i+1]));
            }
        }
        public int process(int idx, int find) {
            int count = 0;
            queue = queueList.get(idx);
            prioty = priotyList.get(idx);
            int lastTemp;
            while(!queue.isEmpty()) {
//                printQueue(queue);
                Work work = queue.pop();
                if (!prioty.isEmpty()) {
                    lastTemp = prioty.get(prioty.size()-1);
                } else {
                    lastTemp = 0;
                }
                if (lastTemp > work.prioty) {
                    queue.addLast(work);
                } else {
                    prioty.remove(prioty.size()-1);
                    count++;
                    if (work.index == find) {
                        return count;
                    }
                }
            }
            return -1;
        }
    }

    public static void printQueue(LinkedBlockingDeque<Printer1966.Work> queue) {
        Iterator<Printer1966.Work> iterator = queue.iterator();
        while(iterator.hasNext()) {
            System.out.print(iterator.next().prioty + " ");
        }
        System.out.println();
    }

    public static class Graph1260 {

        private static final int SIZE = 1005;
        static int N, M, V;
        static boolean[][] graph = new boolean[SIZE][SIZE];
        static int[] path = new int[SIZE];
        static boolean[] check = new boolean[SIZE];
        boolean dfsFinish = false;
        boolean bfsFinish = false;
        int dfsMax = 0;
        int bfsMax = 0;
        int x, y;
        int pathCount = 1;
        private void getInput() {
            Scanner input = new Scanner(System.in);
            N = input.nextInt();
            M = input.nextInt();
            V = input.nextInt();
            for(int i=0; i<M; i++) {
                x = input.nextInt();
                y = input.nextInt();
                graph[x][y] = true;
                graph[y][x] = true;
            }
        }
        private void processBfs() {
            LinkedBlockingDeque<Integer> queue = new LinkedBlockingDeque<>();
//            path[pathCount] = 1;
//            check[pathCount] = true;
            int current = V;
            pathCount = 1;
            queue.push(current);
            while(!queue.isEmpty()) {
                current = queue.pop();
                if (pathCount == N) {
                    // end
                    bfsFinish = true;
                    System.out.println();
                    for (int i=1; i<=pathCount; i++) {
                        System.out.print(path[i] + " ");
                    }
                    queue.clear();
                }
                for (int i=2; i<= N; i++) {
                    if (check[i]) continue;
                    if (graph[current][i]) {
                        path[++pathCount] = i;
                        check[i] = true;
                        queue.addLast(i);
                    }
                }
            }
        }

        private void processDfs(int num) {
            if (dfsMax < num) {
                dfsMax = num;
            }
            if (dfsFinish) {
                return;
            }
            if (num >= N) {
                for (int i= 1; i<=num; i++) {
                    System.out.print(path[i] + " ");
                }
                dfsFinish = true;
                return;
            }
            int current = path[num];
            for (int i=2; i<=N; i++) {
                if (check[i]) {
                    continue;
                }
                if (graph[current][i]) {
                    path[num+1] = i;
                    check[i] = true;
                    processDfs(num +1);
//                    path[pathCount--] = 0;
//                    check[i] = false;
                }
            }
        }
        private void printGraph() {
            for(int i=1; i<=N; i++) {
                for (int j=1; j<=N; j++) {
                    if(graph[i][j]) {
                        System.out.print("1 ");
                    } else {
                        System.out.print("0 ");
                    }
                }
                System.out.println();
            }
        }


        public void run() {
            getInput();
            path[1] = 1;
            check[1] = true;
            processDfs(V);
            if (!dfsFinish) {
                for (int i= 1; i<=dfsMax; i++) {
                    System.out.print(path[i] + " ");
                }
            }
            for(int i=2; i<=N; i++) {
                path[i] = 0;
                check[i] = false;
            }
            pathCount = 1;

            processBfs();
            if (!bfsFinish) {
                bfsFinish = true;
                System.out.println();
                for (int i=1; i<=pathCount; i++) {
                    System.out.print(path[i] + " ");
                }
            }
        }
    }

    public static void queueTest() {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        MyQueue queue = new MyQueue();
        input.nextLine();
        for (int i=0; i<N; i++) {
            executeCmd(queue, input.nextLine());
        }
    }
    public static void executeCmd(MyQueue queue, String cmd) {
        String[] args = cmd.split(" ");
        if (args[0].compareToIgnoreCase("push") == 0) {
            queue.push(Integer.valueOf(args[1]));
        } else if (args[0].compareToIgnoreCase("front") == 0) {
            System.out.println(queue.front());
        } else if (args[0].compareToIgnoreCase("pop") == 0) {
            System.out.println(queue.pop());
        } else if (args[0].compareToIgnoreCase("size") == 0) {
            System.out.println(queue.size());
        } else if (args[0].compareToIgnoreCase("back") == 0) {
            System.out.println(queue.back());
        } else if (args[0].compareToIgnoreCase("empty") == 0) {
            System.out.println(queue.empty());
        }

    }

    public static class MyQueue {
        int[] array = new int[10005];
        int start = 0;
        int next = 0;

        public void push(int num) {
            array[next++] = num;
        }
        public int size() {
            return next - start;
        }
        public int pop() {
            if (size() == 0) {
                return -1;
            }
            int result = array[start++];
            return result;
        }
        public int empty() {
            if (size() == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        public int front() {
            if (size() == 0) {
                return -1;
            }
            return array[start];
        }
        public int back() {
            if (size() == 0) {
                return -1;
            }
            return array[next-1];
        }

    }
}
