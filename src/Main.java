import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Membuat objek Teacher
        Teacher teacher1 = new Teacher("Mr. Smith", "100");
        // Membuat objek Student
        teacher1.addStudent(new Student("Alice", "101"));
        menu();
    }
    public static void menu(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nWelcome to the School System");
            System.out.println("1. Login as Teacher");
            System.out.println("2. Login as Student");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Teacher Identification Number : ");
                    String teacherNumber = scanner.nextLine();
                    boolean teacherFound = false;
                    for (Teacher teacher : Teacher.getTeachersList()) {
                        if (teacher.getIdentificationNumber().equals(teacherNumber)) {
                            teacher.menu(); // Memanggil method menu() pada class Teacher
                            teacherFound = true;
                            break;
                        }
                    }
                    if (!teacherFound) {
                        System.out.println("Teacher not found.");
                    }
                    break;
                case 2:
                    System.out.print("Enter Student Number: ");
                    String studentNumber = scanner.nextLine();
                    boolean studentFound = false;
                    for (Student student : Teacher.getStudentsList()) {
                        if (student.getStudentNumber().equals(studentNumber)) {
                            student.menu(); // Memmanggil method menu() pada class Student
                            studentFound = true;
                            break;
                        }
                    }
                    if (!studentFound) {
                        System.out.println("Student not found.");
                    }
                    break;
                case 3:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }
}