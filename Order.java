import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    public long getOrderedId() {
        return orderedId;
    }

    public void setOrderedId(long orderedId) {
        this.orderedId = orderedId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOrderedStatus() {
        return orderedStatus;
    }

    public void setOrderedStatus(String orderedStatus) {
        this.orderedStatus = orderedStatus;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmountAfterDiscount() {
        return amountAfterDiscount;
    }

    public void setAmountAfterDiscount(double amountAfterDiscount) {
        this.amountAfterDiscount = amountAfterDiscount;
    }

    private long orderedId;
    private String date;
    private String orderedStatus;
    private double amount;
    private double amountAfterDiscount;
    private Scanner sc;
    static int customerid=1;
    static long itemid=21;
    private Customer customer;
    ArrayList<Item> items = new ArrayList<>() ;

   Order()
   {
       sc = new Scanner(System.in);
       System.out.println("Enter Your Name , DOB , Gender , Address , Phone and Emailid");
        customer = new Customer(sc.next(),sc.next(),sc.next(),String.valueOf(customerid++),sc.next(),sc.next(),sc.next());
       System.out.println("Enter the No of items");
       int n = sc.nextInt();
       for(int i=0 ;i < n ;i++) {
           System.out.println("Enter the ItemName and Price");
           items.add(new Item(itemid++,sc.next(),sc.nextDouble()));
       }
   }

    @Override
    public String toString() {
        return customer.toString()+orderedId+" "+date+" "+orderedStatus+" "+amount+" "+amountAfterDiscount+"\n"+items;
    }
}
