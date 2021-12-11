package stack;

/* 最小栈 */

public class _155 {
    private class Node {
        int item;
        int min;
        Node next;
    }

    Node first;
    private int n;

    public _155() {

    }

    public void push(int val) {
        Node oldfirst = first;
        first = new Node();
        first.item = val;
        first.next = oldfirst;
        if (n == 0) {
            first.min = val;
        } else {
            if (val < oldfirst.min)
                first.min = val;
            else
                first.min = oldfirst.min;
        }
        n++;
    }

    public void pop() {
        first = first.next;
        n--;
    }

    public int top() {
        return first.item;
    }

    public int getMin() {
        return first.min;
    }
}
