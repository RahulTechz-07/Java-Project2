import java.util.Scanner;

public class Item {
    private long itemid;
    private String name;
    private double price;
    private static long supplierid=1000;
    private Supplier supplier;

    public Item(long itemid, String name, double price) {
        Scanner scanner = new Scanner(System.in);
        this.itemid = itemid;
        this.name = name;
        this.price = price;
        System.out.println("Enter the Supplier Name and Address");
        supplier = new Supplier(supplierid++,scanner.next(),scanner.next());
    }

    public long getItemid() {
        return itemid;
    }

    public void setItemid(long itemid) {
        this.itemid = itemid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return itemid+" "+name+" "+price+" "+ supplier;
    }
}
