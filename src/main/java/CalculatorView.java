import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorView {
    final static String END = "Finish";

    ArrayList<Product> products = new ArrayList<>();
    int guests;

    public void run() {
        sayHello();
        inputGuests();
        inputCostAndProducts();
        calculator();
    }

    private void sayHello() {
        System.out.println("Hello, how many people should I divide the bill into?");
    }


    public void inputGuests() {
        Scanner scanner = new Scanner(System.in);
        do {
            if (scanner.hasNextInt()) {
                guests = scanner.nextInt();
                if (guests == 1) {
                    System.out.println("Did you come alone? Then you don't need to count anything! :)");
                } else if (guests <= 0) {
                    System.out.println("Enter the correct value.");
                }
            } else {
                System.out.println("Wrong Input. Repeat please !");
            }
        }
        while (guests <= 1);
    }

    public void inputCostAndProducts() {
        Pattern numberPattern = Pattern.compile("(\\s-?\\d+\\.?\\d*)");
        String inputValue;
        Product product;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("Please write the name of the product and its cost in format {name} {price}. Example: Test 12.50");
            inputValue = in.nextLine();
            try {
                Matcher result = numberPattern.matcher(inputValue);
                if (result.find()) {
                    int start = result.start();
                    String name = inputValue.substring(0, start);
                    product = new Product(name, Double.parseDouble(result.group().trim()));
                    products.add(product);
                    System.out.println("Do you want to add more products? If not, write \"Finish\"");
                } else {
                    System.out.println("Enter the correct value.");
                }
            } catch (Exception e) {
                System.out.println("Wrong Input. Repeat please !");
            }
        }
        while (!inputValue.equalsIgnoreCase(END));
        products.forEach(System.out::println);
    }

    public void calculator() {
        double sum = 0;
        for (Product product : products) {
            sum += product.cost;
        }
        System.out.println("Summ " + Formatter.getFormattedRubles(sum));
        System.out.println("Divided Summ " + Formatter.getFormattedRubles(sum / guests));
    }
}