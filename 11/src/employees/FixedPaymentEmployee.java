package employees;

public class FixedPaymentEmployee extends Employee {
    private double fixedSalary;

    public FixedPaymentEmployee(int id, String name, double fixedSalary) {
        super(id, name);
        this.fixedSalary = fixedSalary;
    }

    @Override
    public double getAverageMonthlySalary() {
        return fixedSalary;
    }
}
