import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileHandler {

    private static final String FILE_NAME = "students.txt";

    public static void saveStudents(ArrayList<Student> students) {

        try {

            FileWriter fileWriter = new FileWriter(FILE_NAME);
            PrintWriter writer = new PrintWriter(fileWriter);

            for (Student student : students) {

                writer.println(
                        student.getId() + "|" +
                                student.getName() + "|" +
                                student.getAge() + "|" +
                                student.getCourse()
                );
            }

            writer.close();
            fileWriter.close();

        } catch (Exception e) {

            System.out.println("Error while saving students.");
        }
    }

    public static ArrayList<Student> loadStudents() {

        ArrayList<Student> students = new ArrayList<Student>();

        try {

            BufferedReader reader =
                    new BufferedReader(new FileReader(FILE_NAME));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split("\\|");

                if (data.length == 4) {

                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    int age = Integer.parseInt(data[2]);
                    String course = data[3];

                    Student student =
                            new Student(id, name, age, course);

                    students.add(student);
                }
            }

            reader.close();

        } catch (Exception e) {

            // File does not exist on first run.
        }

        return students;
    }
}