public abstract class Loot {
    private double value;

    public Loot(double value) {
        if (value > 0) {
            this.value = value;
        }
    }

    public Loot() {
        this.value = 0;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Loot) {
            return ((Loot) obj).value == this.value;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("A piece of loot worth %.2f", value);
    }

}
