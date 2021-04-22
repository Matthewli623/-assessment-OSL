import java.util.ArrayList;
import java.util.Scanner;

public class Store {
    public static void main(String args[]) {
        while (true) {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("SKUs Scanned : ");
            String input = keyboard.nextLine();
            if (input.trim().equalsIgnoreCase("exit")) {
                break;
            }

            ArrayList<PricingRule> pricingRules = new ArrayList<>();
            pricingRules.add(new BuyAndSetRule("Apple TV", "Apple TV", 3, 1, true, 0.0));
            pricingRules.add(new BuyAndSetRule("MacBook Pro", "VGA adapter", 1, 1, true, 0.0));
            pricingRules.add(new BuyAndSetThresholdRule("Super iPad", "Super iPad", ">", 4, 0, false, 50.0));
            Checkout co = new Checkout(pricingRules);

            GadgetFactory factory = new GadgetFactory();
            String[] SKUs = input.split(",");
            for (String SKU : SKUs) {
                co.scan(factory.getGadget(SKU.trim()));
            }
            System.out.println("Total expected : " + co.total());
        }
    }
}