public class OrderAlreadyFullFilled extends Exception{
    private String k;
    public OrderAlreadyFullFilled(String message) {
        k=message;
    }

    @Override
    public String toString() {
        return "OrderAlreadyFullfilled{" +
                "k='" + k + '\'' +
                '}';
    }
}
