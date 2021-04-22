import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

public class Checkout {

    private ArrayList<PricingRule> pricingRules;

    private Hashtable<String, ArrayList<Gadget>> cart;

    private Double total;

    public Checkout(ArrayList<PricingRule> pricingRules) {
        this.pricingRules = pricingRules;
        this.cart = new Hashtable();
        this.total = 0.0;
    }

    public void scan(Gadget gadget) {
        String name = gadget.getName();
        if (cart.containsKey(name)) {
            cart.get(name).add(gadget);
        } else {
            ArrayList<Gadget> gadgets = new ArrayList<>();
            gadgets.add(gadget);
            cart.put(name, gadgets);
        }
    }

    public String total() {
        // Apply each rule to all item in cart
        for (PricingRule rule : pricingRules) {
            rule.apply(cart);
        }

        Set<String> names = cart.keySet();
        // Sum all price of all gadget
        for (String name : names) {
            for (Gadget gadget : cart.get(name)) {
                total += gadget.getPrice();
            }
        }
        return String.format("%.2f", total);
    }

}
