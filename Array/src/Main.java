public class Main {

    public static void main(String[] args) {
	// write your code here
       /* int[] arr = new int[10];
        for (int i = 0 ; i < arr.length;i++){
            arr[i]=i;
        }
        int[] scores=new int[]{100,44,22};
        for(int i=0;i<scores.length;i++)
            System.out.println(scores[i]);*/

       Array<Integer> arr = new Array<>();
       for (int i = 0; i < 10; i++)
           arr.addLast(i);
       System.out.println(arr);

       arr.add(1,100);
       System.out.println(arr);
       //[0,100,1,2,3,4,5,6,7,8,9]

        arr.remove(1);
        System.out.println(arr);
        arr.remove(1);
        System.out.println(arr);
        arr.remove(1);
        System.out.println(arr);
        arr.remove(1);
        System.out.println(arr);
        arr.remove(1);
        System.out.println(arr);
        arr.remove(1);
        System.out.println(arr);

    }
}
