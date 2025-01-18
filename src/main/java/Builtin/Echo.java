package Builtin;

public class Echo {
    public void processArgument(String argument) {

        if (argument == null || argument.isEmpty()) {
            System.out.println("Error: Argument is null or empty.");
            return;
        }

        String toPrint = argument;
        if(argument.startsWith("'") && argument.endsWith("'")) {
            toPrint = argument.substring(1, argument.length() - 1);
        }
        System.out.println(toPrint);
    }
}
