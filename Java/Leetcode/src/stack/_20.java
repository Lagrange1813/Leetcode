package stack;

import java.util.Scanner;

/* 有效的括号 */

public class _20 {
    public class Stack<Item> {
        private int n;

        private class Node {
            Item item;
            Node next;
        }

        Node first;

        public boolean isEmpty() {
            return first == null;
        }

        public int size() {
            return n;
        }

        public void push(Item item) {
            Node oldfirst = first;
            first = new Node();
            first.item = item;
            first.next = oldfirst;
            n++;
        }

        public Item pop() {
            Item item = first.item;
            first = first.next;
            n--;
            return item;
        }
    }

    public boolean isValid(String s) {
        Stack<Character> load = new Stack<Character>();
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            char now;
            boolean test = current == ']' || current == ')' || current == '}';
            if (load.isEmpty() && test) {
                return false;
            }
            if (current == '[' || current == '(' || current == '{') {
                load.push(current);
            }
            if (current == ']' || current == ')' || current == '}') {
                now = load.pop();
                if (current == ']' && now == '[')
                    flag = true;
                else if (current == ')' && now == '(')
                    flag = true;
                else if (current == '}' && now == '{')
                    flag = true;
                else {
                    flag = false;
                    break;
                }
            }
            if (i == s.length() - 1 && !load.isEmpty())
                return false;
        }
        return flag;
    }

    public static void main(String[] args) {
        Scanner getIn = new Scanner(System.in);
        String est = getIn.nextLine();
        _20 haveatest = new _20();
        String test = "test";
        boolean flag = haveatest.isValid(est);
        System.out.print(flag);
    }
}
