package lab11;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TemperatureApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Файл создаётся в корне проекта (не в пакете)
        Path path = Paths.get(System.getProperty("user.dir"), "temperatures.txt");

        List<Double> temperatures = new ArrayList<>();

        System.out.println("Введите 15 значений температуры воздуха (через Enter):");

        // Ввод 15 температур с клавиатуры
        for (int i = 0; i < 15; i++) {
            System.out.print("Температура " + (i + 1) + ": ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Ошибка: введите число!");
                scanner.next(); // пропустить неверный ввод
            }
            double temp = scanner.nextDouble();
            temperatures.add(temp);
        }

        try {
            // Преобразуем список температур в строки для записи
            StringBuilder data = new StringBuilder();
            for (Double t : temperatures) {
                data.append(t).append("\n");
            }

            // Записываем в файл в корне проекта
            Files.writeString(path, data.toString(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("\nФайл успешно создан: " + path.toAbsolutePath());

            // Чтение температур обратно из файла
            List<String> lines = Files.readAllLines(path);
            double sum = 0;
            int count = 0;

            for (String line : lines) {
                if (!line.isBlank()) {
                    sum += Double.parseDouble(line.trim());
                    count++;
                }
            }

            double average = sum / count;
            System.out.printf("Средняя температура: %.2f°C%n", average);

        } catch (IOException e) {
            System.err.println("Ошибка при работе с файлом:");
            e.printStackTrace();
        }
    }
}
