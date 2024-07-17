import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class CurrencyConverterApp {

    private static final String API_KEY = "2b91ecdb76d0dc1328cfa456";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    public static void main(String[] args) {
        int option = 0;

        System.out.println("**********************************************************");
        System.out.println("\nWelcome to the Currency Converter\n");

        String menu = """
                1) USD --> ARS
                2) ARS --> USD
                3) USD --> BRL
                4) BRL --> USD
                5) USD --> COP
                6) COP --> USD
                7) Exit
                """;

        System.out.println("**********************************************************\n");

        Scanner scanner = new Scanner(System.in);
        while (option != 7) {
            // Display options to the user
            System.out.println(menu);
            System.out.println("\nChoose an option:");
            System.out.println("\n**********************************************************");
            option = scanner.nextInt();
            // Condition with a message when the user chooses option 7
            if (option == 7) {
                System.out.println("Thank you for using the application...");
                break;
            }

            // Ask for the amount to convert
            System.out.println("Enter the amount to convert: ");
            double amount = scanner.nextDouble();

            try {
                switch (option) {
                    case 1 -> convertCurrency("USD", "ARS", amount);
                    case 2 -> convertCurrency("ARS", "USD", amount);
                    case 3 -> convertCurrency("USD", "BRL", amount);
                    case 4 -> convertCurrency("BRL", "USD", amount);
                    case 5 -> convertCurrency("USD", "COP", amount);
                    case 6 -> convertCurrency("COP", "USD", amount);
                    default -> System.out.println("Invalid option");
                }
            } catch (IOException | InterruptedException e) {
                System.out.println("Error performing the conversion: " + e.getMessage());
            }
        }
        scanner.close();
    }

    public static void convertCurrency(String fromCurrency, String toCurrency, double amount) throws IOException, InterruptedException {
        String url = API_URL + fromCurrency;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        CurrencyUtil currencyUtil = new CurrencyUtil();
        double exchangeRate = currencyUtil.getExchangeRate(response.body(), toCurrency);
        if (exchangeRate == 0) {
            System.out.println("Conversion rate not available.");
        } else {
            double result = amount * exchangeRate;
            System.out.println("The amount " + amount + " (" + fromCurrency + ")" + " is equivalent to --> " + result + " (" + toCurrency + ")\n");
        }
    }
}
