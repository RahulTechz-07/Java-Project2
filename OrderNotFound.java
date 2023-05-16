public class OrderNotFound extends Exception{
    private String k;
    OrderNotFound(String k)
    {
        this.k=k;
    }

    @Override
    public String toString() {
        return "OrderNotFound{" +
                "k='" + k + '\'' +
                '}';
    }
}
