package stack;

/* 逆波兰表达式求值 */

public class _150 {

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

    public int evalRPN(String[] tokens) {
        Stack<Integer> number = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            int value = 0;
            char temp = tokens[i].charAt(0);
            if ((tokens[i].length() == 1) && (temp < 48 || temp > 57)) {
                int first = number.pop();
                int next = number.pop();
                /*System.out.println(next);
                System.out.println(first);*/
                if (tokens[i].equals("*")) {
                    value = first * next;
                } else if (tokens[i].equals("/")) {
                    value = next / first;
                } else if (tokens[i].equals("+")) {
                    value = next + first;
                } else if (tokens[i].equals("-")) {
                    value = next - first;
                }
                number.push(value);
            } else {
                int cache = Integer.parseInt(tokens[i]);
                number.push(cache);
//                System.out.println(cache);
            }
        }
        int last = number.pop();
        return last;
    }

    public static void main(String[] args) {
        String[] test = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        _150 get = new _150();
        int vlaue = get.evalRPN(test);
        System.out.println(vlaue);
    }
}

