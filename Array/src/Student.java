public class Student {

    public String name;
    public int score;

    public Student(String studentName, int studentScore){
        name=studentName;
        score=studentScore;
    }

    @Override
    public String toString() {
        return String.format("Student(name:%s,score:%d)",name,score);
    }

    public static void main(String[] args){

        Array<Student> arr = new Array<>();
        arr.addLast(new Student("ty",100));
        arr.addLast(new Student("tyy",100));
        arr.addLast(new Student("tyyy",100));
        System.out.println(arr);

    }
}
