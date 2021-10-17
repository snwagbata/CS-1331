public class Ship implements Plunderable {
    private Loot[] cargo;
    private double totalCargoValue;
    private String name;

    public Ship(String name) {
        this.name = name;
        cargo = new Loot[10];
    }

    public Ship() {
        this("Black Pearl");
    }

    public void addCargo(Loot newItem) {
        for (int i = 0; i < cargo.length; i++) {
            if (cargo[i] == null) {
                cargo[i] = newItem;
                totalCargoValue += newItem.getValue();
                break;
            }
        }
    }

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

    @Override
    public Loot[] bePlundered() {
        //TODO: fix to past tests
        Loot[] loot = new Loot[cargo.length];
        for (int i = 0; i < cargo.length; i++) {
            loot[i] = cargo[i];
            totalCargoValue -= loot[i].getValue();
            cargo[i] = null;
        }
        return loot;
    }

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
