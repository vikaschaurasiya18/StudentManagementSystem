import java.util.ArrayList;

public class StudentManager {

    private ArrayList<Student> students;

    public StudentManager() {
        students = FileHandler.loadStudents();
    }

    public void addStudent(Student student) {

        if (findStudent(student.getId()) != null) {
            System.out.println("Student with this ID already exists.");
            return;
        }

        students.add(student);
        FileHandler.saveStudents(students);

        System.out.println("Student added successfully.");
    }

    public void viewStudents() {

        if (students.size() == 0) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n===== Student List =====");

        for (Student student : students) {
            student.displayStudent();
        }
    }

    public Student findStudent(int id) {

        for (Student student : students) {

            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }

    public void updateStudent(int id, String name, int age, String course) {

        Student student = findStudent(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        student.setName(name);
        student.setAge(age);
        student.setCourse(course);

        FileHandler.saveStudents(students);

        System.out.println("Student updated successfully.");
    }

    public void deleteStudent(int id) {

        Student student = findStudent(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        students.remove(student);

        FileHandler.saveStudents(students);

        System.out.println("Student deleted successfully.");
    }
}