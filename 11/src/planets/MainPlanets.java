package planets;

import java.util.HashMap;
import java.util.Map;

public class MainPlanets {
    public static void main(String[] args) {
        Map<String, Planet> planetsMap = new HashMap<>();

        Mars mars = new Mars();
        Venus venus = new Venus();

        planetsMap.put(mars.getName(), mars);
        planetsMap.put(venus.getName(), venus);
        planetsMap.put("Earth", new Planet("Earth"));

        System.out.println("Ключи отображения:");
        for (String planetName : planetsMap.keySet()) {
            System.out.println(planetName);
        }

        System.out.println("\nПолная информация:");
        for (Map.Entry<String, Planet> entry : planetsMap.entrySet()) {
            System.out.println("Ключ: " + entry.getKey() + ", Значение: " + entry.getValue());
        }
    }
}