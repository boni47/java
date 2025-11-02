package lab11;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class TextFileAnalyzer {
    public static void main(String[] args) {
        // Файл будет создан в корне проекта (не в пакете)
        Path path = Paths.get(System.getProperty("user.dir"), "text_file.txt");

        // Текст для записи — можно заменить на свой
        String text = """
                Привет, это тестовый файл.
                Он содержит несколько строк.
                Нужно подсчитать, сколько их здесь.
                Это простое задание по работе с файлами.
                Удачи в программировании на Java!
                """;

        try {
            // Создаём и записываем файл
            Files.writeString(path, text, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Файл создан: " + path.toAbsolutePath());

            // Считываем все строки из файла
            List<String> lines = Files.readAllLines(path);
            System.out.println("Количество строк в файле: " + lines.size());

            // Дополнительно выведем содержимое файла
            System.out.println("\n=== Содержимое файла ===");
            for (String line : lines) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.err.println("Ошибка при работе с файлом:");
            e.printStackTrace();
        }
    }
}
