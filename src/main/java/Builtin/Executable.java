package Builtin;

import java.io.IOException;
import java.util.List;

public class Executable {
    public void execute(String command, String argument) throws IOException {
        // Used to create an executable process within System.
        List<String> commandToExecute = List.of(command, argument);
        ProcessBuilder pb = new ProcessBuilder(commandToExecute);
        pb.redirectErrorStream(true);
        Process process = pb.start();
        process.getInputStream().transferTo(System.out);
    }
}
