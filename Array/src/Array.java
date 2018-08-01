public class Array {
    private int[] data;
    private int size;//size指向的是第一个没有元素的位置

    public Array(int capacity){
        data=new int[capacity];
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
    public void addLast(int e){

        /*//方法一：
        if(size == data.length)
            throw new IllegalArgumentException("AddLast failed. Array is full.");

        data[size]=e;
        size++;*/

        //方法二：
        add(size,e);
    }

    //在第index个位置插入一个新元素e
    public void add(int index,int e){

        if(size == data.length)
            throw new IllegalArgumentException("AddLast failed. Array is full.");

        //index要求合法不能为负数，其次不能大于size，否则既没有在数组最后插入新元素，也没有在已有数组中插入，而是跳着插入新元素，导致数组中有的空位置没有合法元素。
        if(index < 0 || index > size)
            throw new IllegalArgumentException("AddLast failed. Require index > 0 && index <= size");

        //从已有的元素最后一位往后面移动，直到将第index那个位置空出
        for(int i = size - 1;i >= index ; i--)
            data[i + 1] = data[i];

        data[index]=e;
        size++;
    }

    //删除第index个位置的元素,返回该位置元素
    public int remove(int index){

        if(index >= size || index < 0)
            throw new IllegalArgumentException("Remove failed.");

        int ret = data[index];
        for(int i = index + 1; i < size; i++){
            data[i - 1] = data[i];
        }
        size--;
        return ret;
    }

    public int removeFirst(){
        return remove(0);
    }

    public int removeLast(){
        return remove(size-1);
    }

    public void removeElement(int e){
        int index = find(e);
        if (index != -1)
            remove(index);
    }

    //获取index索引位置元素
    int get(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal");
        return data[index];
    }

    //修改index索引位置元素
    void set(int index,int e){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal");
        data[index]=e;
    }

    //查找是否含有元素e
    public boolean contains(int e){
        for(int i = 0; i < size; i++){
            if(data[i] == e)
                return true;
        }
        return false;
    }

    //查找到e,存在就返回其索引
    public int find(int e){
        for(int i = 0; i < size; i++){
            if(data[i] == e)
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
