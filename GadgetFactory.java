public class GadgetFactory {

    public Gadget getGadget(String SKU) {
        if (SKU == null) {
            return null;
        }
        if (SKU.equalsIgnoreCase("ipd")) {
            return new Gadget("ipd", "Super iPad", 549.99);
        } else if (SKU.equalsIgnoreCase("mbp")) {
            return new Gadget("mbp", "MacBook Pro", 1399.99);
        } else if (SKU.equalsIgnoreCase("atv")) {
            return new Gadget("atv", "Apple TV", 109.5);
        } else if (SKU.equalsIgnoreCase("vga")) {
            return new Gadget("vga", "VGA adapter", 30.0);
        }
        return null;
    }
}
