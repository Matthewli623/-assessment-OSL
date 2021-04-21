import java.util.ArrayList;
import java.util.Hashtable;

abstract class PricingRule {
    abstract void apply(Hashtable<String, ArrayList<Gadget>> cart);
}