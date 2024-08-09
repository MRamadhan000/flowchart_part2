import java.util.Scanner;

public class Student extends User implements IMenu{
    private String studentNumber;
    private String grade; // Menyimpan nilai Student mulai dari E hingga A
    public Student(String name, String studentNumber) {
        super(name);
        this.studentNumber = studentNumber;
        this.grade = "Not Assigned"; // Default grade
    }

    // Menampilkan informasi Student seperti nama, studentNumber dan grade
    public void viewDetails() {
        System.out.println("Student Details:");
        System.out.println("Name: " + getName());
        System.out.println("Student Number: " + studentNumber);
        System.out.println("Grade: " + grade);
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nStudent Menu");
            System.out.println("1. View Details");
            System.out.println("2. Logout");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewDetails();
                    break;
                case 2:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 2);
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
