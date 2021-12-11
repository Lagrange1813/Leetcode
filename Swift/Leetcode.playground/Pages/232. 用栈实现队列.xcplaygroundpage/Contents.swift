class Stack<Item> {
    init() {}
    var n = 0
    class Node<Item> {
        var item: Item? = nil
        var next: Node<Item>?
    }
    var first: Node<Item>? = nil
    func isEmpty() -> Bool{
        return n == 0
    }
    func size() -> Int {
        return n
    }
    func push(_ item: Item?) {
        let oldfirst = first
        first = Node()
        first?.item = item
        first?.next = oldfirst
        n += 1
    }
    func pop() -> Item {
        let item = first?.item
        first = first?.next
        n -= 1
        return item!
    }
}

var s = Stack<String>()
let test = ["to", "be", "or", "-"]
for x in test {
    if !(x == "-") {
        s.push(x)
    }
    else if !s.isEmpty() {
        print(s.pop() + " ")
    }
}
print("(" + String(s.size()) + " left on stack)")
