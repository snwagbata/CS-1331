public class HouseHunting {
    public static void main(String[] args) {
        House h1 = new House();
        House h2 = new House("Nigeria Ave", 1900, 5, true);
        House h3 = new House("Nigeria Ave", 5, 5, true);
        House h4 = new House("Nigeria Ave", 15, 5, true);
        House h5 = new House("Nigeria Ave", 2025, 5, true);
        House h6 = new House("Nigeria Ave", 2021, 5, true);

        Neighborhood Nigeria = new Neighborhood();

        House n = Nigeria.addHouse(0, h1);
        Nigeria.addHouse(2, h3);
        Nigeria.addHouse(3, h4);
        House l = Nigeria.addHouse(4, h5);
        h6.setNumBaths(2.9);
        House h = Nigeria.addHouse(6, h6);
        House g = Nigeria.addHouse(0, h3);
        System.out.println("House 0: " + h6.getNumBaths());
        Nigeria.displayNewHouses(-9);
    }
}
