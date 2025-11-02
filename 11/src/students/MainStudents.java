package students;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class MainStudents {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Иван Иванов", "ГР-101", 1, Arrays.asList(4, 5, 3, 4)));
        students.add(new Student("Петр Петров", "ГР-101", 1, Arrays.asList(2, 3, 2, 2)));
        students.add(new Student("Мария Сидорова", "ГР-102", 1, Arrays.asList(5, 5, 5, 4)));
        students.add(new Student("Анна Козлова", "ГР-102", 1, Arrays.asList(3, 3, 4, 3)));
        students.add(new Student("Сергей Смирнов", "ГР-103", 2, Arrays.asList(2, 2, 3, 2)));

        System.out.println("Исходный список студентов:");
        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println("\n--- Обработка студентов ---");
        StudentManager.processStudents(students);

        System.out.println("\n--- Результат после обработки ---");
        for (Student student : students) {
            System.out.println(student);
        }

        StudentManager.printStudents(students, 2);
        StudentManager.printStudents(students, 3);
    }
}