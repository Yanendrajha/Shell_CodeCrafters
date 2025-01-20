import Builtin.Echo;
import Builtin.Executable;
import Builtin.Type;
import Navigation.Cd;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        Cd cd = new Cd();

        while (true) {
            System.out.print("$ ");
            String inputs = scanner.nextLine();
            String[] input = inputs.split(" ");
            String command = input[0];
            String argument = String.join(" ", Arrays.copyOfRange(input, 1, input.length));

            switch (command) {
                case "exit" -> System.exit(0);
                case "echo" -> {
                    System.out.println(argument);
//                    Echo echo = new Echo();
//                    echo.processArgument(argument);
                }
                case "type" -> {
                    Type type = new Type();
                    type.isBuiltinOrPathOrNon(argument);
                }
                case "pwd" ->
                    // Cd has a method to get the current working dir
                        System.out.println(cd.getCwd());
                case "cd" ->
                    // Cd has a method to move to the desired directory.
                        cd.setCd(argument);
                default -> {
                    if (!argument.isEmpty()) {
                        Executable executable = new Executable();
                        executable.execute(command, argument);
                    } else {
                        System.out.println(command + ": command not found");
                    }
                }
            }
        }
    }
}
