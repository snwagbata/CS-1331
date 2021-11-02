import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class will hold various public static methods that will let you read and
 * write to the database.
 * @author Somtochukwu Nwagbata
 * @version 1.0
 */
public class Booking {
    /**
     * Main method to test the Booking class.
     * @param args command line arguments
     * @throws FileNotFoundException   if the file is not found
     * @throws InvalidBookingException if the booking is invalid
     */
    public static void main(String[] args) throws FileNotFoundException, InvalidBookingException {
        Flight a1 = new Flight("Braves", 64654, "09-29-2021", "0000", "1800", 0);
        Flight a2 = new Flight("Braves", 64954, "09-29-2021", "0020", "1500", 5);
        Bus b1 = new Bus("Braves", 74954, "09-29-2021", "0220", "1500", 5);
        Bus b2 = new Bus("Braves", 74954, "09-29-2021", "0920", "1500", 9);
        ArrayList<Transportation> j = outputBookings("Test.csv");
        j.add(a1);
        j.add(a2);
        j.add(b1);
        j.add(b2);
        for (Transportation transportation : j) {
            System.out.println(transportation);
        }
        System.out.println(writeBookings("Test4.csv", j));
    }

    /**
     * This method will read the file and return an ArrayList of Transportations.
     * @param file The name of the file to be read.
     * @return An ArrayList of Transportations.
     * @throws FileNotFoundException   If the file is not found.
     * @throws InvalidBookingException If the file is not in the correct format.
     */
    public static ArrayList<Transportation> outputBookings(String file)
            throws FileNotFoundException, InvalidBookingException {
        ArrayList<Transportation> bookings = new ArrayList<Transportation>();

        if (file == null) {
            throw new FileNotFoundException();
        }
        File f = new File(file);
        if (!f.exists()) {
            throw new FileNotFoundException();
        }
        Scanner input = new Scanner(new File(file));
        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] trans = line.split(",");

            // TA said I can assume input is always structured correctly
            if (trans[0].equals("Flight")) {
                Flight g = new Flight(trans[1], Integer.parseInt(trans[2]), trans[3], trans[4], trans[5],
                        Integer.parseInt(trans[6]));
                bookings.add(g);

            } else if (trans[0].equals("Bus")) {
                Bus j = new Bus(trans[1], Integer.parseInt(trans[2]), trans[3], trans[4], trans[5],
                        Integer.parseInt(trans[6]));
                bookings.add(j);

            } else {
                input.close();
                throw new InvalidBookingException();
            }
        }
        input.close();
        return bookings;
    }

    /**
     * Writes the ArrayList of Transportations to the file.
     * @param file     The name of the file to be written to.
     * @param bookings The ArrayList of Transportations to be written to the file.
     * @return true if the file was written successfully, false otherwise.
     * @throws FileNotFoundException   If the file is not found.
     * @throws InvalidBookingException If the file is not in the correct format.
     */
    public static boolean writeBookings(String file, ArrayList<Transportation> bookings)
            throws FileNotFoundException, InvalidBookingException {

        try {
            // the code I'm about to write is terribly inefficient, but oh well, not my
            // problem
            File n = new File(file);
            PrintWriter output = new PrintWriter(new File(file));

            if (n.exists()) {
                ArrayList<Transportation> f = outputBookings(n.getPath());

                for (Transportation t : f) {
                    output.println(t.toString());
                }
            }
            for (Transportation t : bookings) {
                output.println(t.toString());
                output.flush();
            }
            output.close();
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * This method will return an ArrayList of all lines that match the input.
     * @param file The name of the file to be read.
     * @param h    The input to match.
     * @return An ArrayList of lines that match the input.
     * @throws FileNotFoundException   If the file is not found.
     * @throws InvalidBookingException If the file is not in the correct format.
     */
    public static ArrayList<Integer> readBookings(String file, Transportation h)
            throws FileNotFoundException, InvalidBookingException {
        ArrayList<Transportation> bookings = outputBookings(file);
        ArrayList<Integer> bookingIndex = new ArrayList<Integer>();
        // outBooking will throw invalid booking
        try {
            if (!new File(file).exists()) {
                throw new FileNotFoundException();
            }

            for (int i = 0; i < bookings.size(); i++) {
                if (bookings.get(i).equals(h)) {
                    bookingIndex.add(i + 1); // Page line number does not start at 0
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return bookingIndex;
    }
}
