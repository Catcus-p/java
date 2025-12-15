import java.io.*;
import java.util.*;

class Student {
    String name;
    String className;
    int javaMarks;

    Student(String name, String className, int javaMarks) {
        this.name = name;
        this.className = className;
        this.javaMarks = javaMarks;
    }
}

public class StudentFile {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        FileWriter fw = new FileWriter("student.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        System.out.println("Enter details of 20 BCA 3rd Semester students:\n");

        for (int i = 1; i <= 5; i++) {
            System.out.println("Student " + i);
            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Class: ");
            String className = sc.nextLine();

            System.out.print("Java Marks: ");
            int marks = Integer.parseInt(sc.nextLine());

            bw.write(name + "," + className + "," + marks);
            bw.newLine();
            System.out.println();
        }

        bw.close();

        // Reading from file
        FileReader fr = new FileReader("student.txt");
        BufferedReader br = new BufferedReader(fr);

        System.out.println("Students who secured 30 or more marks in Java:");
        System.out.println("---------------------------------------------");

        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            String name = data[0];
            String className = data[1];
            int marks = Integer.parseInt(data[2]);

            if (marks >= 30) {
                System.out.println("Name: " + name +
                                   " | Class: " + className +
                                   " | Java Marks: " + marks);
            }
        }

        br.close();
        sc.close();
    }
}