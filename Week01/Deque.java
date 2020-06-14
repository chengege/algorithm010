//用新的API改写
/**
 * 原代码
 */
class Test{
    /**
     * 原代码
     */
    public void oldCode() {
        Deque<String> deque = new LinkedList<String>();

        deque.push("a");
        deque.push("b");
        deque.push("c");
        System.out.println(deque);

        String str = deque.peek();
        System.out.println(str);
        System.out.println(deque);

        while(deque.size() > 0){
            System.out.println(deque.pop());
        }
        System.out.println(deque);
    }
    /**
     * 修改
     * push -> addFirst
     * pop -> removeFirst
     * peek -> peekFirst
     */
    public void newCode() {
        Deque<String> deque = new LinkedList<String>();

        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);

        String str = deque.peekFirst();
        System.out.println(str);
        System.out.println(deque);

        while(deque.size() > 0){
            System.out.println(deque.removeFirst());
        }
        System.out.println(deque);
    }
}
