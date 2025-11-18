package labpackage2;
import package1.student;
public class admin extends student{
    public static void main(String[]args){
        student s = new student();
        s.diplay();
        System.out.println("accessing protected b="+s.c);
    }
}