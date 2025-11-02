package company;

public class SotrudnikPoKontraktu extends Sotrudnik {
    private int chasyRaboty;
    private double stavkaZaChas;

    public SotrudnikPoKontraktu(String fio, String dolzhnost, double oklad, int chasyRaboty, double stavkaZaChas) throws OkladException {
        super(fio, dolzhnost, oklad);
        this.chasyRaboty = chasyRaboty;
        this.stavkaZaChas = stavkaZaChas;
    }

    public int getChasyRaboty() {
        return chasyRaboty;
    }

    public void setChasyRaboty(int chasyRaboty) {
        this.chasyRaboty = chasyRaboty;
    }

    public double getStavkaZaChas() {
        return stavkaZaChas;
    }

    public void setStavkaZaChas(double stavkaZaChas) {
        this.stavkaZaChas = stavkaZaChas;
    }

    @Override
    public double rasschitatZarplatu() {
        try {
            if (chasyRaboty < 0) {
                throw new Exception("Часы работы не могут быть отрицательными: " + chasyRaboty);
            }
            if (stavkaZaChas < 0) {
                throw new Exception("Ставка за час не может быть отрицательной: " + stavkaZaChas);
            }

            double zarplata = getOklad() + (chasyRaboty * stavkaZaChas);
            System.out.println("Зарплата сотрудника по контракту " + getFio() + ": " + zarplata);
            return zarplata;

        } catch (Exception e) {
            System.out.println("Ошибка при расчете зарплаты: " + e.getMessage());
            return getOklad();
        }
    }
}