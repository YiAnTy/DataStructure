public class BST<E extends Comparable<E>> {

    private class Node{
        public E e;
        public Node left,right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }
    private Node root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    //添加新元素
    public void add(E e){
        root = add(root,e);
    }
    
    //以node 为根的二分搜索树插入元素E,进行递归
    //返回插入节点的树的根
    private Node add(Node node, E e){

        if(node == null){
            size ++;
            return new Node(e);
        }

        if(e.compareTo(node.e) < 0)
            node.left = add(node.left,e);
        else if (e.compareTo(node.e) > 0)
            node.right = add(node.right,e);

        return node;
    }

    //看二分搜索树中是否包含元素e
    public boolean contains(E e){
        return contains(root, e);
    }

    //以node 为根的二分搜索树查找是否包含元素E,进行递归
    private boolean contains(Node node , E e){

        if(node == null)
            return false;

        if(e.compareTo(node.e) == 0)
            return true;
        else if(e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else
            return contains(node.right, e);


    }
}
