import java.util.ArrayList;
import java.util.List;
public class test {
    public static void main(String[] args)
    {
        Student[] stud=new Student[10];
        for (int i=0;i<10;i++)
        {
            stud[i]=new Student( (int)(Math.random()*100+1),(int)(Math.random()*4+2));
            System.out.println(stud[i]);
        }
        System.out.println("Sorting...");
        Student.SortingStudentsByID(stud);
        for (int i=0;i<10;i++)
        {
            System.out.println(stud[i]);
        }
        System.out.println("Sorting by GPA...");
        Student.SortingStudentsByGPA(stud);
        for (int i=0;i<10;i++)
        {
            System.out.println(stud[i]);
        }
        System.out.println("Merge sorting by GPA...");
        List<Student> l1=new ArrayList<>();
        List<Student> l2=new ArrayList<>();
        List<Student> l3=new ArrayList<>();
        for (int i=0;i<10;i++)
        {
            Student temp=new Student( (int)(Math.random()*100+1),(int)(Math.random()*4+2));
            Student t=new Student( (int)(Math.random()*100+1),(int)(Math.random()*4+2));
            l1.add(temp);
            l2.add(t);
        }
        l1= Student.mergeSort(l1);
        l2=Student.mergeSort(l2);
        l3=Student.mergeArr(l1,l2);
        for(Student student:l3)
        {
            System.out.println(student);
        }
    }
}
