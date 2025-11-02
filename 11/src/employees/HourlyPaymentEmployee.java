package employees;

public class HourlyPaymentEmployee extends Employee {
    private double hourlyRate;
    private double hoursWorked;

    public HourlyPaymentEmployee(int id, String name, double hourlyRate, double hoursWorked) {
        super(id, name);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double getAverageMonthlySalary() {
        return hourlyRate * hoursWorked;
    }
}
