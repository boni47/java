package employees;

import java.util.List;

public class MainEmployees {
    public static void main(String[] args) {
        System.out.println("=== ЗАДАНИЕ 3: СТРОКИ И СОТРУДНИКИ ===\n");

        System.out.println("Часть 1: Работа со строками");
        String[] testStrings = {"string", "code", "Practice"};
        for (String str : testStrings) {
            String result = StringUtils.getMiddleChars(str);
            System.out.println("\"" + str + "\" → \"" + result + "\"");
        }

        System.out.println("\nЧасть 2: Система сотрудников");

        List<Employee> employees = EmployeeManager.createEmployees();

        System.out.println("До сортировки:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }

        EmployeeManager.sortEmployees(employees);

        EmployeeManager.printAllEmployees(employees);
        EmployeeManager.printFirstFiveNames(employees);
        EmployeeManager.printLastThreeIds(employees);
    }
}