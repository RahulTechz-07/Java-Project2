public class ValueAdd extends Customer{
    private long bonusPoint;

    public long getBonusPoint() {
        return bonusPoint;
    }

    public void setBonusPoint(long bonusPoint) {
        this.bonusPoint = bonusPoint;
    }

    public ValueAdd(long bonusPoint) {
        this.bonusPoint = bonusPoint;
    }
    @Override
    public String toString() {
        return "" + bonusPoint ;
    }
}
