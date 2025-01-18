package Quoting;

public class Quotes {

    public int checkQuotes(String argument) {
        if(argument.startsWith("'") && argument.endsWith("'")) return 1;
        else if(argument.startsWith("\"") && argument.endsWith("\"")) return 2;
        else return 0;
    }
}
