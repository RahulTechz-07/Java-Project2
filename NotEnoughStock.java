public class NotEnoughStock extends Exception{
    private String k ;

    public NotEnoughStock(String message) {

        this.k = message;
    }

    @Override
    public String toString() {
        return "NotEnoughStock{" +
                "k='" + k + '\'' +
                '}';
    }
}
