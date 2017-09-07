import sun.rmi.server.InactiveGroupException;

import java.io.*;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by moonti on 2016. 10. 19..
 */
public class PracticeDeque {



    public static void main(String[] args) throws IOException {
//        MyDeque myDeque = new MyDeque();
//        myDeque.run();


//        CircularQueue<Integer> circularQueue = new CircularQueue<>();
//        circularQueue.getInput();;
//        for (int i=1; i<=circularQueue.SIZE; i++) {
//            circularQueue.addLast(i);
//        }
//        circularQueue.run();
        List<AcDeque> acDequeList = new LinkedList<>();
//        Scanner input = new Scanner(System.in);
        InputStreamReader stream = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(stream);
        OutputStream out = new BufferedOutputStream(System.out);

        int n = 0;
        try {
            n = Integer.parseInt(bf.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        String cmd;
        String count;
        String array;
        for (int i=0; i<n; i++) {
            AcDeque acDeque = new AcDeque();
//            acDeque.getInput();

            try {
                cmd = bf.readLine().replace("RR", "");
                count = bf.readLine();
                array = bf.readLine();
                acDeque.command = cmd;
                acDeque.N = Integer.valueOf(count);
                String temp = array.trim();
                String[] strings = temp.substring(1, temp.length()-1).split(",");
                for (int j=0; j<strings.length; j++) {
                    acDeque.push(strings[j]);
                }
                acDequeList.add(acDeque);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        for (int i=0; i<n; i++) {
            AcDeque acDeque = acDequeList.get(i);
            acDeque.run();
            out.write((acDeque.getResult() + "\n").getBytes());
        }
        out.flush();
    }



    public static class AcDeque {
        private final int SIZE = 200004;
        int N;
        int front = SIZE/2;
        int rear = front -1;
        String command;
        boolean error = false;
        boolean directionFlag = true;

        int[] array = new int [SIZE];

        public void run() {
            process(command);
        }

        public void getInput() {
            Scanner input = new Scanner(System.in);
            command = input.nextLine();
            N = Integer.valueOf(input.nextLine());
            String temp = input.nextLine().trim();
            String[] strings = temp.substring(1, temp.length()-1).split(",");
            for (int i=0; i<strings.length; i++) {
                push(strings[i]);
            }
        }

        public void process(String cmd) {
            char c;
            for (int i=0; i<cmd.length(); i++) {
                c = cmd.charAt(i);
                executeCmd(String.valueOf(c));
//                printArray();
            }
        }

        public void executeCmd(String cmd) {
            if (cmd.compareToIgnoreCase("R") == 0) {
                functionR();
            } else if (cmd.compareToIgnoreCase("D") == 0) {
                functionD();
            }
        }

        public void functionR() {
            int temp = front;
            front = rear;
            rear = temp;
            directionFlag = !directionFlag;
        }
        public void functionD() {
            try {
                pop();
            } catch (IndexOutOfBoundsException e) {
                error = true;
            }
        }

        public String getResult() {
            StringBuffer sb = new StringBuffer();
            if (error) {
                return "error";
            } else {
                int i = 1;
                sb.append("[");
                while(!isEmpty()) {
                    sb.append(pop());
                    sb.append(",");
                }
                if(sb.length() > 1) {
                    sb.deleteCharAt(sb.length()-1);
                }
                sb.append("]");
                return sb.toString();
            }
        }

        public void push(int a) {
            array[++rear] = a;
        }
        public void push(String a) {
            if ("".compareToIgnoreCase(a) == 0) {
                return;
            }
            int value = Integer.valueOf(a);
            push(value);
        }

        public int pop() {
            int result;
            if (isEmpty()) {
                throw new IndexOutOfBoundsException();
            }
            result = array[front];
            array[front] = 0;
            if (directionFlag) {
                front++;
            } else {
                front--;
            }

            return result;
        }
        public int peek() {

            if (isEmpty()) {
                throw new IndexOutOfBoundsException();
            }
            int result = array[front];
            return result;
        }

        public int size() {
            if(isEmpty()) {
                return 0;
            }
            if (directionFlag) {
                return rear - front + 1;
            } else {
                return front - rear + 1;
            }

        }
        public void printArray() {
            if (isEmpty()) {
                return;
            }
            int i=0;

            while(front+i <= rear) {
                System.out.print(array[front+i] + " ");
                i++;
            }
            System.out.println();
        }



        public boolean isEmpty() {
            if (directionFlag) {
                if (front > rear) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if (front < rear) {
                    return true;
                } else {
                    return false;
                }
            }
        }


    }




    public static class CircularQueue<E> extends ArrayDeque<E> {
        static int[] finds = new int[51];
        public void printDeque() {
            Iterator<E> iterator = (Iterator<E>) iterator();
            while(iterator.hasNext()) {
                System.out.println(iterator.next());
            }

        }

        public void run() {
            int totalCount = 0;
            int leftCount;
            int find, k;
            for (int i = 0; i<SEARCH_SIZE; i++) {
                find = finds[i];
                k = (Integer)peek();
                if (k == find) {
                    pop();
                    continue;
                }
                leftCount = 0;
                while(true) {
                    moveLeft();
                    leftCount++;
                    k = (Integer)peek();
                    if (k == find) {
                        pop();
                        break;
                    }
                }

                totalCount += Math.min(leftCount, size()+1 - leftCount);

            }
            System.out.println(totalCount);

        }

        public void getInput() {
            Scanner input = new Scanner(System.in);
            SIZE = input.nextInt();
            SEARCH_SIZE = input.nextInt();
            for (int i= 0; i<SEARCH_SIZE; i++) {
                finds[i] = input.nextInt();
            }
        }


        static int SIZE;
        static int SEARCH_SIZE;
        public void moveLeft() {
            if(isEmpty()) {
                return;
            }
            E temp = pop();
            addLast(temp);
        }
        public void moveRight() {
            if(isEmpty()) {
                return;
            }
            E temp = pollLast();
            addFirst(temp);
        }
        @Override
        public void push(E e) {
            if (size() == 50) {
                return ;
            } else {
                super.push(e);
            }
        }


    }



    public static class MyDeque {

        private static int SIZE = 1000000;
        private static int[] deque = new int[SIZE];
        int N;
        String[] cmdArray = new String[SIZE];
        int front = SIZE/2;
        int rear = front-1;
        public int popFront() {
            if (isEmpty() == 1) {
                return -1;
            }
            int result = deque[front];
            deque[front++] = 0;
            return result;
        }
        public int front() {
            if (isEmpty() == 1) {
                return -1;
            }
            return deque[front];
        }

        public int popBack() {
            if (isEmpty() == 1) {
                return -1;
            }
            int result = deque[rear];
            deque[rear--] = 0;
            return result;
        }

        public int back() {
            if (isEmpty() == 1) {
                return -1;
            }
            return deque[rear];
        }

        public void pushFront(int x) {
            deque[--front] = x;
        }
        public void pushBack(int x) {
            deque[++rear] = x;
        }


        public int size() {
            if (isEmpty() == 1) {
                return 0;
            } else {
                return rear - front + 1;
            }
        }
        public int isEmpty() {
            if (front > rear) {
                front = SIZE/2;
                rear = front-1;
                return 1;
            } else {
                return 0;
            }
        }
        public void run() {
            getInput();
            for(int i= 0; i<N; i++) {
                process(cmdArray[i]);
            }
        }
        public void getInput() {
            Scanner input= new Scanner(System.in);
            N = input.nextInt();
            input.nextLine();
            for(int i= 0; i<N; i++) {
                cmdArray[i] = input.nextLine();
            }
        }
        public void process(String cmd) {
            String[] cmdArgs = cmd.split(" ");
            if (cmdArgs[0].compareToIgnoreCase("push_back") == 0) {
                pushBack(Integer.valueOf(cmdArgs[1]));
            } else if (cmdArgs[0].compareToIgnoreCase("push_front") == 0) {
                pushFront(Integer.valueOf(cmdArgs[1]));
            } else if (cmdArgs[0].compareToIgnoreCase("front") == 0) {
                System.out.println(front());
            } else if (cmdArgs[0].compareToIgnoreCase("back") == 0) {
                System.out.println(back());
            } else if (cmdArgs[0].compareToIgnoreCase("size") == 0) {
                System.out.println(size());
            } else if (cmdArgs[0].compareToIgnoreCase("empty") == 0) {
                System.out.println(isEmpty());
            } else if (cmdArgs[0].compareToIgnoreCase("pop_front") == 0) {
                System.out.println(popFront());
            } else if (cmdArgs[0].compareToIgnoreCase("pop_back") == 0) {
                System.out.println(popBack());
            }
        }
    }
}
