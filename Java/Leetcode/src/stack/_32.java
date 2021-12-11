package stack;

/* 最长有效括号 */

public class _32 {
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

        public Item peek() {
            Item item = first.item;
            return item;
        }

        public Item pop() {
            Item item = first.item;
            first = first.next;
            n--;
            return item;
        }
    }

    public int longestValidParentheses(String s) {
        Stack<Character> load = new Stack<>();
        char temp;
        char now;
        int cnt = 0;
        int max = 0;
        int before = 0;
        for(int i = 0; i < s.length(); i++) {
            temp = s.charAt(i);
            if (temp == '(') {
//                if (!load.isEmpty() && load.peek() == '(')
//                    cnt = 0;
                before = cnt;
                load.push(temp);
            }
            else {
                if (!load.isEmpty()) {
                    now = load.pop();
                    if (now == '(') {
                        cnt++;
                        if (max < cnt)
                            max = cnt;
                    }
                } else {
                    cnt = 0;
                }

            }
        }
        return max*2;
    }

    public static void main(String[] args) {
        String test = "()(())";
        _32 get = new _32();
        int val = get.longestValidParentheses(test);
        System.out.println(val);
    }
}

// ()(()