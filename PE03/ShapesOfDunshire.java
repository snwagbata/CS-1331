import java.util.Random;

public class ShapesOfDunshire {
    public static void main(String[] args) {
        Random rand = new Random();

        double sRadius = 0;
        double sVolume = 0;
        double cyRadius = 0;
        double cyHeight = 0;
        double cyVolume = 0;
        double coRadius = 0;
        double coHeight = 0;
        double coVolume = 0;
        double finalVolume = 0;

        int numPieces = rand.nextInt(10) + 10;
        System.out.printf("Creating Shapes of Dunshire game with %d pieces.\n", numPieces);

        for (int i = 0; i < numPieces; i++) {
            int shapeType = rand.nextInt(3) + 1;

            switch (shapeType) {
                case 1:
                    sRadius = Math.round((rand.nextDouble() * 5.0 + 5.0) * 100.0) / 100.0;
                    sVolume = Math.round(((4.0 / 3) * Math.PI * Math.pow(sRadius, 3)) * 100.0) / 100.0;
                    finalVolume += sVolume;
                    System.out.printf(
                            "Manufacturing shape of type: %d and volume: %.2f cm3. Dimensions: radius = %.2f cm.\n",
                            shapeType, sVolume, sRadius);
                    break;
                case 2:
                    cyRadius = Math.round((rand.nextDouble() * 5.0 + 5.0) * 100.0) / 100.0;
                    cyHeight = Math.round((rand.nextDouble() * 7.0 + 6.0) * 100.0) / 100.0;

                    cyVolume = Math.round((Math.PI * cyHeight * Math.pow(cyRadius, 2)) * 100.0) / 100.0;
                    finalVolume += cyVolume;

                    System.out.printf(
                            "Manufacturing shape of type: %d and volume: %.2f cm3. Dimensions: radius = %.2f cm and height = %.2f cm.\n",
                            shapeType, cyVolume, cyRadius, cyHeight);
                    break;

                case 3:
                    coRadius = Math.round((rand.nextDouble() * 5.0 + 5.0) * 100.0) / 100.0;
                    coHeight = Math.round((rand.nextDouble() * 7.0 + 6.0) * 100.0) / 100.0;

                    coVolume = Math.round(((1.0 / 3.0) * Math.PI * coHeight * Math.pow(coRadius, 2)) * 100.0) / 100.0;
                    finalVolume += coVolume;
                    System.out.printf(
                            "Manufacturing shape of type: %d and volume: %.2f cm3. Dimensions: radius = %.2f cm and height = %.2f cm.\n",
                            shapeType, coVolume, coRadius, coHeight);
                    break;
            }

        }

        double price = finalVolume * .55;
        System.out.printf("Total cost of manufacturing %d pieces, worth %.2f cm3 plastic, is $%.2f.\n", numPieces,
                finalVolume, price);
    }
}