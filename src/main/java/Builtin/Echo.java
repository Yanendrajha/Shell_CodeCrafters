package Builtin;

import Quoting.Quotes;

public class Echo {
    public void processArgument(String argument) {

        if (argument == null || argument.isEmpty()) {
            System.out.println("Error: Argument is null or empty.");
            return;
        }

        Quotes quotes = new Quotes();
        int quoteType = quotes.checkQuotes(argument);

        switch (quoteType) {
            case 1:
                String toPrint = argument.substring(1, argument.length() - 1);
                System.out.println(toPrint);
            case 2:
                System.out.println("double quoted");
            default:
                System.out.println("Error: Argument is not properly quoted.");
        }
    }
}
