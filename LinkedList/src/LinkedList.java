public class LinkedList<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this.e = e;
        }

        public Node(Node next){
            this.next = next;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private  Node dummyhead;
    private int size;

    public LinkedList(){
        dummyhead = new Node(null,null);
        size = 0;
    }

    //获取链表中的元素个数
    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    //在链表头添加新的元素e
    public void addFirst(E e){
        /*Node node = new Node(e);
        node.next = head;
        head = node;*/

        add(0 , e);
    }

    //在链表的index(0-based)位置添加新元素e
    public void add(int index, E e){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add Failed");

        /*if (index == 0)
            addFirst(e);*/
        Node prev = dummyhead;
        for (int i = 0; i < index; i ++)
            prev = prev.next;

            /*Node node = new Node(e);
            node.next = prev.next;
            prev.next = node;*/

        prev.next = new Node(e , prev.next);
        size ++;

    }

    //在链表末端添加新的元素e
    public  void addLast(E e){
        add(size , e);
    }

    //从链表中删除index位置元素
    public E remove(int index){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Get Failed");

        Node prev = dummyhead;
        for (int i = 0; i < index; i ++)
            prev = prev.next;

        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size --;
        return retNode.e;
    }

    //从链表中删除第一个元素
    public E removeFirst(){
        return remove(0);
    }

    //从链表中删除最后一个元素
    public E removeLast(){
        return remove(size - 1);
    }

    //获得链表的index(0-based)位置元素e
    public E get(int index){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Get Failed");

        Node cur = dummyhead.next;
        for (int i = 0; i < index; i ++)
            cur = cur.next;
        return cur.e;
    }

    //获得链表第一个位置元素e
    public E getFirst(int index){
        return get(0);
    }

    //获得链表最后一个位置元素e
    public E getLast(int index){
        return get(size - 1);
    }

    //修改链表的index(0-based)位置元素e
    public void set(int index, E e){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Set Failed");

        Node cur = dummyhead.next;
        for (int i = 0; i < index; i ++)
            cur = cur.next;
        cur.e = e;
    }

    //查找是否存在e
    public boolean contains(E e){

        Node cur = dummyhead.next;
        while(cur != null){
            if(cur.e.equals(e))
                return true;
            cur=cur.next;
        }
        return false;
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();

        Node cur = dummyhead.next;
        while(cur != null){
            res.append(cur + "->");
            cur =  cur.next;
        }
        res.append("null");
        return  res.toString();
    }
}
