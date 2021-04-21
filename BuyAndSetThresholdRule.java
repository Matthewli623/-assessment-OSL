import java.util.ArrayList;
import java.util.Hashtable;

public class BuyAndSetThresholdRule extends BuyAndSetRule {

    protected String operator ;

    public BuyAndSetThresholdRule(String buyName, String setName,String operator, int buyQuantityCondition,
            int setQuantityCondition, Boolean free, Double discountForEachItem) {
        super(buyName, setName, buyQuantityCondition, setQuantityCondition, free, discountForEachItem);
        this.operator = operator;
    }


    public void apply(Hashtable<String, ArrayList<Gadget>>  cart ){
        
        int buyCount = 0 ;
        if (cart.containsKey(buyName)){
            buyCount = cart.get(buyName).size();
        }

        if (cart.containsKey(setName)){
            ArrayList<Gadget> setList =  cart.get(setName);
            //Find the no of item that need to process
            int setCount = 0;
            switch(operator){
                case ">":
                    if(buyCount>buyQuantityCondition){
                        setCount = setList.size();
                    }
                    break;
                case "<":
                    if(buyCount<buyQuantityCondition){
                        setCount = setList.size();
                    }
                    break;
            }
            int processedCount = 0;
            while(processedCount<setCount && processedCount < setList.size()){
                // item may processed or free before
                Double newPrice ;
                if(free){
                    newPrice = 0.0;
                }
                else{
                    newPrice = setList.get(processedCount).getPrice()-discountForEachItem;
                }
                setList.get(processedCount).applyDiscount(newPrice);
                processedCount++;
            }
        }
        
    }
}
