package employees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeManager {

    public static List<Employee> createEmployees() {
        List<Employee> employees = new ArrayList<>();

        employees.add(new FixedPaymentEmployee(1, "Иван Иванов", 50000));
        employees.add(new FixedPaymentEmployee(2, "Петр Петров", 45000));
        employees.add(new FixedPaymentEmployee(3, "Мария Сидорова", 60000));
        employees.add(new HourlyPaymentEmployee(4, "Анна Козлова", 500, 90));
        employees.add(new HourlyPaymentEmployee(5, "Сергей Смирнов", 600, 80));
        employees.add(new FixedPaymentEmployee(6, "Ольга Новикова", 45000));
        employees.add(new HourlyPaymentEmployee(7, "Дмитрий Волков", 550, 85));
        employees.add(new FixedPaymentEmployee(8, "Елена Зайцева", 55000));
        employees.add(new HourlyPaymentEmployee(9, "Алексей Морозов", 480, 95));
        employees.add(new FixedPaymentEmployee(10, "Наталья Орлова", 60000));

        return employees;
    }

    public static void sortEmployees(List<Employee> employees) {
        Collections.sort(employees, (e1, e2) -> {
            int salaryCompare = Double.compare(e2.getAverageMonthlySalary(), e1.getAverageMonthlySalary());
            if (salaryCompare != 0) {
                return salaryCompare;
            }
            return e2.getName().compareTo(e1.getName());
        });
    }

    public static void printAllEmployees(List<Employee> employees) {
        System.out.println("Все сотрудники (отсортированы по убыванию зарплаты и имени в обратном алфавитном порядке):");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }

    public static void printFirstFiveNames(List<Employee> employees) {
        System.out.println("\nПервые 5 имен сотрудников:");
        for (int i = 0; i < Math.min(5, employees.size()); i++) {
            System.out.println((i + 1) + ". " + employees.get(i).getName());
        }
    }

    public static void printLastThreeIds(List<Employee> employees) {
        System.out.println("\nПоследние 3 ID сотрудников:");
        int startIndex = Math.max(0, employees.size() - 3);
        for (int i = startIndex; i < employees.size(); i++) {
            System.out.println("ID: " + employees.get(i).getId());
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = createEmployees();
        sortEmployees(employees);
        printAllEmployees(employees);
        printFirstFiveNames(employees);
        printLastThreeIds(employees);
    }
}
