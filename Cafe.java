/**
 * Represents a cafe, which is a specific type of building for selling coffee.
 */
public class Cafe extends Building {
    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;

    /**
     * Constructs a new Cafe object with the given parameters.
     *
     * @param name               The name of the cafe.
     * @param address            The address of the cafe.
     * @param nFloors            The number of floors in the cafe.
     * @param initialCoffeeOunces The initial amount of coffee in ounces.
     * @param initialSugarPackets The initial number of sugar packets.
     * @param initialCreams       The initial number of cream "splashes".
     * @param initialCups         The initial number of cups.
     */
    public Cafe(String name, String address, int nFloors, int initialCoffeeOunces, int initialSugarPackets,
                int initialCreams, int initialCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = initialCoffeeOunces;
        this.nSugarPackets = initialSugarPackets;
        this.nCreams = initialCreams;
        this.nCups = initialCups;
    }

    /**
     * Sells a cup of coffee with the specified size and ingredients.
     *
     * @param size          The size of the coffee in ounces.
     * @param nSugarPackets The number of sugar packets.
     * @param nCreams       The number of cream "splashes".
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (nCups > 0) { // Check if there are available cups before selling coffee
            if (size <= nCoffeeOunces && nSugarPackets <= this.nSugarPackets && nCreams <= this.nCreams) {
                this.nCoffeeOunces -= size;
                this.nSugarPackets -= nSugarPackets;
                this.nCreams -= nCreams;
                this.nCups--;
                System.out.println("Coffee sold successfully!");
            } else {
                System.out.println("Insufficient inventory to sell coffee.");
                restock(size, nSugarPackets, nCreams, 1); // Restock with one cup
            }
        } else {
            System.out.println("No cups available to sell coffee.");
        }
    }

    /**
     * Sells a regular cup of coffee with the specified size, without sugar and cream
     *
     * @param size The size of the coffee in ounces.
     */
    public void sellCoffee(int size) {
        sellCoffee(size, 0, 0); // Call the original method with default values for sugar and cream
    }
    /**
     * Restocks the cafe with the specified quantities of coffee, sugar, cream, and cups.
     *
     * @param nCoffeeOunces   The quantity of coffee in ounces.
     * @param nSugarPackets   The quantity of sugar packets.
     * @param nCreams         The quantity of cream "splashes".
     * @param nCups           The quantity of cups.
     */
    public void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    /**
     * Restocks the cafe with the specified quantity of coffee.
     *
     * @param nCoffeeOunces The quantity of coffee in ounces.
     */
    public void restock(int nCoffeeOunces) {
        this.nCoffeeOunces += nCoffeeOunces;
    }

    /**
     * Navigates to the specified floor in the cafe, permitting movement only within the first floor.
     * Throws an exception if not inside the cafe or if trying to navigate to a floor other than the first floor.
     *
     * @param floorNum The floor number to navigate to.
     */
    @Override
    public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Cafe. Must call enter() before navigating between floors.");
        }
        if (floorNum != 1) {
            throw new RuntimeException("Cannot navigate to a floor other than the first floor in this Cafe.");
        }
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
    }

}
