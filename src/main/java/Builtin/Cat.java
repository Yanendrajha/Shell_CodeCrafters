package Builtin;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cat {
    public void processArgument(String argument) throws FileNotFoundException {
        if (argument == null || argument.isEmpty()) {
            System.out.println("Error: Argument is null or empty.");
            return;
        }
        printSingleQuote(argument);
    }

    // printing the content inside the file.
    private void printSingleQuote(String argument) {
        List<String> paths = getPath(argument);
        for (String path : paths) {
            Path validatePath = Paths.get(path);
            if (Files.exists(validatePath) && Files.isRegularFile(validatePath)) {
                try (BufferedReader reader = new BufferedReader(new FileReader(validatePath.toString()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    System.err.println("An error occurred while reading the file: " + e.getMessage());
                }
            }
        }
    }

    // finding the path required;
    private List<String> getPath(String argument) {
        String regex = "'([^']*)'|\\S+";
        List<String> paths = new ArrayList<>();

        Matcher matcher = Pattern.compile(regex).matcher(argument);
        while (matcher.find()) {
            // matcher.group(1) corresponds to paths in single quotes
            if (matcher.group(1) != null) {
                paths.add(matcher.group(1));
            } else {
                // Paths without quotes
                paths.add(matcher.group());
            }
        }
        return paths;
    }
}
