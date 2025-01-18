import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("$ ");
            String inputs = scanner.nextLine();
            System.out.println(inputs + ": command not found");
        }
    }
}
