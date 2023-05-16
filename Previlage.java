public class Previlage extends Customer{
    private double discountPercent=15.25;

    public Previlage(double discountPercent) {
        this.discountPercent = discountPercent;
    }



    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    @Override
    public String toString() {
        return ""+discountPercent;
    }
}
