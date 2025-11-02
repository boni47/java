package company;

public class ShtatnySotrudnik extends Sotrudnik {
    private double premiya;

    public ShtatnySotrudnik(String fio, String dolzhnost, double oklad, double premiya) throws OkladException {
        super(fio, dolzhnost, oklad);
        this.premiya = premiya;
    }

    public double getPremiya() {
        return premiya;
    }

    public void setPremiya(double premiya) {
        this.premiya = premiya;
    }

    @Override
    public double rasschitatZarplatu() {
        try {
            if (premiya < 0) {
                throw new PremiyaException("Премия не может быть отрицательной: " + premiya);
            }

            double zarplata = getOklad() + premiya;
            System.out.println("Зарплата штатного сотрудника " + getFio() + ": " + zarplata);
            return zarplata;

        } catch (PremiyaException e) {
            System.out.println("Ошибка при расчете зарплаты: " + e.getMessage());
            return getOklad();
        } catch (Exception e) {
            System.out.println("Общая ошибка при расчете зарплаты: " + e.getMessage());
            return getOklad();
        }
    }
}