package stack;

import java.util.Stack;

/* 用栈实现队列 */

public class _232 {
    Stack<Integer> front;
    Stack<Integer> back;

    public _232() {
        front = new Stack<>();
        back = new Stack<>();
    }

    public void push(int x) {
        front.push(x);

    }

    public int pop() {
        int temp;
        int front_size = front.size();
        for (int i = 0; i < front_size; i++) {
            temp = front.pop();
            back.push(temp);
        }

        int item = back.pop();

        int back_size = back.size();
        for (int i = 0; i < back_size; i++) {
            temp = back.pop();
            front.push(temp);
        }
        return item;
    }

    public int peek() {
        int temp;
        int front_size = front.size();
        for (int i = 0; i < front_size; i++) {
            temp = front.pop();
            back.push(temp);
        }

        int item = back.peek();

        int back_size = back.size();
        for (int i = 0; i < back_size; i++) {
            temp = back.pop();
            front.push(temp);
        }
        return item;
    }

    public boolean empty() {
        return front.empty();
    }

    public static void main(String[] args) {
        _232 test = new _232();
        // Stack<Integer> test = new Stack<>();
        test.push(22);
        test.push(33);
        test.push(44);
        test.push(55);
        test.push(66);
        test.push(77);
        test.push(88);
        test.push(99);
        System.out.println(test.pop());
        System.out.println(test.peek());
        System.out.println(test.empty());
    }
}
