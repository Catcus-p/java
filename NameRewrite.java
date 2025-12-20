import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class NameRewrite {
    public static void main(String[] args) {
        String filename = "namefile.txt";
        Scanner scanner = new Scanner(System.in);

        try {
            // Open or create the file in read-write mode
            RandomAccessFile raf = new RandomAccessFile(filename, "rw");

            // Prompt user to enter their name
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();

            // Write the name to the file
            raf.setLength(0); // Clear previous content
            raf.writeBytes(name);

            // Display what is stored
            raf.seek(0);
            byte[] nameBytes = new byte[(int) raf.length()];
            raf.readFully(nameBytes);
            String storedName = new String(nameBytes).trim();
            System.out.println("Stored Name: " + storedName);

            // Ask if user wants to add surname
            System.out.print("Did you forget to add your surname? (yes/no): ");
            String response = scanner.nextLine().toLowerCase();

            if (response.equals("yes")) {
                System.out.print("Enter your surname: ");
                String surname = scanner.nextLine();

                // Append surname
                String fullName = storedName + " " + surname;

                // Overwrite with full name
                raf.seek(0);
                raf.setLength(0); // Clear previous content
                raf.writeBytes(fullName);
                System.out.println("Updated Name: " + fullName);
            } else {
                System.out.println("No update needed.");
            }

            raf.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}