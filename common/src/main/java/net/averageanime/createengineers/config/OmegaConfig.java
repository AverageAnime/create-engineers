package net.averageanime.createengineers.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.averageanime.createengineers.config.annotations.Description;
import net.averageanime.createengineers.platform.ConfigDirectory;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class OmegaConfig {

    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static <T extends Config> T register(Class<T> configClass) {
        try {
            T config = configClass.getDeclaredConstructor().newInstance();

            if (!configExists(config)) {
                config.save();
            } else {
                try {
                    List<String> lines = Files.readAllLines(getConfigPath(config));
                    lines.removeIf(line -> line.trim().startsWith("//"));
                    StringBuilder res = new StringBuilder();
                    lines.forEach(res::append);
                    T object = GSON.fromJson(res.toString(), configClass);

                    object.save();
                    return object;
                } catch (Exception e) {
                    net.averageanime.createengineers.CreateEngineers.LOGGER.error(e.toString());
                    net.averageanime.createengineers.CreateEngineers.LOGGER.info(String.format("Encountered an error while reading %s config, falling back to default values.", config.getName()));
                    net.averageanime.createengineers.CreateEngineers.LOGGER.info(String.format("If this problem persists, delete the config file %s and try again.", config.getName() + "." + config.getExtension()));
                }
            }

            return config;
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
                InvocationTargetException exception) {
            exception.printStackTrace();
            throw new RuntimeException("No valid constructor found for: " + configClass.getName());
        }
    }

    public static <T extends Config> void writeConfig(Class<T> configClass, T instance) {
        String json = GSON.toJson(instance);

        List<String> lines = new ArrayList<>(Arrays.asList(json.split("\n")));
        Map<Integer, String> insertions = new TreeMap<>();
        Map<String, String> keyToComments = new HashMap<>();

        for (Field field : configClass.getDeclaredFields()) {
            addFieldComments(field, keyToComments);
        }

        for (Class<?> innerClass : configClass.getDeclaredClasses()) {
            for (Field field : innerClass.getDeclaredFields()) {
                addFieldComments(field, keyToComments);
            }
        }

        for (int i = 0; i < lines.size(); i++) {
            String at = lines.get(i);

            for (Map.Entry<String, String> entry : keyToComments.entrySet()) {
                String key = entry.getKey();
                String comment = entry.getValue();

                if (at.trim().startsWith(String.format("\"%s\"", key))) {
                    insertions.put(i + insertions.size(), String.format("%s//%s", getStartingWhitespace(at), comment));
                    break;
                }
            }
        }

        for (Map.Entry<Integer, String> entry : insertions.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            lines.add(key, value);
        }

        StringBuilder res = new StringBuilder();
        lines.forEach(str -> res.append(String.format("%s%n", str)));

        try {
            Path configPath = getConfigPath(instance);
            configPath.toFile().getParentFile().mkdirs();
            Files.write(configPath, res.toString().getBytes());
        } catch (IOException ioException) {
            net.averageanime.createengineers.CreateEngineers.LOGGER.error(ioException.toString());
            net.averageanime.createengineers.CreateEngineers.LOGGER.info(String.format("Write error, using default values for config %s.", configClass));
        }
    }

    private static void addFieldComments(Field field, Map<String, String> keyToComments) {
        String fieldName = field.getName();
        Annotation[] annotations = field.getDeclaredAnnotations();

        // Find comment
        for (Annotation annotation : annotations) {
            if (annotation instanceof Description) {
                keyToComments.put(fieldName, ((Description) annotation).value());
                break;
            }
        }
    }

    private static String getStartingWhitespace(String input) {
        int index = -1;

        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char at = chars[i];

            if (at != ' ') {
                index = i;
                break;
            }
        }

        if (index != -1) {
            return input.substring(0, index);
        } else {
            return "";
        }
    }

    public static Path getConfigPath(Config config) {
        return Paths.get(ConfigDirectory.getConfigDirectory().toString(), config.getDirectory(), String.format("%s.%s", config.getName(), config.getExtension()));
    }

    public static boolean configExists(Config config) {
        return Files.exists(getConfigPath(config));
    }
}
