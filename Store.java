public class Store { 
    public static void main(String args[]) { 
        
        
        Checkout co = new Checkout(null);
        Gadget item1 = new Gadget("ipd","Super Ipad" , 549.99);
        Gadget item2 = new Gadget("ipd","Super Ipad" , 549.99);
        co.scan(item1);
        co.scan(item2);
        co.total();
    } 
}