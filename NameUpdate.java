import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class NameUpdate {
    public static void main(String[] args) {
        String filename = "name.txt";
        Scanner scanner = new Scanner(System.in);

        try (RandomAccessFile raf = new RandomAccessFile(filename, "rw")) {
            // Step 1: Write your name initially
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();

            // Save name to file
            raf.setLength(0); // clear previous content
            raf.writeBytes(name);

            // Read and display stored name
            raf.seek(0);
            byte[] data = new byte[(int) raf.length()];
            raf.readFully(data);
            String storedName = new String(data).trim();
            System.out.println("Stored Name: " + storedName);

            // Step 2: Check if the name has a surname
            if (!storedName.contains(" ")) {
                System.out.print("Did you forget to add your surname? (yes/no): ");
                String answer = scanner.nextLine().toLowerCase();

                if (answer.equals("yes")) {
                    System.out.print("Enter your surname: ");
                    String surname = scanner.nextLine();

                    String fullName = storedName + " " + surname;

                    // Overwrite with full name
                    raf.seek(0);
                    raf.setLength(0); // clear previous content
                    raf.writeBytes(fullName);
                    System.out.println("Updated Name: " + fullName);
                } else {
                    System.out.println("No update made.");
                }
            } else {
                System.out.println("Your name already has a surname.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}