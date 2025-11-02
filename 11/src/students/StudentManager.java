package students;

import java.util.Iterator;
import java.util.List;

public class StudentManager {

    public static void processStudents(List<Student> students) {
        Iterator<Student> iterator = students.iterator();

        while (iterator.hasNext()) {
            Student student = iterator.next();
            double averageGrade = student.getAverageGrade();

            if (averageGrade < 3.0) {
                iterator.remove();
                System.out.println("Студент " + student.getName() + " отчислен (средний балл: " + String.format("%.2f", averageGrade) + ")");
            } else {
                student.setCourse(student.getCourse() + 1);
                System.out.println("Студент " + student.getName() + " переведен на " + student.getCourse() + " курс (средний балл: " + String.format("%.2f", averageGrade) + ")");
            }
        }
    }

    public static void printStudents(List<Student> students, int course) {
        System.out.println("\nСтуденты " + course + " курса:");
        boolean found = false;

        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println("- " + student.getName() + " (группа: " + student.getGroup() + ", средний балл: " + String.format("%.2f", student.getAverageGrade()) + ")");
                found = true;
            }
        }

        if (!found) {
            System.out.println("Студентов на " + course + " курсе не найдено.");
        }
    }
}