import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentManager manager = new StudentManager();

        int choice;

        do {

            System.out.println("\n================================");
            System.out.println("     STUDENT MANAGEMENT SYSTEM");
            System.out.println("================================");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.println("================================");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.println("\n--- Add Student ---");

                    System.out.print("Enter student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter student age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter student course: ");
                    String course = sc.nextLine();

                    Student student =
                            new Student(id, name, age, course);

                    manager.addStudent(student);

                    break;

                case 2:

                    manager.viewStudents();

                    break;

                case 3:

                    System.out.println("\n--- Update Student ---");

                    System.out.print("Enter student ID: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter new age: ");
                    int newAge = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new course: ");
                    String newCourse = sc.nextLine();

                    manager.updateStudent(
                            updateId,
                            newName,
                            newAge,
                            newCourse
                    );

                    break;

                case 4:

                    System.out.println("\n--- Delete Student ---");

                    System.out.print("Enter student ID: ");
                    int deleteId = sc.nextInt();

                    manager.deleteStudent(deleteId);

                    break;

                case 5:

                    System.out.println(
                            "Thank you for using Student Management System."
                    );

                    break;

                default:

                    System.out.println(
                            "Invalid choice. Please try again."
                    );
            }

        } while (choice != 5);

        sc.close();
    }
}