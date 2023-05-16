import java.util.HashMap;
import java.util.Scanner;

public class Supplier {
    private long supplierid;
    private String name;
    private String address;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private int quantity;

 Scanner scanner = new Scanner(System.in);



    @Override
    public String toString() {
        return  supplierid +" "+name+" "+address +" ";
    }

    public long getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(long supplierid) {
        this.supplierid = supplierid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public Supplier(long supplierid, String name, String address) {
        this.supplierid = supplierid;
        this.name = name;
        this.address = address;
        System.out.println("Enter the no of quantity Supplier have");
        quantity=scanner.nextInt();
    }
}
