import Builtin.Type;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("$ ");
            String inputs = scanner.nextLine();
            String[] input = inputs.split(" ");
            String command = input[0];
            String argument = String.join(" ", Arrays.copyOfRange(input, 1, input.length));


            switch (command) {
                case "exit" -> System.exit(0);
                case "echo" -> System.out.println(argument);
                case "type" -> {
                    Type type = new Type();
                    type.isBuiltinOrPathOrNon(argument);
                }
                default -> System.out.println(inputs + ": command not found");
            }
        }
    }
}
