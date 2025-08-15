package utils;

import java.util.Map;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

public class JsonDataReader {
    private static String getEnv() {
        String env = System.getProperty("env");
        if (env == null || env.isEmpty()) {
            env = System.getenv("ENV");
        }
        if (env == null || env.isEmpty()) {
            env = System.getProperty("serenity.environment");
        }
        if (env == null || env.isEmpty()) {
            env = "uat"; // default
        }
        return env;
    }

    public static Map<String, Object> readJson(String fileName) {
        List<Map<String, Object>> all = readJsonList(fileName);
        return all.isEmpty() ? null : all.get(0);
    }

    public static List<Map<String, Object>> readJsonList(String fileName) {
        try {
            String env = getEnv();
            String path = "src/test/resources/environments/testData/" + env + "/" + fileName;
            String json = new String(Files.readAllBytes(Paths.get(path)));
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json, new TypeReference<List<Map<String, Object>>>() {});
        } catch (Exception e) {
            throw new RuntimeException("Failed to read test data from " + fileName, e);
        }
    }
}

