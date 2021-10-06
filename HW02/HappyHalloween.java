/**
 * This file defines the class HappyHalloween.
 * @author Somtochukwu Nwagbata
 * @version 1.0
 */
public class HappyHalloween {
    /**
     * This method prints the Happy Halloween message.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TrickOrTreater foo = new TrickOrTreater();
        TrickOrTreater bar = new TrickOrTreater();
        bar.seekCandy(420);
        foo.getName();
        BlackCat blackCat = new BlackCat("Pussy", false);
        BlackCat blackCat2 = new BlackCat("Meow", true);
        Witch witch = new Witch("Shark", "Eat", blackCat);
        Witch witch2 = new Witch(witch);
        witch2.setName("Sharky");
        witch.getCompanion().setName("Meow");
        System.out.println(witch2.getCompanion().getName());
        witch2.setCompanion(blackCat2);
        Ghost ghost = new Ghost("Ghosty", "Scary", 69, 9);
        Ghost ghost2 = new Ghost(ghost);
        ghost.seekCandy(420);
        ghost.setTransparency(1);
        ghost2.spook();
        ghost.seekCandy(7);
        ghost2.seekCandy(420);
        witch.seekCandy(69);
        System.out.println(ghost2.getNumCandy());
        System.out.println(witch.getNumCandy());
        System.out.println(TrickOrTreater.getTotalCandy());
    }
}