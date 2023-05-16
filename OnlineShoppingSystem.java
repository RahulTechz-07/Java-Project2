import java.util.*;
import java.util.stream.Collectors;

public class OnlineShoppingSystem implements OnlineShoppingInterface{
    private final ArrayList<Order> orders = new ArrayList<Order>();
    static int i=0;
    private final ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
    private final Scanner scanner = new Scanner(System.in);
    static long orderId=212;
    @Override
    public boolean addOrder(Order o) {
        o.setOrderedId(orderId++);
        Date date = new Date();
        o.setDate(date.getDate()+"/"+date.getMonth()+"/"+date.getYear());
        int n = o.items.size();
        double s=0;
        for(Item i : o.items)
            s+=i.getPrice();
        o.setOrderedStatus("In-Progress");
        o.setAmount(s);
        System.out.println("Customer id  Name  DOB  Gender  PhNo Address  Email  Orderid  Date  OrderStatus  Amount  AmountAfterDiscount");
        System.out.println(o);
       orders.add(o);
       return true;
    }

    @Override
    public boolean cancelOrder(long orderId) throws OrderNotFound {

        for (Order k : orders)
            if(k.getOrderedId()==orderId)
            {
                orders.remove(k);
                return true;
            }
        throw new OrderNotFound("Order Doest'Exist");

    }

    @Override
    public boolean cancelItem(long orderId, int itemId) throws OrderNotFound {
      for(Order i : orders)
          if(orderId == i.getOrderedId())
          {
              for (Item j : i.items)
                  if(itemId==j.getItemid()) {
                      i.items.remove(j);
                      return true;
                  }
          }
    throw   new OrderNotFound("Order Not Exits");
    }

    @Override
    public boolean fullfillOrder(long orderId) throws OrderAlreadyFullFilled, NotEnoughStock {
        for(Order i : orders)
            if(orderId==i.getOrderedId() && i.getOrderedStatus().equals("fullfilled"))
                throw new OrderAlreadyFullFilled("Alrready FullFilled");
        double s=0;
        for(Order i : orders)
            if(orderId==i.getOrderedId())
            {
                for(Item j : i.items) {
                   System.out.println("Please Enter the quantity of "+j.getName()+"to fullfill the order");
                   int n = scanner.nextInt();
                    int qt =j.getSupplier().getQuantity();
                    if(n>qt)
                       throw new NotEnoughStock("Not enough stock");
                   s+=n* j.getPrice();
                   j.getSupplier().setQuantity(qt-n);
                }
            }
        for(Order i: orders)
            if(orderId==i.getOrderedId()) {
                i.setAmount(s);
                i.setOrderedStatus("fullfilled");

                System.out.println("Please enter you are Privilage customer for ---> 1\nvalue added Customer for --->2");
                int k = scanner.nextInt();
                if (k == 1)
                    i.setAmountAfterDiscount(i.getAmount() - new Previlage(15.25).getDiscountPercent());
                else
                {
                    double amount = i.getAmount();
                    if(amount<1000)
                        i.setAmountAfterDiscount(amount);
                    else if(amount<=2000)
                    {
                        ValueAdd  valueAdd= new ValueAdd(50);
                        for(int l=1;l<=10;l++)
                        {
                        if(amount / 100 * l <valueAdd.getBonusPoint())
                            i.setAmountAfterDiscount(amount -amount / 100 * l );
                        }
                    } else if (amount<=5000) {
                        ValueAdd  valueAdd= new ValueAdd(100);
                        for(int l=1;l<=10;l++)
                        {
                            if(amount / 100 * l <valueAdd.getBonusPoint())
                                i.setAmountAfterDiscount(amount -amount / 100 * l );
                        }
                    } else if (amount<=10000) {
                        ValueAdd  valueAdd= new ValueAdd(200);
                        for(int l=1;l<=10;l++)
                        {
                            if(amount / 100 * l <valueAdd.getBonusPoint())
                                i.setAmountAfterDiscount(amount - amount / 100 * l );
                        }
                    }
                    else
                    {
                        ValueAdd  valueAdd= new ValueAdd(300);
                        int f=0;
                        for(int l=1;l<=10;l++)
                        {
                            if(amount / 100 * l <valueAdd.getBonusPoint()) {
                            f=1;
                                i.setAmountAfterDiscount(amount - amount / 100 * l);
                            }

                        }
                        if(f==0)
                            i.setAmountAfterDiscount(amount);
                    }
                }
                System.out.println(i);
            }
        return true;
    }


    @Override
    public HashMap<Integer, Integer> getStockDetails() {
    HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(Order i : orders)
        {
            for(Item j : i.items)
                hashMap.put((int)j.getSupplier().getSupplierid(),j.getSupplier().getQuantity());
        }
        return hashMap;
    }

    @Override
    public ArrayList<Order> listOrderByPrice(String status) {
        return (ArrayList<Order>)orders.stream().filter(x -> x.getOrderedStatus().equals(status)).sorted((a,b) -> Double.compare(b.getAmount(),a.getAmount())).collect(Collectors.toList());
    }
}
