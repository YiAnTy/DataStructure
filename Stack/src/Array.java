//进行泛化，从int 到不指定数据类型
//这时候data[]里面存放的是一个一个类对象的引用，不再是具体的int类型数据
public class Array<E> {
    private E[] data;
    private int size;//size指向的是第一个没有元素的位置

    public Array(int capacity){
        data=(E[])new Object[capacity];
        size=0;
    }

    public Array(){
        this(10);
    }

    public int getSize(){
        return size;
    }

    public int getCapacity(){
        return data.length;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    //向所有元素后添加一个新元素
    public void addLast(E e){

        /*//方法一：
        if(size == data.length)
            throw new IllegalArgumentException("AddLast failed. Array is full.");

        data[size]=e;
        size++;*/

        //方法二：
        add(size,e);
    }

    //在第index个位置插入一个新元素e
    public void add(int index,E e){

        //index要求合法不能为负数，其次不能大于size，否则既没有在数组最后插入新元素，也没有在已有数组中插入，而是跳着插入新元素，导致数组中有的空位置没有合法元素。
        if(index < 0 || index > size)
            throw new IllegalArgumentException("AddLast failed. Require index > 0 && index <= size");

        //空间不够用的时候，动态增加
        if(size == data.length)
            resize(2*data.length);

        //从已有的元素最后一位往后面移动，直到将第index那个位置空出
        for(int i = size - 1;i >= index ; i--)
            data[i + 1] = data[i];

        data[index]=e;
        size++;
    }

    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity];
        for(int i = 0; i<size; i++)
            newData[i] = data[i];
        data = newData;
    }

    //删除第index个位置的元素,返回该位置元素
    public E remove(int index){

        if(index >= size || index < 0)
            throw new IllegalArgumentException("Remove failed.");

        E ret = data[index];
        for(int i = index + 1; i < size; i++){
            data[i - 1] = data[i];
        }
        size --;
        data[size]=null;

        //防止复杂度震荡
        if(size == data.length / 4 && data.length !=0)
            resize(data.length / 2);
        return ret;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }

    public void removeElement(E e){
        int index = find(e);
        if (index != -1)
            remove(index);
    }

    //获取index索引位置元素
    public E get(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal");
        return data[index];
    }

    //获取最后位置的元素
    public E getLast(){
        return get(size-1);
    }
    //获取第一个位置的元素
    public E getFirst(){
        return get(0);
    }

    //修改index索引位置元素
    public void set(int index,E e){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal");
        data[index]=e;
    }

    //查找是否含有元素e
    public boolean contains(E e){
        for(int i = 0; i < size; i++){
            if(data[i].equals(e))
                return true;
        }
        return false;
    }

    //查找到e,存在就返回其索引
    public int find(E e){
        for(int i = 0; i < size; i++){
            if(data[i].equals(e))
                return i;
        }
        return -1;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n",size,data.length));
        res.append('[');
        for (int i =0 ; i< size ; i++){
            res.append(data[i]);
            if(i != size - 1)
                res.append(",");
        }
        res.append(']');
        return res.toString();
    }

}
