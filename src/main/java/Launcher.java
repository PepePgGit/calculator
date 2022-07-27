import java.io.File;
import java.math.BigDecimal;
import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        XmlHandler objs = new XmlHandler(new File("src\\main\\resources\\data.xml"));

        CurrencyData currencyData = new CurrencyData(objs.parseXml());

        System.out.println(currencyData.toString() + "\n");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("0 - if you want to quit");
            System.out.println("What currency do you need?");
            String input = scanner.nextLine();

            BigDecimal exchangeRate = currencyData.getCurrencyExchange().get(input);
            if (exchangeRate != null) {
                System.out.println("How many euro do you wish to exchange?");
                String input2 = scanner.nextLine();

                String result = Calculator.calculateAndRound(input2, exchangeRate);
                System.out.println(input2 + " EUR - " + result + " " + input + "\n");
            } else if (input.equals("0")) {
                break;
            } else {
                System.out.println("Not a valid option" + "\n");
            }
        }
    }
}
