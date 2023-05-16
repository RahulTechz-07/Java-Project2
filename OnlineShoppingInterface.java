import java.util.ArrayList;
import java.util.HashMap;

public interface OnlineShoppingInterface {
    public boolean addOrder(Order o);
    public boolean cancelOrder(long orderId)throws OrderNotFound;
    public boolean cancelItem(long orderId,int itemId)throws OrderNotFound;
    public boolean fullfillOrder(long orderId)throws OrderAlreadyFullFilled,NotEnoughStock;
    public HashMap<Integer,Integer> getStockDetails();
    public ArrayList<Order> listOrderByPrice(String status);

}
