import java.util.ArrayList;

/**
 * Zoo class.
 * @author somtochukwu Nwagbata
 * @version 1.0
 */
public class Zoo {
    private ArrayList<String> allowedTypes;
    private ArrayList<String> noisyAnimals;

    /**
     * Main method to run the program.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> allowedTypes = new ArrayList<String>() {
            {
                add("Hippo");
                add("Zebra");
                add("Elephant");
                add("Frog");
                add("Kangaroo");
                add("Lion");
                add("Tiger");
                add("Giraffe");
                add("Penguin");
                add("Dolphin");
            }
        };

        ArrayList<String> noisyAnimals = new ArrayList<String>() {
            {
                add("Frog");
                add("Zebra");
                add("Lion");
                add("Tiger");
                add("Giraffe");
                add("Penguin");
                add("Dolphin");

            }
        };
        Zoo zoo = new Zoo(allowedTypes, noisyAnimals);

        String[] animals = {"Lion", "Zebra", "Frog", "Elephant", "Hippo", "Kangaroo", "Tiger", "Giraffe", "Penguin",
            "Dolphin"};

        try {

            zoo.checkTypesOfAnimals(animals);

            zoo.createQuietExhibit(animals);

        } catch (NoisyExhibitException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Checked the zoo animals!");
        }
    }

    /**
     * Constructor for the Zoo class.
     * @param allowedTypes allowed types of animals in the zoo
     * @param noisyAnimals that are noisy
     */
    public Zoo(ArrayList<String> allowedTypes, ArrayList<String> noisyAnimals) {
        this.allowedTypes = allowedTypes;
        this.noisyAnimals = noisyAnimals;
    }

    /**
     * Checks if the animals in the array are allowed.
     * @param animals the animals to check
     * @throws AnimalNotAllowedException if the animals are not allowed
     */
    public void checkTypesOfAnimals(String[] animals) {
        for (String animal : animals) {
            if (!allowedTypes.contains(animal)) {
                try {
                    throw new AnimalNotAllowedException(String.format("A %s is not allowed at the zoo!", animal));
                } catch (AnimalNotAllowedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Checks if more than 6 of the animals in the array are noisy.
     * @param animals the animals to check
     * @return true if more than 6 of the animals are noisy
     */
    public boolean checkIfNoisy(String[] animals) {
        int c = 0;
        for (String animal : animals) {
            if (noisyAnimals.contains(animal)) {
                c++;
            }
        }
        return (c > 6);
    }

    /**
     * Creates a quiet exhibit.
     * @param animals the animals to add to the exhibit
     * @throws NoisyExhibitException if the exhibit is noisy
     * @return the exhibit
     */
    public ArrayList<String> createQuietExhibit(String[] animals) {
        ArrayList<String> quietExhibit = new ArrayList<String>();

        if (checkIfNoisy(animals)) {
            throw new NoisyExhibitException();
        } else {
            for (String animal : animals) {
                quietExhibit.add(animal);
            }
        }
        return quietExhibit;
    }

}