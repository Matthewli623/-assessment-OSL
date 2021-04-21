import java.util.ArrayList;
import java.util.Hashtable;


public class Checkout  {
    
    private ArrayList<PricingRule> pricingRules;

    private Hashtable< Gadget , Integer> cart ;

    private Double total ;

    public Checkout(ArrayList<PricingRule> pricingRules){
        this.pricingRules = pricingRules;
        this.cart = new Hashtable();
        this.total = 0 ;
    }

    public void scan(Gadget gadget){
        if(cart.contains(gadget)){
            cart.put(gadget,cart.get(gadget)+1);
        }
        else{
            Integer quantity = 1;
            cart.put(gadget, quantity);
        }
    }

    public String total(){

        for (PricingRule rule: pricingRules){
            
        }
        return  String.format("%.2f", total);
    }

}
