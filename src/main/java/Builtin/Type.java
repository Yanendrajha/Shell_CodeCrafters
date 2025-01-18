package Builtin;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Type {

    List<String> builtin;

    public Type() {
        builtin = new ArrayList<>(Arrays.asList("echo", "type", "exit", "pwd", "cd"));
    }

    private void hasPath(String argument) {

        String path = getPath(argument);

        if (path == null) {
            System.out.println(argument + ": not found");
        } else {
            System.out.println(argument + " is " + path);
        }
    }

    private String getPath(String argument) {
        for (String path : System.getenv("PATH").split(":")) {
            Path fullPath = Path.of(path, argument);
            if (Files.isRegularFile(fullPath)) {
                return fullPath.toString();
            }
        }
        return null;
    }

    public void isBuiltinOrPathOrNon(String argument) {
        boolean isBuiltin =  builtin.contains(argument);
        if(isBuiltin) System.out.println(argument + " is a shell builtin");
        else hasPath(argument);
    }
}

