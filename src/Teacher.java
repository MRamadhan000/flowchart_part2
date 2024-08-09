import java.util.ArrayList;
import java.util.Scanner;

public class Teacher extends User implements IMenu{
    private String identificationNumber;
    private static ArrayList<Student> studentsList = new ArrayList<>();  // studentsList untuk menyimpan data Student
    private static ArrayList<Teacher> teachersList = new ArrayList<>(); // teachersList untuk menyimpan data Teacher
    public Teacher(String name, String identificationNumber) {
        super(name);
        this.identificationNumber = identificationNumber;
        teachersList.add(this);
    }

    // Menambah Student
    public void addStudent(Student student) {
        studentsList.add(student);
        System.out.println("Student added: " + student.getName() + " (Student Number: " + student.getStudentNumber() + ")");
    }

    // Menghapus Student berdasarkan studentNumber
    public void removeStudent(String studentNumber) {
        for (Student student : studentsList){
            if (student.getStudentNumber().equals(studentNumber)){
                studentsList.remove(student);
                System.out.println("Student removed: " + studentNumber);
                break;
            }
        }
    }

    // Menampilkan semua Student
    public void displayAllStudents() {
        System.out.println("Listing all students:");
        for (Student student : studentsList) {
            System.out.println(student.getName() + " (Student Number: " + student.getStudentNumber() + ", Grade: " + student.getGrade() + ")");
        }
    }

    // Mengganti nilai Student
    public void changeStudentGrade(String studentNumber, String newGrade) {
        for (Student student : studentsList) {
            if (student.getStudentNumber().equals(studentNumber)) {
                student.setGrade(newGrade);
                System.out.println("Grade updated for student number " + studentNumber + " to " + newGrade);
                return;
            }
        }
        System.out.println("Student not found with number " + studentNumber);
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nTeacher Menu");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Display All Students");
            System.out.println("4. Change Student Grade");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter student number: ");
                    String studentNumber = scanner.nextLine();
                    addStudent(new Student(studentName, studentNumber));
                    break;
                case 2:
                    System.out.print("Enter student number to remove: ");
                    String numberToRemove = scanner.nextLine();
                    removeStudent(numberToRemove);
                    break;
                case 3:
                    displayAllStudents();
                    break;
                case 4:
                    System.out.print("Enter student number to change grade: ");
                    String numberToChange = scanner.nextLine();
                    System.out.print("Enter new grade: ");
                    String newGrade = scanner.nextLine();
                    changeStudentGrade(numberToChange, newGrade);
                    break;
                case 5:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    public static ArrayList<Student> getStudentsList() {
        return studentsList;
    }

    public static ArrayList<Teacher> getTeachersList() {
        return teachersList;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }
}
