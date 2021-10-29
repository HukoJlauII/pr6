import java.util.ArrayList;
import java.util.List;

public class Student implements Comparable<Student> {
    private int idNumber;
    private int GPA;

    public Student(int idNumber,int GPA)
    {
        this.GPA=GPA;
        this.idNumber=idNumber;
    }

    public int getIdNumber()
    {
        return idNumber;
    }

    public int getGPA()
    {
        return GPA;
    }

    @Override
    public String toString() {
        return "Student{" +
                "idNumber=" + idNumber +
                ", GPA=" + GPA +
                '}';
    }

   public static void SortingStudentsByID(Student[] students)
    {
        for (int i=0;i<students.length-1;i++)
        {
            int val =i;
            for(int j=i+1;j<students.length;j++)
            {
                if (students[j].getIdNumber() < students[val].getIdNumber())
                    val = j;
            }
            if (val != i)
            {
                Student t = students[i];
                students[i] = students[val];
                students[val] = t;
            }

        }
    }

    public static void SortingStudentsByGPA (Comparable[] list) {
        for(int i = 1; i< list.length; i++) {
            Comparable key = list[i];//take value
            int j = i;
            while(j > 0 && list[j-1].compareTo(key)<0) {
                list[j] = list[j-1];
                j--;
            }
            list[j] = key;   //insert in right place
        }
    }
    public static List<Student> mergeArr(List<Student> l1, List<Student> l2)
    {
        List<Student> l3=new ArrayList<>();
        int pos1=0,pos2=0;
        for (int i=0;i< l1.size()+l2.size();i++)
        {
            if(pos1 == l1.size())
            {
                l3.add(l2.get(pos2));
                pos2++;
            }
            else if (pos2 == l2.size())
            {
                l3.add(l1.get(pos1));
                pos1++;
            }else if (l1.get(pos1).getGPA()>l2.get(pos2).getGPA())
            {
                l3.add(l1.get(pos1));
                pos1++;
            } else
            {
                l3.add(l2.get(pos2));
                pos2++;
            }
        }
        return l3;
    }
    public static List<Student> mergeSort(List<Student> l)
    {
        if (l==null)
            return null;
        if (l.size()<2)
            return l;
        List<Student> l1=new ArrayList<>();
        for(int i=0;i<l.size()/2;i++)
        {
            l1.add(l.get(i));
        }
        List<Student> l2=new ArrayList<>();
        for(int i=l.size()/2;i<l.size();i++)
        {
            l2.add(l.get(i));
        }
        l1=mergeSort(l1);
        l2=mergeSort(l2);
        return mergeArr(l1,l2);
    }
    @Override
    public int compareTo(Student o) {
        return this.GPA-o.GPA;
    }
}
