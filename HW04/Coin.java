public class Coin extends Loot {
    private boolean heads;
    private int yearMade;
    private String material;

    public Coin(double value, boolean heads, int yearMade, String material) {
        super(value);
        this.heads = heads;
        this.material = material;
        if (yearMade < 0 || yearMade > 1700) {
            this.yearMade = 1700;
        } else {
            this.yearMade = yearMade;
        }
    }

    public Coin(boolean heads, int yearMade) {
        this(((3000.0 - yearMade) / 100.0), heads, yearMade, "Gold");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Coin) {
            Coin other = (Coin) obj;
            return super.equals(other) && this.yearMade == other.yearMade && this.material.equals(other.material);
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("A %s coin made in %d. Heads side is up: %b", material, yearMade, heads);
    }
}
