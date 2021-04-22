import java.util.ArrayList;
import java.util.Hashtable;

public class BuyAndSetRule extends PricingRule {

    protected String buyName;
    protected String setName;

    protected int buyQuantityCondition;
    protected int setQuantityCondition;

    protected Double discountForEachItem;

    protected boolean free;

    public BuyAndSetRule(String buyName, String setName, int buyQuantityCondition, int setQuantityCondition,
            Boolean free, Double discountForEachItem) {
        this.buyName = buyName;
        this.setName = setName;
        this.buyQuantityCondition = buyQuantityCondition;
        this.setQuantityCondition = setQuantityCondition;
        this.discountForEachItem = discountForEachItem;
        this.free = free;
    }

    public void apply(Hashtable<String, ArrayList<Gadget>> cart) {

        int buyCount = 0;
        if (cart.containsKey(buyName)) {
            buyCount = cart.get(buyName).size();
        }

        if (cart.containsKey(setName)) {
            ArrayList<Gadget> setList = cart.get(setName);
            // Calculate the no of item that need to process
            int setCount;
            setCount = (buyCount / buyQuantityCondition) * setQuantityCondition;

            int processedCount = 0;
            while (processedCount < setCount && processedCount < setList.size()) {
                Double newPrice;
                if (free) {
                    newPrice = 0.0;
                } else {
                    newPrice = setList.get(processedCount).getPrice() - discountForEachItem;
                }
                setList.get(processedCount).applyDiscount(newPrice);
                processedCount++;
            }
        }

    }
}
