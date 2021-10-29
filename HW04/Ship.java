/**
 * This class represents a ship on the high seas with cargo on board.
 * @author Somtochukwu Nwagbata
 * @version 1.0
 */
public class Ship implements Plunderable {
    private Loot[] cargo;
    private double totalCargoValue;
    private String name;

    /**
     * Constructor for objects of class Ship.
     * @param name The name of the ship.
     */
    public Ship(String name) {
        this.name = name;
        cargo = new Loot[10];
    }

    /**
     * No-param constructor for objects of class Ship.
     */
    public Ship() {
        this("Black Pearl");
    }

    /**
     * Adds a new piece of loot to the ship.
     * @param newItem The new piece of loot to be added.
     */
    public void addCargo(Loot newItem) {
        for (int i = 0; i < cargo.length; i++) {
            if (cargo[i] == null) {
                cargo[i] = newItem;
                totalCargoValue += newItem.getValue();
                break;
            }
        }
    }

    /**
     * Removes a piece of loot from the ship.
     * @return The removed piece of loot.
     */
    public Loot removeCargo() {
        Loot removedItem = null;
        for (int i = 0; i < cargo.length; i++) {
            if (cargo[i] != null) {
                removedItem = cargo[i];
                cargo[i] = null;
                totalCargoValue -= removedItem.getValue();
                break;
            }
        }
        return removedItem;
    }

    /**
     * Removes a specified loot from the ship.
     * @param carg The loot to be removed.
     * @return The removed loot.
     */
    public Loot removeCargo(Loot carg) {
        Loot removedItem = null;
        for (int i = 0; i < cargo.length; i++) {
            if (cargo[i].equals(carg)) {
                removedItem = cargo[i];
                cargo[i] = null;
                totalCargoValue -= carg.getValue();
                break;
            }
        }
        return removedItem;
    }

    /**
     * Plunders loot from the ship.
     * @return The plundered loot.
     */
    @Override
    public Loot[] bePlundered() {
        Loot[] loot = new Loot[cargo.length];
        int j = 0;
        for (int i = 0; i < cargo.length; i++) {
            // account for possible null cargo
            if (cargo[i] != null) {
                loot[j] = cargo[i];
                totalCargoValue -= cargo[i].getValue();
                cargo[i] = null;
                j++;
            }
        }
        Loot[] temp = new Loot[j];
        // No need to worry about out of bounds here as that's prevented above
        for (int i = 0; i < loot.length; i++) {
            if (loot[i] != null) {
                temp[i] = loot[i];
            }
        }

        return temp;
    }

    /**
     * String representation of the Ship.
     * @return string representation of the ship.
     */
    @Override
    public String toString() {
        String cargos = "";
        for (int i = 0; i < cargo.length; i++) {
            if (cargo[i] != null) {
                cargos += cargo[i].toString() + ", ";
            }
        }
        return String.format("A ship called %s with cargo %s which has a total value of %.2f.", name, cargos,
                totalCargoValue);
    }
}
