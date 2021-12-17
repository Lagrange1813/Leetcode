import Foundation

class Queue<Item> {
    init() {}
    
    var n = 0
    
    class Node<Item> {
        var item: Item?
        var next: Node<Item>?
    }

    var first: Node<Item>?
    var last: Node<Item>?
    
    func isEmpty() -> Bool {
        return n == 0
    }

    func size() -> Int {
        return n
    }

    func enqueue(_ item: Item) {
        let oldlast = last
        last = Node()
        last?.item = item
        last?.next = nil
        if isEmpty() {
            first = last
        } else {
            oldlast?.next = last
        }
        n += 1
    }

    func dequeue() -> Item {
        let item = first?.item
        first = first?.next
        if isEmpty() {
            last = nil
        }
        n -= 1
        return item!
    }
}

let q = Queue<String>()
let test = ["to", "be", "or", "-"]
let test1 = ["to", "-"]
let test2 = ["to", "be", "or", "-", "not", "to", "be", "this", "is", "-", "-", "a", "question", "-", "-", "-", "-", "-", "-", "-"]
for x in test2 {
    if !(x == "-") {
        q.enqueue(x)
    }
    else if !q.isEmpty() {
        print(q.dequeue() + " ")
    }
}
print("(" + String(q.size()) + " left on stack)")
