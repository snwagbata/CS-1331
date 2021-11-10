/**
 * This class will consist of different functions related to dealing with money.
 * @author Somtochukwu Nwagbata
 * @version 1.0
 */
public class Money {
    /**
     * Iterate through the array and return the sum of the array.
     * @param money The array of cents to be added.
     * @return The total amount of cents.
     */
    public static double countTotal(int[] money) {
        return total(money, 0);
    }

    /***
     * Helper method to count the total amount of money.
     * @param money The array of cents.
     * @param index The index of the array.
     * @return The total amount of money.
     */
    public static double total(int[] money, int index) {
        if (money.length == 0 || index == money.length) {
            return 0;
        }
        if (money.length == 1) {
            return money[0] / 100.0;
        }
        return money[index] / 100.0 + total(money, index + 1);
    }

    /**
     * Subtract the cost of product from the total amount of money received.
     * @param price The cost of the product.
     * @param cents The total amount of money received.
     * @return The amount of money left after subtracting the cost of the product.
     */
    public static double findDifference(double price, int[] cents) {
        return price - total(cents, 0);
    }

    /**
     * Count the amount of coins needed to give change.
     * @param cents The amount of money to be given change.
     * @return The amount of coins needed to give change.
     */
    public static int makeChange(int cents) {
        int[] money = {25, 10, 5, 1};
        return makeChange(cents, money);
    }

    /**
     * This function will convert the amount of money into the equivalent number of
     * coins.
     * @param cents The amount of money to be converted.
     * @param money The array of coins to be used.
     * @return The number of coins that can be used to make up the amount of money.
     */
    public static int makeChange(int cents, int[] money) {
        if (cents == 0) {
            return 0;
        }
        if (cents < 0) {
            return -1;
        }
        if (money.length == 0) {
            return -1;
        }
        if (money.length == 1) {
            return cents / money[0];
        }
        int min = makeChange(cents - money[0], money);
        if (min != -1) {
            return 1 + min;
        }
        int[] newArr = new int[money.length - 1];
        for (int i = 1; i < money.length; i++) {
            newArr[i - 1] = money[i];
        }
        return makeChange(cents, newArr);
    }
}
