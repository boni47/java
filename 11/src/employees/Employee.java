package employees;

public abstract class Employee implements Comparable<Employee> {
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public abstract double getAverageMonthlySalary();

    @Override
    public String toString() {
        return "ID: " + id + ", Имя: " + name + ", Средняя зарплата: " + getAverageMonthlySalary();
    }

    @Override
    public int compareTo(Employee other) {
        int salaryCompare = Double.compare(other.getAverageMonthlySalary(), this.getAverageMonthlySalary());
        if (salaryCompare != 0) {
            return salaryCompare;
        }
        return other.getName().compareTo(this.getName());
    }
}
