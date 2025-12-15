package labpackage2;
import package1.student;
public class admin extends student{
    public void show(){
        System.out.println("accessing protected b="+b)
    }
    public static void main(String[]args){
        student s = new student();
        s.diplay();
        System.out.println("accessing public b="+s.c);
        admin a=new admin();
         a.show();
    }

}