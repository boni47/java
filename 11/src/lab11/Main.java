package lab11;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Main {
    public static void main(String[] args) {
        // Создаём файл внутри проекта (в корне проекта)
        Path path = Paths.get(System.getProperty("user.dir"), "my_info.txt");

        // Твоя информация — можешь отредактировать
        String info = "Имя: Иван Иванов\n" +
                "Возраст: 25\n" +
                "Город: Москва\n" +
                "Увлечения: программирование, чтение, спорт.\n";

        try {
            // Создаём или перезаписываем файл
            Files.writeString(path, info, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

            // Вывод информации о файле
            System.out.println("Файл создан в: " + path.toAbsolutePath());
            System.out.println("Размер (байт): " + Files.size(path));

            BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
            System.out.println("Время создания: " + attrs.creationTime());
            System.out.println("Время последней модификации: " + attrs.lastModifiedTime());
            System.out.println("Это обычный файл: " + attrs.isRegularFile());
            System.out.println("Это директория: " + attrs.isDirectory());

            // Вывод содержимого файла
            System.out.println("\n=== Содержимое файла ===");
            System.out.println(Files.readString(path));

        } catch (IOException e) {
            System.err.println("Ошибка при работе с файлом:");
            e.printStackTrace();
        }
    }
}
