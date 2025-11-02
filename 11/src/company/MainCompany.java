package company;

public class MainCompany {
    public static void main(String[] args) {
        System.out.println("=== СИСТЕМА ПРЕДПРИЯТИЯ С ОБРАБОТКОЙ ИСКЛЮЧЕНИЙ ===\n");

        // Создание фирмы и отдела
        Firma firma = new Firma("ООО ТехноПро");
        Otdel otdel = new Otdel("IT отдел", 5);

        System.out.println("Фирма: " + firma.getNazvanie());
        System.out.println("Отдел: " + otdel.getNazvanie() + ", сотрудников: " + otdel.getKolichestvoSotrudnikov());

        System.out.println("\n--- Тестирование расчета зарплаты ---");

        // Тестирование штатного сотрудника с нормальной премией
        try {
            ShtatnySotrudnik shtatny1 = new ShtatnySotrudnik("Иван Иванов", "Программист", 50000, 10000);
            shtatny1.rasschitatZarplatu();
        } catch (OkladException e) {
            System.out.println("Ошибка создания сотрудника: " + e.getMessage());
        }

        // Тестирование штатного сотрудника с отрицательной премией
        try {
            ShtatnySotrudnik shtatny2 = new ShtatnySotrudnik("Петр Петров", "Аналитик", 45000, -5000);
            shtatny2.rasschitatZarplatu();
        } catch (OkladException e) {
            System.out.println("Ошибка создания сотрудника: " + e.getMessage());
        }

        // Тестирование сотрудника по контракту
        try {
            SotrudnikPoKontraktu kontrakt1 = new SotrudnikPoKontraktu("Мария Сидорова", "Дизайнер", 30000, 160, 500);
            kontrakt1.rasschitatZarplatu();
        } catch (OkladException e) {
            System.out.println("Ошибка создания сотрудника: " + e.getMessage());
        }

        System.out.println("\n--- Тестирование исключения OkladException ---");

        // Попытка создать сотрудника с отрицательным окладом
        try {
            Sotrudnik invalidSotrudnik = new Sotrudnik("Ошибка Тестович", "Тестер", -10000);
        } catch (OkladException e) {
            System.out.println("Невозможно создать сотрудника – указан отрицательный оклад: " + e.getInvalidOklad());
            // Повторно создаем исключение (как требуется в задании)
            try {
                throw new OkladException("Повторное исключение: " + e.getMessage(), e.getInvalidOklad());
            } catch (OkladException e2) {
                System.out.println("Повторно обработанное исключение: " + e2.getMessage());
            }
        }
    }
}