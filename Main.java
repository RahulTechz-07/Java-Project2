import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ch;
        try {
            OnlineShoppingSystem onlineShoppingSystem = new OnlineShoppingSystem();
            do {
                System.out.println("Enter 1 -------> Just add a Order");
                System.out.println("Enter 2 -------> Cancel a Order");
                System.out.println("Enter 3 -------> Cancel a Item in a particular Order");
                System.out.println("Enter 4 -------> Fullfill or Confirm the Order");
                System.out.println("Enter 5 -------> To get a Stock Details");
                System.out.println("Enter 6 -------> List the Order by price in particular status");
                System.out.println("Enter 7 -------> Exit");
                ch = scanner.nextInt();
                switch (ch) {
                    case 1:
                        Order order = new Order();
                        onlineShoppingSystem.addOrder(order);
                        System.out.println("Thanks for Adding the Order");
                        break;
                    case 2:
                        System.out.println("Please Enter the Order id");
                        onlineShoppingSystem.cancelOrder(scanner.nextInt());
                        System.out.println("Order is Sucessesfully Cancelled");
                        break;
                    case 3:
                        System.out.println("Please Enter the Orderid and ItemId");
                        onlineShoppingSystem.cancelItem(scanner.nextLong(), scanner.nextInt());
                        System.out.println("Orderid of the Particular Item is Sucessesfully Cancelled");
                        break;
                    case 4:
                        System.out.println("Please Enter the Orderid to Confirm ");
                        onlineShoppingSystem.fullfillOrder(scanner.nextLong());
                        System.out.println("Your order is Confirmed");
                        break;
                    case 5:
                        System.out.println("Details of Stock with Supplierid and Quantity ");
                        System.out.println(onlineShoppingSystem.getStockDetails());
                        break;
                    case 6:
                        System.out.println("Please Enter the status for List the Order by Price");
                        System.out.println(onlineShoppingSystem.listOrderByPrice(scanner.next()));
                        break;
                    case 7:
                        System.out.println("Thanks for Your Valuable Tine");
                        break;
                    default:
                        System.out.println("Invalid Choice");
                        break;
                }
            } while (ch != 7);
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }
}