public class Sugar extends Loot {
    private double amount, sweetness;

    public Sugar(double amount, double sweetness) {
        this.amount = amount;
        if (sweetness >= 0 && sweetness <= 100) {
            this.sweetness = sweetness;
        } else {
            this.sweetness = 0;
        }
        setValue(amount * sweetness);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Sugar) {
            Sugar sugar = (Sugar) obj;
            return super.equals(sugar) && this.amount == sugar.amount && this.sweetness == sugar.sweetness;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("A pile of sugar of size %.1f and sweetness %.1f.", amount, sweetness);
    }
}
