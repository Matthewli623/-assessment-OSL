import java.util.Hashtable;
public interface PricingRule {
    public Double apply(Hashtable< Gadget , Integer>  cart);
}